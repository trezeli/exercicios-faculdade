/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class CloneComando extends Guerreiro {

    public CloneComando(String nome, int idade, int peso) {
        super(nome, idade, peso);
        this.setEnergiaMaxima(Integer.MAX_VALUE);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        Guerreiro alvo = Arena.obterAlvo(ladoInimigo, minhaFila);
        if (alvo == null) {
            return;
        }

        // conta os Clones Comando em sequência logo atrás dele
        LinkedList<Guerreiro> minhaLista = meuLado[minhaFila];
        int clonesAtras = 0;
        for (int i = minhaLista.indexOf(this) + 1; i < minhaLista.size(); i++) {
            if (minhaLista.get(i) instanceof CloneComando) {
                clonesAtras++;
            } else {
                break;
            }
        }

        int danoTotal = 40 + (clonesAtras * 8);
        alvo.setEnergia(alvo.getEnergia() - danoTotal);

        Arena.log("   [ESQUADRAO COMANDO] " + this.getNome() + " atacou com " + danoTotal
                + " de dano! (" + clonesAtras + " comandos na retaguarda)");
    }
    
    @Override
    public String getTipo() {
        return "Clone Comando";
    }
    
}
