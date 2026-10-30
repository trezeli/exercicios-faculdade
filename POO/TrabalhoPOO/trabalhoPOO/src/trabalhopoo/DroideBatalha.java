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

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        Guerreiro alvo = TrabalhoPOO.obterAlvo(ladoInimigo, minhaFila);
        
        if (alvo != null) {
            alvo.setEnergia(alvo.getEnergia() - 15);
            System.out.println("   [TIRO LASER] " + this.getNome() + " disparou 15 de dano em " + alvo.getNome() + "!");
        }
        
    }

    @Override
    public void aoSerEliminado(LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        //calcula metade da energia q ele tinha 
        int metadeEnergia = this.getEnergia() /2;
        
        //so se divide se a nova energia for maior q 1 ponto
        if (metadeEnergia > 1){
            DroideBatalha d1 = new DroideBatalha(this.getNome() + "_1", this.getIdade(), this.getPeso());
            DroideBatalha d2 = new DroideBatalha(this.getNome() + "_2", this.getIdade(), this.getPeso());
            
            d1.setEnergiaMaxima(metadeEnergia);
            d1.setEnergia(metadeEnergia);
            
            d2.setEnergiaMaxima(metadeEnergia);
            d2.setEnergia(metadeEnergia);
            
            meuLado[minhaFila].addLast(d1);
            meuLado[minhaFila].addLast(d2);
            
            System.out.println("   [DIVISAO DROIDE] " + this.getNome() + 
                               " foi destruido, mas dividiu-se em 2 novos Droides de Batalha com " + 
                               metadeEnergia + " de vida cada!");
        }
    }
    
    
}