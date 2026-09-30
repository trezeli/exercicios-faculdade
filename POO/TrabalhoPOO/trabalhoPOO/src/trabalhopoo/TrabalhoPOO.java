/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhopoo;

public class TrabalhoPOO {

    public static void main(String[] args) {
        JediMestre yoda = new JediMestre("Yoda", 900, 20);
        DroideBatalha b2 = new DroideBatalha("B2-HA", 2, 120);
        
        System.out.println("energia do " + b2.getNome() + " antes do ataque: " + b2.getEnergia());
        yoda.atacar(b2);
        System.out.println("energia do " + b2.getNome() + " depois do ataque: " + b2.getEnergia());
    }
    
}
