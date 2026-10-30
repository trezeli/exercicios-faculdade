/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class DroideBatalha extends Guerreiro {
    
    public DroideBatalha(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    public DroideBatalha(String nome, int idade, int peso, int energia) {
        super(nome, idade, peso);
        this.setEnergiaMaxima(energia);
        this.setEnergia(energia);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        Guerreiro alvo = Arena.obterAlvo(ladoInimigo, minhaFila);
        if (alvo != null) {
            alvo.setEnergia(alvo.getEnergia() - 10);
            Arena.log("   [TIRO LASER] " + this.getNome() + " disparou 10 de dano em " + alvo.getNome() + "!");
        }
    }

    @Override
    public void aoSerEliminado(LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        int original = this.getEnergiaMaxima();   // energia com que ele nasceu
        int metade = original / 2;

        if (original > 1) {
            meuLado[minhaFila].addLast(new DroideBatalha(getNome() + "1", getIdade(), getPeso(), metade));
            meuLado[minhaFila].addLast(new DroideBatalha(getNome() + "2", getIdade(), getPeso(), metade));
            Arena.log("   [DIVISAO DROIDE] " + getNome() + " foi destruido e dividiu-se em 2 droides com "
                    + metade + " de energia cada!");
        }
    }
    
    @Override
    public String getTipo() {
        return "Droide de Batalha";
    }
    
}