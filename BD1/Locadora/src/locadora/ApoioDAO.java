/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Carrega cores e generos UMA vez so e guarda em memoria (cache).
 * Assim nao precisamos consultar o banco toda hora nem fazer JOIN.
 */

public class ApoioDAO {
    private static List<Cor> cores;
    private static List<Genero> generos;
 
    public static List<Cor> getCores() throws SQLException {
        if (cores == null) {
            List<Cor> lista = new ArrayList<>();
            String sql = "SELECT cod_cor, nom_cor FROM cor ORDER BY nom_cor";
            try (PreparedStatement ps = ConexaoBD.getConexao().prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Cor(rs.getString("cod_cor").trim(), rs.getString("nom_cor")));
                }
            }
            cores = lista;
        }
        return cores;
    }
 
    public static List<Genero> getGeneros() throws SQLException {
        if (generos == null) {
            List<Genero> lista = new ArrayList<>();
            String sql = "SELECT cod_genero, nom_genero FROM genero ORDER BY cod_genero";
            try (PreparedStatement ps = ConexaoBD.getConexao().prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Genero(rs.getInt("cod_genero"), rs.getString("nom_genero")));
                }
            }
            generos = lista;
        }
        return generos;
    }
 
    public static Cor buscarCor(String codigo) throws SQLException {
        for (Cor c : getCores()) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }
 
    public static Genero buscarGenero(int codigo) throws SQLException {
        for (Genero g : getGeneros()) {
            if (g.getCodigo() == codigo) return g;
        }
        return null;
    }
}
