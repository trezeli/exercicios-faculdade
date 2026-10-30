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
        Guerreiro alvo = Arena.obterAlvo(ladoInimigo, minhaFila);
        
        if (alvo != null) {
            alvo.setEnergia(alvo.getEnergia() - 20);

            alvo.setEnvenenado(true);
            Arena.log("   [TOXINA] " + this.getNome() + " envenenou " + alvo.getNome() + "!");
        }
    }
    
    @Override
    public String getTipo() {
        return "Assassino Sith";
    }
}
