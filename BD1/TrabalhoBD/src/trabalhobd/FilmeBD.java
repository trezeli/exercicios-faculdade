/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhobd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeBD {

    public List<Filme> listar() throws SQLException {
        List<Filme> lista = new ArrayList<>();
        
        String sql = "SELECT f.cod_filme, f.nom_filme, f.cod_cor, c.nom_cor, f.cod_genero, g.nom_genero\n"
                + "FROM filme f\n"
                + "JOIN cor c ON c.cod_cor = f.cod_cor\n"
                + "JOIN genero g ON g.cod_genero = f.cod_genero\n"
                + "ORDER BY f.nom_filme"; 

        Connection con = Conexao.getConexao();
        
        try (PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            
            while (rs.next()){
                Filme f = new Filme();
                f.setCodFilme(rs.getInt("cod_filme"));
                f.setNomFilme(rs.getString("nom_filme"));
                f.setCodCor(rs.getString("cod_cor"));
                f.setNomCor(rs.getString("nom_cor"));
                f.setCodGenero(rs.getInt("cod_genero"));
                f.setNomGenero(rs.getString("nom_genero"));
                lista.add(f);
            }
        }

        return lista;
    }
    
    public void incluir(Filme f) throws SQLException {
        String sql = "INSERT INTO filme (nom_filme, cod_cor, cod_genero) VALUES (?, ?, ?)";

        Connection con = Conexao.getConexao();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            con.setAutoCommit(false);

            ps.setString(1, f.getNomFilme());
            ps.setString(2, f.getCodCor());
            ps.setInt(3, f.getCodGenero());
            ps.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }
    
    public void alterar(Filme f) throws SQLException {
        String sql = "UPDATE filme SET nom_filme = ?, cod_cor = ?, cod_genero = ? "
                + "WHERE cod_filme = ?";

        Connection con = Conexao.getConexao();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            con.setAutoCommit(false);

            ps.setString(1, f.getNomFilme());
            ps.setString(2, f.getCodCor());
            ps.setInt(3, f.getCodGenero());
            ps.setInt(4, f.getCodFilme());
            ps.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }
    
    public void excluir(int codFilme) throws SQLException {
        String sql = "DELETE FROM filme WHERE cod_filme = ?";

        Connection con = Conexao.getConexao();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            con.setAutoCommit(false);

            ps.setInt(1, codFilme);
            ps.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }
}