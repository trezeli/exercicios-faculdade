/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class AssassinoSith extends Guerreiro {

    public AssassinoSith(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        Guerreiro alvo = TrabalhoPOO.obterAlvo(ladoInimigo, minhaFila);
        
        if (alvo != null) {
            alvo.setEnergia(alvo.getEnergia() - 20);

            alvo.setEnvenenado(true);
            System.out.println("   [TOXINA] " + this.getNome() + " envenenou " + alvo.getNome() + "!");
        }
    }
    
}
