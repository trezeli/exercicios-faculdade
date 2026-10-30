/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class JediMestre extends Guerreiro {
    
    public JediMestre(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        Guerreiro alvo = Arena.obterAlvo(ladoInimigo, minhaFila);
        
        if(alvo != null){
            // Aplica o dano base do mestre
            alvo.setEnergia(alvo.getEnergia() - 40);
            System.out.println("   [EMPURRAO DA FORCA] " + this.getNome() + " atacou " + alvo.getNome() + "!");
        
            //se o alvo continou vivo e ha mais de um guerrerio na fila ele eh empurrado
            if (alvo.isVivo() && ladoInimigo[minhaFila].size() > 1){
                ladoInimigo[minhaFila].removeFirst();
                ladoInimigo[minhaFila].addLast(alvo);
                System.out.println("   [EMPURRAO DA FORCA] " + alvo.getNome() + " foi jogado para o final da fila!");
            }
        }
    }
}
