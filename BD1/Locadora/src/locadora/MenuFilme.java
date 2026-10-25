/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuFilme {
    private final Scanner sc;
    private final FilmeDAO dao = new FilmeDAO();

    public MenuFilme(Scanner sc) {
        this.sc = sc;
    }

    public void executar() {
        int op;
        do {
            System.out.println("\n=== FILMES ===");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar");
            System.out.println("5 - Exibir detalhes");
            System.out.println("0 - Voltar");
            op = lerInt("Opcao: ");
            try {
                switch (op) {
                    case 1: incluir(); break;
                    case 2: alterar(); break;
                    case 3: excluir(); break;
                    case 4: listar(); break;
                    case 5: exibir(); break;
                    case 0: break;
                    default: System.out.println("Opcao invalida.");
                }
            } catch (SQLException e) {
                System.out.println("Erro no banco: " + e.getMessage());
            }
        } while (op != 0);
    }

    private void incluir() throws SQLException {
        Filme f = new Filme();
        f.setNome(lerNome(null));
        f.setCor(escolherCor(null));
        f.setGenero(escolherGenero(null));
        dao.incluir(f);
        System.out.println("Filme incluido com codigo " + f.getCodigo() + ".");
    }

    private void alterar() throws SQLException {
        int cod = lerInt("Codigo do filme: ");
        Filme f = dao.buscar(cod);
        if (f == null) {
            System.out.println("Filme nao encontrado.");
            return;
        }
        f.setNome(lerNome(f.getNome()));
        f.setCor(escolherCor(f.getCor()));
        f.setGenero(escolherGenero(f.getGenero()));
        dao.alterar(f);
        System.out.println("Filme alterado.");
    }

    private void excluir() throws SQLException {
        int cod = lerInt("Codigo do filme: ");
        Filme f = dao.buscar(cod);
        if (f == null) {
            System.out.println("Filme nao encontrado.");
            return;
        }
        String resp = lerTexto("Excluir '" + f.getNome() + "'? (s/n): ");
        if (!resp.equalsIgnoreCase("s")) {
            System.out.println("Cancelado.");
            return;
        }
        try {
            dao.excluir(cod);
            System.out.println("Filme excluido.");
        } catch (SQLException e) {
            if ("23503".equals(e.getSQLState())) { // violacao de chave estrangeira
                System.out.println("Nao e possivel excluir: existem fitas deste filme.");
            } else {
                throw e;
            }
        }
    }

    private void listar() throws SQLException {
        List<Filme> lista = dao.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        for (Filme f : lista) {
            System.out.println(f.getCodigo() + " - " + f.getNome());
        }
    }

    private void exibir() throws SQLException {
        int cod = lerInt("Codigo do filme: ");
        Filme f = dao.buscar(cod);
        if (f == null) {
            System.out.println("Filme nao encontrado.");
            return;
        }
        System.out.println("Codigo: " + f.getCodigo());
        System.out.println("Nome:   " + f.getNome());
        System.out.println("Cor:    " + f.getCor().getNome());
        System.out.println("Genero: " + f.getGenero().getNome());
    }

    // ---------- auxiliares de leitura ----------

    private String lerNome(String atual) {
        while (true) {
            String n = lerTexto(atual == null
                    ? "Nome: "
                    : "Novo nome (Enter mantem '" + atual + "'): ");
            if (n.isEmpty() && atual != null) return atual;
            if (!n.isEmpty() && n.length() <= 80) return n;
            System.out.println("Nome obrigatorio, maximo 80 caracteres.");
        }
    }

    private Cor escolherCor(Cor atual) throws SQLException {
        System.out.println("Cores:");
        for (Cor c : ApoioDAO.getCores()) {
            System.out.println("  " + c.getCodigo() + " - " + c.getNome());
        }
        while (true) {
            String txt = lerTexto("Codigo da cor"
                    + (atual != null ? " (Enter mantem " + atual.getNome() + ")" : "") + ": ");
            if (txt.isEmpty() && atual != null) return atual;
            Cor c = ApoioDAO.buscarCor(txt);
            if (c != null) return c;
            System.out.println("Cor invalida.");
        }
    }

    private Genero escolherGenero(Genero atual) throws SQLException {
        System.out.println("Generos:");
        for (Genero g : ApoioDAO.getGeneros()) {
            System.out.println("  " + g.getCodigo() + " - " + g.getNome());
        }
        while (true) {
            String txt = lerTexto("Codigo do genero"
                    + (atual != null ? " (Enter mantem " + atual.getNome() + ")" : "") + ": ");
            if (txt.isEmpty() && atual != null) return atual;
            try {
                Genero g = ApoioDAO.buscarGenero(Integer.parseInt(txt));
                if (g != null) return g;
            } catch (NumberFormatException e) {
                // cai na mensagem abaixo
            }
            System.out.println("Genero invalido.");
        }
    }

    private String lerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    private int lerInt(String msg) {
        try {
            return Integer.parseInt(lerTexto(msg));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}