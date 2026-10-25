/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package locadora;
import java.sql.SQLException;
import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            ConexaoBD.getConexao(); // abre a unica conexao do programa
            int op;
            do {
                System.out.println("\n=== LOCADORA ===");
                System.out.println("1 - Clientes");
                System.out.println("2 - Filmes");
                System.out.println("0 - Sair");
                System.out.print("Opcao: ");
                try {
                    op = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    op = -1;
                }
                if (op == 1) {
                    new MenuCliente(sc).executar();
                } else if (op == 2) {
                    new MenuFilme(sc).executar();
                } else if (op != 0) {
                    System.out.println("Opcao invalida.");
                }
            } while (op != 0);
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar: " + e.getMessage());
        } finally {
            ConexaoBD.fechar();
            sc.close();
        }
    }
}
