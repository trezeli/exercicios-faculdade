/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class JediConsular extends Guerreiro {

    public JediConsular(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }
    
    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila){
        Guerreiro alvo = Arena.obterAlvo(ladoInimigo, minhaFila);
        
        if (alvo == null){
            return;
        }
        
        int f = Arena.filaDe(ladoInimigo, alvo);
        alvo.setEnergia(alvo.getEnergia() - 30);
        Arena.log("   [ONDA DA FORCA] " + this.getNome() + " atacou " + alvo.getNome() + " e os inimigos das filas proximas!");
        if (f > 0 && !ladoInimigo[f - 1].isEmpty()){
            Guerreiro g = ladoInimigo[f - 1].getFirst();
            g.setEnergia(g.getEnergia() - 15);
        }
        if (f < 3 && !ladoInimigo[f + 1].isEmpty()){
            Guerreiro g = ladoInimigo[f + 1].getFirst();
            g.setEnergia(g.getEnergia() - 15);
        }
    }
    
    @Override
    public String getTipo() {
        return "Jedi Consular";
    }
}
