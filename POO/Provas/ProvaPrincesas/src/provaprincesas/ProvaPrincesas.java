/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package provaprincesas;
 
public class ProvaPrincesas {
    public static void main(String[] args) {
        PrincesaSolar p1 = new PrincesaSolar("Luz", 300);
        PrincesaSolar p2 = new PrincesaSolar("Solina", 200);
        PrincesaLunar p3 = new PrincesaLunar("Lunara", 140);
        PrincesaLunar p4 = new PrincesaLunar("Brilhante", 500);
        PrincesaCrepuscular p5 = new PrincesaCrepuscular(p1, p3);
        PrincesaCrepuscular p6 = new PrincesaCrepuscular(p4, p2);
 
        System.out.println("**-- Imprimindo os dados das princesas --**");
        System.out.println(p1.obterNome() + " possui poder " + p1.obterPoder() + " e arma " + p1.obterArma());
        System.out.println(p2.obterNome() + " possui poder " + p2.obterPoder() + " e arma " + p2.obterArma());
        System.out.println(p3.obterNome() + " possui poder " + p3.obterPoder() + " e arma " + p3.obterArma());
        System.out.println(p4.obterNome() + " possui poder " + p4.obterPoder() + " e arma " + p4.obterArma());
        System.out.println(p5.obterNome() + " possui poder " + p5.obterPoder() + " e arma " + p5.obterArma());
        System.out.println(p6.obterNome() + " possui poder " + p6.obterPoder() + " e arma " + p6.obterArma());

        System.out.println("**--------------------------**");
 
        System.out.println("A aliança de " + p5.obterNome() + " é uma " + p5.obterLado());
        System.out.println("A aliança de " + p6.obterNome() + " é uma " + p6.obterLado());
        System.out.println("**--------------------------**");
 
        Princesa p7 = new PrincesaCrepuscular(p4, p1); 
        System.out.println(p7.obterNome() + " possui poder " + p7.obterPoder() + " e arma " + p7.obterArma());
        System.out.println("A aliança de " + p7.obterNome() + " é uma " + ((PrincesaCrepuscular) p7).obterLado());
        System.out.println("**--------------------------**");
 
        System.out.println("Foram criadas " + PrincesaGuerreira.getQtPrincesasGuerreiras() + " princesas guerreiras");
        System.out.println("Foram criadas " + AliancaPrincesas.getQtAliancaPrincesas() + " alianças");
        
    }
}