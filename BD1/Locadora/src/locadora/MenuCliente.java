/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCliente {
    private final Scanner sc;
    private final ClienteDAO dao = new ClienteDAO();
 
    public MenuCliente(Scanner sc) {
        this.sc = sc;
    }
 
    public void executar() {
        int op;
        do {
            System.out.println("\n=== CLIENTES ===");
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
                System.out.println(mensagemErro(e));
            }
        } while (op != 0);
    }
 
    // ---------- INCLUIR / LISTAR / EXIBIR / EXCLUIR ----------
 
    private void incluir() throws SQLException {
        Cliente t = new Cliente();
        t.setNome(lerNome("Nome do cliente", null));
        t.setRua(lerOpcional("Rua", null, 60));
        t.setBairro(lerOpcional("Bairro", null, 60));
        t.setCidade(lerOpcional("Cidade", null, 60));
        t.setUf(lerUf(null));
        while (lerTexto("Adicionar dependente? (s/n): ").equalsIgnoreCase("s")) {
            Cliente d = new Cliente();
            d.setNome(lerNome("Nome do dependente", null));
            t.getDependentes().add(d);
        }
        dao.incluir(t);
        System.out.println("Cliente incluido com codigo " + t.getCodigo()
                + " e " + t.getDependentes().size() + " dependente(s).");
    }
 
    private void listar() throws SQLException {
        List<Cliente> lista = dao.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : lista) {
            System.out.println(c.getCodigo() + " - " + c.getNome());
        }
    }
 
    private void exibir() throws SQLException {
        int cod = lerInt("Codigo do cliente: ");
        Cliente c = dao.buscar(cod);
        if (c == null) {
            System.out.println("Cliente nao encontrado.");
            return;
        }
        mostrar(c);
    }
 
    private void excluir() throws SQLException {
        int cod = lerInt("Codigo do cliente: ");
        Cliente c = dao.buscar(cod);
        if (c == null) {
            System.out.println("Cliente nao encontrado.");
            return;
        }
        String resp = lerTexto("Excluir '" + c.getNome() + "' e seus "
                + c.getDependentes().size() + " dependente(s)? (s/n): ");
        if (!resp.equalsIgnoreCase("s")) {
            System.out.println("Cancelado.");
            return;
        }
        if (dao.excluir(cod)) {
            System.out.println("Cliente excluido.");
        } else {
            System.out.println("Cliente nao encontrado.");
        }
    }
 
    // ---------- ALTERAR (com submenu de dependentes) ----------
 
    private void alterar() throws SQLException {
        int cod = lerInt("Codigo do cliente: ");
        Cliente c = dao.buscar(cod); // unica consulta; depois trabalhamos em memoria
        if (c == null) {
            System.out.println("Cliente nao encontrado.");
            return;
        }
        mostrar(c);
        int op;
        do {
            System.out.println("\n--- Alterar: " + c.getNome() + " ---");
            System.out.println("1 - Alterar dados do titular");
            System.out.println("2 - Adicionar dependente");
            System.out.println("3 - Alterar dependente");
            System.out.println("4 - Remover dependente");
            System.out.println("0 - Voltar");
            op = lerInt("Opcao: ");
            try {
                switch (op) {
                    case 1: alterarTitular(c); break;
                    case 2: adicionarDependente(c); break;
                    case 3: alterarDependente(c); break;
                    case 4: removerDependente(c); break;
                    case 0: break;
                    default: System.out.println("Opcao invalida.");
                }
            } catch (SQLException e) {
                System.out.println(mensagemErro(e));
            }
        } while (op != 0);
    }
 
    private void alterarTitular(Cliente c) throws SQLException {
        // le os novos valores em um objeto temporario; so atualiza o original se o banco aceitar
        Cliente n = new Cliente();
        n.setCodigo(c.getCodigo());
        n.setNome(lerNome("Nome", c.getNome()));
        n.setRua(lerOpcional("Rua", c.getRua(), 60));
        n.setBairro(lerOpcional("Bairro", c.getBairro(), 60));
        n.setCidade(lerOpcional("Cidade", c.getCidade(), 60));
        n.setUf(lerUf(c.getUf()));
        n.setSituacao(lerSituacao(c.getSituacao()));
        if (dao.alterarTitular(n)) {
            c.setNome(n.getNome());
            c.setRua(n.getRua());
            c.setBairro(n.getBairro());
            c.setCidade(n.getCidade());
            c.setUf(n.getUf());
            c.setSituacao(n.getSituacao());
            System.out.println("Dados do titular alterados.");
        } else {
            System.out.println("Cliente nao encontrado.");
        }
    }
 
    private void adicionarDependente(Cliente c) throws SQLException {
        Cliente d = new Cliente();
        d.setNome(lerNome("Nome do dependente", null));
        d.setCodigo(dao.incluirDependente(c.getCodigo(), d));
        d.setCodTitular(c.getCodigo());
        c.getDependentes().add(d);
        System.out.println("Dependente incluido com codigo " + d.getCodigo() + ".");
    }
 
    private void alterarDependente(Cliente c) throws SQLException {
        Cliente d = escolherDependente(c);
        if (d == null) return;
        String novoNome = lerNome("Novo nome", d.getNome());
        if (dao.alterarDependente(c.getCodigo(), d.getCodigo(), novoNome)) {
            d.setNome(novoNome);
            System.out.println("Dependente alterado.");
        } else {
            System.out.println("Dependente nao encontrado.");
        }
    }
 
    private void removerDependente(Cliente c) throws SQLException {
        Cliente d = escolherDependente(c);
        if (d == null) return;
        if (!lerTexto("Remover '" + d.getNome() + "'? (s/n): ").equalsIgnoreCase("s")) {
            System.out.println("Cancelado.");
            return;
        }
        if (dao.excluirDependente(c.getCodigo(), d.getCodigo())) {
            c.getDependentes().remove(d);
            System.out.println("Dependente removido.");
        } else {
            System.out.println("Dependente nao encontrado.");
        }
    }
 
    // Escolhe um dependente da lista que ja esta em memoria (sem acessar o banco)
    private Cliente escolherDependente(Cliente c) {
        if (c.getDependentes().isEmpty()) {
            System.out.println("Este cliente nao tem dependentes.");
            return null;
        }
        for (Cliente d : c.getDependentes()) {
            System.out.println("  " + d.getCodigo() + " - " + d.getNome());
        }
        int cod = lerInt("Codigo do dependente: ");
        for (Cliente d : c.getDependentes()) {
            if (d.getCodigo() == cod) return d;
        }
        System.out.println("Dependente nao encontrado.");
        return null;
    }
 
    // ---------- exibicao ----------
 
    private void mostrar(Cliente c) {
        System.out.println("Codigo:   " + c.getCodigo());
        System.out.println("Nome:     " + c.getNome());
        String end = montarEndereco(c);
        if (!end.isEmpty()) {
            System.out.println("Endereco: " + end);
        }
        System.out.println("Situacao: " + c.getSituacaoDescricao());
        if (c.getDependentes().isEmpty()) {
            System.out.println("Dependentes: nenhum");
        } else {
            System.out.println("Dependentes:");
            for (Cliente d : c.getDependentes()) {
                System.out.println("  " + d.getCodigo() + " - " + d.getNome());
            }
        }
    }
 
    private String montarEndereco(Cliente c) {
        List<String> partes = new ArrayList<>();
        if (c.getRua() != null) partes.add(c.getRua());
        if (c.getBairro() != null) partes.add(c.getBairro());
        if (c.getCidade() != null) partes.add(c.getCidade());
        if (c.getUf() != null) partes.add(c.getUf());
        return String.join(", ", partes);
    }
 
    private String mensagemErro(SQLException e) {
        if ("23503".equals(e.getSQLState())) { // violacao de chave estrangeira
            return "Nao e possivel excluir: ha locacoes ligadas a este cliente.";
        }
        return "Erro no banco: " + e.getMessage();
    }
 
    // ---------- leitura ----------
 
    private String lerNome(String rotulo, String atual) {
        while (true) {
            String n = lerTexto(atual == null
                    ? rotulo + ": "
                    : rotulo + " (Enter mantem '" + atual + "'): ");
            if (n.isEmpty() && atual != null) return atual;
            if (!n.isEmpty() && n.length() <= 60) return n;
            System.out.println("Obrigatorio, maximo 60 caracteres.");
        }
    }
 
    // Campo opcional. Enter = mantem (ou pula, se vazio). "-" = limpa o campo.
    private String lerOpcional(String rotulo, String atual, int max) {
        while (true) {
            String dica = atual == null ? "Enter pula" : "Enter mantem '" + atual + "', - limpa";
            String t = lerTexto(rotulo + " (" + dica + "): ");
            if (t.isEmpty()) return atual;
            if (t.equals("-")) return null;
            if (t.length() <= max) return t;
            System.out.println("Maximo " + max + " caracteres.");
        }
    }
 
    private String lerUf(String atual) {
        while (true) {
            String dica = atual == null ? "Enter pula" : "Enter mantem '" + atual + "', - limpa";
            String t = lerTexto("UF (" + dica + "): ");
            if (t.isEmpty()) return atual;
            if (t.equals("-")) return null;
            if (t.matches("[A-Za-z]{2}")) return t.toUpperCase();
            System.out.println("UF deve ter 2 letras.");
        }
    }
 
    private int lerSituacao(int atual) {
        while (true) {
            String t = lerTexto("Situacao - 1 Habilitado, 2 Desabilitado (Enter mantem "
                    + (atual == 1 ? "Habilitado" : "Desabilitado") + "): ");
            if (t.isEmpty()) return atual;
            if (t.equals("1")) return 1;
            if (t.equals("2")) return 2;
            System.out.println("Digite 1 ou 2.");
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
