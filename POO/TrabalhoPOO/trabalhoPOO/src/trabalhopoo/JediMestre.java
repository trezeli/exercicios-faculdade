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
            boolean foiPrimeiro = Arena.primeiroAtaque;
            alvo.setEnergia(alvo.getEnergia() - 35);
            if (foiPrimeiro && alvo.isVivo()){
                int f = Arena.filaDe(ladoInimigo, alvo);
                if (f != -1 && ladoInimigo[f].size() > 1){
                    ladoInimigo[f].remove(alvo);
                    ladoInimigo[f].addLast(alvo);
                }
                alvo.setImpedido(true);
            }
        }
    }
    
    @Override
    public String getTipo() {
        return "Jedi Mestre";
    }
}
