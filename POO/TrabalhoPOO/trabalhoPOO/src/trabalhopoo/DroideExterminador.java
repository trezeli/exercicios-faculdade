/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class DroideExterminador extends Guerreiro {

    public DroideExterminador(String nome, int idade, int peso) {
        super(nome, idade, peso);
        this.setEnergiaMaxima(60);
        this.setEnergia(60);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        Guerreiro alvo = TrabalhoPOO.obterAlvo(ladoInimigo, minhaFila);
        
        if (alvo != null) {
            System.out.println("   [GRANADA DE PLASMA] " + this.getNome() + 
                               " lançou uma granada de plasma em " + alvo.getNome() + " (ELIMINAÇÃO INSTANTÂNEA)!");
            
            // Zera a energia diretamente para garantir a eliminação instantânea
            alvo.setEnergia(0);
        }
    }
    
}
