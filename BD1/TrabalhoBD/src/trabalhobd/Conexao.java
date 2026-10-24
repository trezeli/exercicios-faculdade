/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhobd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {
    
    private static Connection conexao = null;

    public Conexao() {
    }
    
    public static Connection getConexao() throws SQLException {
        if (conexao == null) {
            conexao = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/loc004",
                "postgres",
                "0611"
            );
        }
        return conexao;
    }
}
