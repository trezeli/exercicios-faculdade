/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class DroideAranha extends Guerreiro {

    public DroideAranha(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        int filaAlvo = minhaFila;
        
        //se houver provocacao do clone pesado ativa,descobre pra focar la na fila dele
        if (Arena.provocaLado1 != null && Arena.provocaLado1.isVivo()){
            for (int f = 0; f < 4; f++){
                filaAlvo = f;
                break;
            }
        }
        
        LinkedList<Guerreiro> filaInimiga = ladoInimigo[filaAlvo];
        
        //se a fila tiver guerreiros aplica 10 de dano a TODOS de uma vez
        if (!filaInimiga.isEmpty()){
            System.out.println("   [VARREDURA LASER] " + this.getNome() + " disparou 10 de dano em TODOS os guerreiros da fila " + (filaAlvo + 1) + "!");
            
            for (Guerreiro g : filaInimiga){
                g.setEnergia(g.getEnergia() - 10);
            }
        }
    }
    
}
