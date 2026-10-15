/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package provamagia;

public class ProvaMagia {
    
    public static void main(String[] args) {
        MagiaSagrada   m1 = new MagiaSagrada("Padre Joao", 100);
        MagiaDemoniaca m2 = new MagiaDemoniaca("Lili", 120);
        MagiaSagrada   m3 = new MagiaSagrada("Papa Pedro XV", 1000);
        MagiaCinzenta  m4 = new MagiaCinzenta(m1, m2);
        MagiaCinzenta  m5 = new MagiaCinzenta(m2, m3);
        
        System.out.println("**-- Imprimindo os dados das magias --**");
        System.out.println(m1.obterNomeUsuario() + " possui poder " + m1.obterPoder() + " e cor " + m1.obterCor());
        System.out.println(m2.obterNomeUsuario() + " possui poder " + m2.obterPoder() + " e cor " + m2.obterCor());
        System.out.println(m3.obterNomeUsuario() + " possui poder " + m3.obterPoder() + " e cor " + m3.obterCor());
        System.out.println(m4.obterNomeUsuario() + " possui poder " + m4.obterPoder() + " e cor " + m4.obterCor());
        System.out.println(m5.obterNomeUsuario() + " possui poder " + m5.obterPoder() + " e cor " + m5.obterCor());
        System.out.println("**--------------------------**");
        
        System.out.println("A magia de " + m4.obterNomeUsuario() + " é uma " + m4.obterLado());
        System.out.println("A magia de " + m5.obterNomeUsuario() + " é uma " + m5.obterLado());
        System.out.println("**--------------------------**");
        
        Magia m6 = new MagiaCinzenta(m3, m2); // ATENÇÃO que aqui os parâmetros são m3, m2 e não m2 e m3
        System.out.println(m6.obterNomeUsuario() + " possui poder " + m6.obterPoder() + " e cor " + m6.obterCor());
        System.out.println("A magia de " + m6.obterNomeUsuario() + " é uma " + ((MagiaCinzenta)m6).obterLado());
        System.out.println("**--------------------------**");
        
        System.out.println("Foram criadas " + Magia.getQtMagia() + " magias ");
    }
}