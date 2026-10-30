/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class AcolitoSith extends Guerreiro {

    public AcolitoSith(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        Guerreiro primeiro = Arena.obterAlvo(ladoInimigo, minhaFila);
        if (primeiro == null) {
            return;
        }

        int filaAlvo = Arena.filaDe(ladoInimigo, primeiro);

        // 1º ataque: no alvo da frente
        primeiro.setEnergia(primeiro.getEnergia() - 15);

        // 2º ataque: salta para o final e ataca o último da fila adversária
        Guerreiro ultimo = ladoInimigo[filaAlvo].getLast();
        ultimo.setEnergia(ultimo.getEnergia() - 15);

        System.out.println("   [SALTO SOMBRIO] " + this.getNome() + " atacou " + primeiro.getNome()
                + " e " + ultimo.getNome() + "!");
    }

    @Override
    public String getTipo() {
        return "Acolito Sith";
    }
    
}
