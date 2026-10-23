/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    // Instância única da conexão
    private static Connection conexao = null;
    
    // Dados do banco (ajuste conforme o seu SGBD, ex: PostgreSQL, MySQL)
    private static final String URL = "jdbc:postgresql://localhost:5432/loc004";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "sua_senha_aqui";

    // Construtor privado impede que outras classes usem "new ConexaoBD()"
    private ConexaoBD() {
    }

    // Método público estático para obter a conexão única
    public static Connection getConexao() {
        if (conexao == null) {
            try {
                // Estabelece a conexão na primeira vez que for chamada
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                
                // IMPORTANTE: Desativa o autocommit para permitir o controle de transação exigido no trabalho
                conexao.setAutoCommit(false); 
                
                System.out.println("Conexão com loc004 estabelecida com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            }
        }
        return conexao;
    }

    // Método para fechar a conexão ao encerrar o sistema
    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
                System.out.println("Conexão encerrada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}