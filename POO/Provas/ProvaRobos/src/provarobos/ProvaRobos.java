/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package provarobos;

public class ProvaRobos {
    public static void main(String[] args) {
 
        // Todo LutadorX é criado com código, categoria e nome, nessa ordem
        // Todo LutadorX possui 5 de força 10 de resistência
        Robo robo1 = new LutadorX("1", "Max Titanium", "Aço Fatal");
        LutadorX robo2 = new LutadorX("1", "Max", "Aço 100");
        // São iguais se os códigos forem iguais
        if(robo1.equals(robo2)){
            System.out.println("Apesar da categoria e "
                    + "do nome serem diferentes, "+
                    " são o mesmo Lutador: ");
            System.out.println(robo1);
            System.out.println(robo2);
        }
        // Todo LutadorY é criado com resistência, código, categoria
        // e nome, nessa ordem
        // Todo LutadorY possui 3 de força
        Lutador robo3 = new LutadorY(2, "2", "Supra Max Best Combat", "Destruidor 1000" );
        Robo robo4 = new LutadorY(10, "3", "Simple Combat", "Destruidor Bom" );
        System.out.println("**  Vamos ver os golpes dos Lutadores:  **");
        System.out.println(robo1.obterGolpe());
        System.out.println(robo2.obterGolpe());
        System.out.println(robo3.obterGolpe());
        System.out.println(robo4.obterGolpe());
        System.out.println("******");
 
        // Um Reator tem código, categoria, nome e quantidades de 
        // titânio, cobre e silicio, nessa ordem
        Reator reator = new Reator("4", "Reactor Labs", "Reator 100", 50, 20, 40);
        System.out.println("A potência do reator " + reator.getNome() +
                " é " + reator.obterPotencia());
        System.out.println("**  Vamos ver o golpe do reator:  **");
        System.out.println(reator.obterGolpe());
        System.out.println("******");
 
        System.out.println("Foram criados " + Lutador.getQt() + " lutadores");

    }
}