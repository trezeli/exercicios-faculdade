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
import java.util.ArrayList;
import java.util.List;
 
public class FilmeDAO {
 
    // INCLUIR (com transacao)
    public void incluir(Filme f) throws SQLException {
        Connection c = ConexaoBD.getConexao();
        String sql = "INSERT INTO filme (nom_filme, cod_cor, cod_genero) VALUES (?, ?, ?)";
        try {
            c.setAutoCommit(false);
            try (PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, f.getNome());
                ps.setString(2, f.getCor().getCodigo());
                ps.setInt(3, f.getGenero().getCodigo());
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) f.setCodigo(rs.getInt("cod_filme")); // codigo gerado pelo serial
                }
            }
            c.commit();
        } catch (SQLException e) {
            c.rollback();
            throw e;
        } finally {
            c.setAutoCommit(true);
        }
    }
 
    // ALTERAR (com transacao) - retorna false se o codigo nao existe
    public boolean alterar(Filme f) throws SQLException {
        Connection c = ConexaoBD.getConexao();
        String sql = "UPDATE filme SET nom_filme = ?, cod_cor = ?, cod_genero = ? WHERE cod_filme = ?";
        try {
            c.setAutoCommit(false);
            int linhas;
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, f.getNome());
                ps.setString(2, f.getCor().getCodigo());
                ps.setInt(3, f.getGenero().getCodigo());
                ps.setInt(4, f.getCodigo());
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
 
    // EXCLUIR (com transacao) - retorna false se o codigo nao existe
    public boolean excluir(int codigo) throws SQLException {
        Connection c = ConexaoBD.getConexao();
        String sql = "DELETE FROM filme WHERE cod_filme = ?";
        try {
            c.setAutoCommit(false);
            int linhas;
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, codigo);
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
 
    // LISTAR: so codigo e nome (nao traz dado desnecessario)
    public List<Filme> listar() throws SQLException {
        List<Filme> lista = new ArrayList<>();
        String sql = "SELECT cod_filme, nom_filme FROM filme ORDER BY nom_filme";
        try (PreparedStatement ps = ConexaoBD.getConexao().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Filme f = new Filme();
                f.setCodigo(rs.getInt("cod_filme"));
                f.setNome(rs.getString("nom_filme"));
                lista.add(f);
            }
        }
        return lista;
    }
 
    // BUSCAR: um filme completo. Cor e genero vem do cache (sem JOIN, sem outra consulta)
    public Filme buscar(int codigo) throws SQLException {
        String sql = "SELECT nom_filme, cod_cor, cod_genero FROM filme WHERE cod_filme = ?";
        try (PreparedStatement ps = ConexaoBD.getConexao().prepareStatement(sql)) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                Filme f = new Filme();
                f.setCodigo(codigo);
                f.setNome(rs.getString("nom_filme"));
                f.setCor(ApoioDAO.buscarCor(rs.getString("cod_cor").trim()));
                f.setGenero(ApoioDAO.buscarGenero(rs.getInt("cod_genero")));
                return f;
            }
        }
    }
}