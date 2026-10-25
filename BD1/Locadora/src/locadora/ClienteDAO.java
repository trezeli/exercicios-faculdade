/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
 
    private static final String SQL_INSERT =
        "INSERT INTO cliente (nom_cliente, rua_cliente, bai_cliente, cid_cliente, "
        + "uf_cliente, cod_cliente_titular, sit_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
 
    // INSERT usado por titular e por dependente.
    // NAO controla transacao: quem chama e que faz commit/rollback.
    private int inserir(Connection c, Cliente cli, Integer codTitular) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getRua());
            ps.setString(3, cli.getBairro());
            ps.setString(4, cli.getCidade());
            ps.setString(5, cli.getUf());
            if (codTitular == null) ps.setNull(6, Types.INTEGER);
            else ps.setInt(6, codTitular);
            ps.setInt(7, cli.getSituacao());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                rs.next();
                return rs.getInt("cod_cliente");
            }
        }
    }
 
    // Executa UM comando (update/delete) dentro de uma transacao.
    private int executarUpdate(String sql, Object... params) throws SQLException {
        Connection c = ConexaoBD.getConexao();
        try {
            c.setAutoCommit(false);
            int linhas;
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
                linhas = ps.executeUpdate();
            }
            c.commit();
            return linhas;
        } catch (SQLException e) {
            c.rollback();
            throw e;
        } finally {
            c.setAutoCommit(true);
        }
    }
 
    // INCLUIR titular + todos os dependentes numa unica transacao.
    // Se um dependente falhar, o titular tambem nao e salvo.
    public void incluir(Cliente titular) throws SQLException {
        Connection c = ConexaoBD.getConexao();
        try {
            c.setAutoCommit(false);
            int cod = inserir(c, titular, null);
            titular.setCodigo(cod);
            for (Cliente d : titular.getDependentes()) {
                d.setCodTitular(cod);
                d.setCodigo(inserir(c, d, cod));
            }
            c.commit();
        } catch (SQLException e) {
            c.rollback();
            throw e;
        } finally {
            c.setAutoCommit(true);
        }
    }
 
    // INCLUIR so um dependente em um titular que ja existe. Retorna o codigo gerado.
    public int incluirDependente(int codTitular, Cliente dep) throws SQLException {
        Connection c = ConexaoBD.getConexao();
        try {
            c.setAutoCommit(false);
            int cod = inserir(c, dep, codTitular);
            c.commit();
            return cod;
        } catch (SQLException e) {
            c.rollback();
            throw e;
        } finally {
            c.setAutoCommit(true);
        }
    }
 
    // ALTERAR dados do titular
    public boolean alterarTitular(Cliente t) throws SQLException {
        String sql = "UPDATE cliente SET nom_cliente = ?, rua_cliente = ?, bai_cliente = ?, "
                   + "cid_cliente = ?, uf_cliente = ?, sit_cliente = ? "
                   + "WHERE cod_cliente = ? AND cod_cliente_titular IS NULL";
        return executarUpdate(sql, t.getNome(), t.getRua(), t.getBairro(), t.getCidade(),
                              t.getUf(), t.getSituacao(), t.getCodigo()) > 0;
    }
 
    // ALTERAR nome de um dependente
    public boolean alterarDependente(int codTitular, int codDep, String novoNome) throws SQLException {
        String sql = "UPDATE cliente SET nom_cliente = ? WHERE cod_cliente = ? AND cod_cliente_titular = ?";
        return executarUpdate(sql, novoNome, codDep, codTitular) > 0;
    }
 
    // EXCLUIR um dependente
    public boolean excluirDependente(int codTitular, int codDep) throws SQLException {
        String sql = "DELETE FROM cliente WHERE cod_cliente = ? AND cod_cliente_titular = ?";
        return executarUpdate(sql, codDep, codTitular) > 0;
    }
 
    // EXCLUIR titular: primeiro os dependentes (por causa da chave estrangeira), depois o titular.
    // Tudo na mesma transacao.
    public boolean excluir(int codTitular) throws SQLException {
        Connection c = ConexaoBD.getConexao();
        try {
            c.setAutoCommit(false);
            int linhas;
            try (PreparedStatement ps = c.prepareStatement(
                    "DELETE FROM cliente WHERE cod_cliente_titular = ?")) {
                ps.setInt(1, codTitular);
                ps.executeUpdate();
            }
            try (PreparedStatement ps = c.prepareStatement(
                    "DELETE FROM cliente WHERE cod_cliente = ? AND cod_cliente_titular IS NULL")) {
                ps.setInt(1, codTitular);
                linhas = ps.executeUpdate();
            }
            c.commit();
            return linhas > 0;
        } catch (SQLException e) {
            c.rollback();
            throw e;
        } finally {
            c.setAutoCommit(true);
        }
    }
 
    // LISTAR: so titulares, so codigo e nome
    public List<Cliente> listar() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT cod_cliente, nom_cliente FROM cliente "
                   + "WHERE cod_cliente_titular IS NULL ORDER BY nom_cliente";
        try (PreparedStatement ps = ConexaoBD.getConexao().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodigo(rs.getInt("cod_cliente"));
                c.setNome(rs.getString("nom_cliente"));
                lista.add(c);
            }
        }
        return lista;
    }
 
    // BUSCAR titular + dependentes com UMA unica consulta.
    // Retorna null se o codigo nao existir ou nao for de um titular.
    public Cliente buscar(int codigo) throws SQLException {
        String sql = "SELECT cod_cliente, nom_cliente, rua_cliente, bai_cliente, cid_cliente, "
                   + "uf_cliente, sit_cliente, cod_cliente_titular FROM cliente "
                   + "WHERE cod_cliente = ? OR cod_cliente_titular = ? ORDER BY nom_cliente";
        Cliente titular = null;
        List<Cliente> deps = new ArrayList<>();
        try (PreparedStatement ps = ConexaoBD.getConexao().prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.setInt(2, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int cod = rs.getInt("cod_cliente");
                    int tit = rs.getInt("cod_cliente_titular");
                    boolean semTitular = rs.wasNull();
 
                    Cliente x = new Cliente();
                    x.setCodigo(cod);
                    x.setNome(rs.getString("nom_cliente"));
                    x.setRua(rs.getString("rua_cliente"));
                    x.setBairro(rs.getString("bai_cliente"));
                    x.setCidade(rs.getString("cid_cliente"));
                    String uf = rs.getString("uf_cliente");
                    x.setUf(uf == null ? null : uf.trim());
                    x.setSituacao(rs.getInt("sit_cliente"));
 
                    if (semTitular && cod == codigo) {
                        titular = x;
                    } else if (!semTitular && tit == codigo) {
                        x.setCodTitular(tit);
                        deps.add(x);
                    }
                }
            }
        }
        if (titular == null) return null;
        titular.setDependentes(deps);
        return titular;
    }
}
