/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhobd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteBD {
    private Cliente montarCliente(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();
        c.setCodCliente(rs.getInt("cod_cliente"));
        c.setNomCliente(rs.getString("nom_cliente"));
        c.setRuaCliente(rs.getString("rua_cliente"));
        c.setBaiCliente(rs.getString("bai_cliente"));
        c.setCidCliente(rs.getString("cid_cliente"));
        c.setUfCliente(rs.getString("uf_cliente"));
        c.setSitCliente(rs.getInt("sit_cliente"));

        int titular = rs.getInt("cod_cliente_titular");
        if (rs.wasNull()) {
            c.setCodClienteTitular(null);
        } else {
            c.setCodClienteTitular(titular);
        }
        return c;
    }

    public List<Cliente> buscarTitulares(String nome) throws SQLException {
    List<Cliente> lista = new ArrayList<>();
    String sql = "SELECT * FROM cliente "
               + "WHERE cod_cliente_titular IS NULL "
               + "AND nom_cliente ILIKE ? "
               + "ORDER BY nom_cliente "
               + "LIMIT 50";

    Connection con = Conexao.getConexao();

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, "%" + nome + "%");
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(montarCliente(rs));
            }
        }
    }
    return lista;
    }

    public List<Cliente> listarDependentes(int codTitular) throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente "
                   + "WHERE cod_cliente_titular = ? "
                   + "ORDER BY nom_cliente";

        Connection con = Conexao.getConexao();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codTitular);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(montarCliente(rs));
                }
            }
        }
        return lista;
    }
    
    private int inserirCliente(Connection con, Cliente c) throws SQLException {
        String sql = "INSERT INTO cliente (nom_cliente, rua_cliente, bai_cliente, "
                + "cid_cliente, uf_cliente, cod_cliente_titular, sit_cliente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING cod_cliente";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNomCliente());
            ps.setString(2, c.getRuaCliente());
            ps.setString(3, c.getBaiCliente());
            ps.setString(4, c.getCidCliente());
            ps.setString(5, c.getUfCliente());

            if (c.getCodClienteTitular() == null) {
                ps.setNull(6, Types.INTEGER);
            } else {
                ps.setInt(6, c.getCodClienteTitular());
            }

            ps.setInt(7, c.getSitCliente());

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt("cod_cliente");
            }
        }
    }

    public void incluir(Cliente titular, List<Cliente> dependentes) throws SQLException {
        Connection con = Conexao.getConexao();

        try {
            con.setAutoCommit(false);

            titular.setCodClienteTitular(null);
            int codTitular = inserirCliente(con, titular);

            for (Cliente d : dependentes) {
                d.setCodClienteTitular(codTitular);
                inserirCliente(con, d);
            }

            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }
    
    public void excluir(int codTitular) throws SQLException {
        Connection con = Conexao.getConexao();

        String sqlDependentes = "DELETE FROM cliente WHERE cod_cliente_titular = ?";
        String sqlTitular = "DELETE FROM cliente WHERE cod_cliente = ?";

        try (PreparedStatement psDep = con.prepareStatement(sqlDependentes); PreparedStatement psTit = con.prepareStatement(sqlTitular)) {

            con.setAutoCommit(false);

            psDep.setInt(1, codTitular);
            psDep.executeUpdate();

            psTit.setInt(1, codTitular);
            psTit.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }
    
    private void atualizarCliente(Connection con, Cliente c) throws SQLException {
        String sql = "UPDATE cliente SET nom_cliente = ?, rua_cliente = ?, "
                + "bai_cliente = ?, cid_cliente = ?, uf_cliente = ?, "
                + "sit_cliente = ? WHERE cod_cliente = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNomCliente());
            ps.setString(2, c.getRuaCliente());
            ps.setString(3, c.getBaiCliente());
            ps.setString(4, c.getCidCliente());
            ps.setString(5, c.getUfCliente());
            ps.setInt(6, c.getSitCliente());
            ps.setInt(7, c.getCodCliente());
            ps.executeUpdate();
        }
    }

    private void apagarCliente(Connection con, int codCliente) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(
                "DELETE FROM cliente WHERE cod_cliente = ?")) {
            ps.setInt(1, codCliente);
            ps.executeUpdate();
        }
    }

    public void alterar(Cliente titular, List<Cliente> dependentes,
            List<Integer> dependentesRemovidos) throws SQLException {
        Connection con = Conexao.getConexao();

        try {
            con.setAutoCommit(false);

            atualizarCliente(con, titular);

            for (int cod : dependentesRemovidos) {
                apagarCliente(con, cod);
            }

            for (Cliente d : dependentes) {
                if (d.getCodCliente() == 0) {
                    d.setCodClienteTitular(titular.getCodCliente());
                    inserirCliente(con, d);
                } else {
                    atualizarCliente(con, d);
                }
            }

            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }
}
