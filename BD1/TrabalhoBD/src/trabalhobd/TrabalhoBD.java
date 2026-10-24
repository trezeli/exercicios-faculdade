/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhobd;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoBD {

    public static void main(String[] args) throws Exception {
//        ClienteBD bd = new ClienteBD();
//
//        Cliente t = new Cliente();
//        t.setNomCliente("Teste Titular");
//        t.setRuaCliente("Rua A");
//        t.setBaiCliente("Centro");
//        t.setCidCliente("Baixo Guandu");
//        t.setUfCliente("ES");
//        t.setSitCliente(1);
//
//        Cliente d1 = new Cliente();
//        d1.setNomCliente("Teste Dependente 1");
//        d1.setRuaCliente("Rua A");
//        d1.setBaiCliente("Centro");
//        d1.setCidCliente("Baixo Guandu");
//        d1.setUfCliente("ES");
//        d1.setSitCliente(1);
//
//        List<Cliente> deps = new ArrayList<>();
//        deps.add(d1);
//
//        bd.incluir(t, deps);
//        System.out.println("Incluiu!");

        ClienteBD bd = new ClienteBD();

        Cliente t = new Cliente();
        t.setCodCliente(373785);
        t.setNomCliente("Teste Titular Alterado");
        t.setRuaCliente("Rua B");
        t.setBaiCliente("Centro");
        t.setCidCliente("Baixo Guandu");
        t.setUfCliente("ES");
        t.setSitCliente(2);

// dependente existente, com nome novo
        Cliente d1 = new Cliente();
        d1.setCodCliente(373786);
        d1.setNomCliente("Teste Dependente Alterado");
        d1.setRuaCliente("Rua B");
        d1.setBaiCliente("Centro");
        d1.setCidCliente("Baixo Guandu");
        d1.setUfCliente("ES");
        d1.setSitCliente(1);

// dependente novo (sem código)
        Cliente d2 = new Cliente();
        d2.setNomCliente("Teste Dependente Novo");
        d2.setRuaCliente("Rua B");
        d2.setBaiCliente("Centro");
        d2.setCidCliente("Baixo Guandu");
        d2.setUfCliente("ES");
        d2.setSitCliente(1);

        List<Cliente> deps = new ArrayList<>();
        deps.add(d1);
        deps.add(d2);

        bd.alterar(t, deps, new ArrayList<Integer>());
        System.out.println("Alterou!");
    }
}
