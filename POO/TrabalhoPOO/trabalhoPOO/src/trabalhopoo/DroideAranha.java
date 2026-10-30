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
        int filaAlvo = Arena.obterFilaAlvo(ladoInimigo, minhaFila);
        if (filaAlvo == -1) {
            return;
        }

        System.out.println("   [VARREDURA LASER] " + this.getNome() + " disparou 10 de dano em TODOS da fila " + (filaAlvo + 1) + "!");
        for (Guerreiro g : ladoInimigo[filaAlvo]) {
            g.setEnergia(g.getEnergia() - 10);
        }
    }
    
    @Override
    public String getTipo() {
        return "Droide Aranha";
    }
    
}
