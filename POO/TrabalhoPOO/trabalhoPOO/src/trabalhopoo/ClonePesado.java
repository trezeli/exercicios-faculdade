/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class ClonePesado extends Guerreiro{

    public ClonePesado(String nome, int idade, int peso) {
        super(nome, idade, peso);
        this.setEnergiaMaxima(400);
        this.setEnergia(400);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        // ativa provocamento da rodadis
        TrabalhoPOO.provocaLado1 = this;
        System.out.println("   [PROVOCACAO] " + this.getNome() + " ativou a provocacao!");
        
        Guerreiro alvo = TrabalhoPOO.obterAlvo(ladoInimigo, minhaFila);
        
        if (alvo != null){
            alvo.setEnergia(alvo.getEnergia() - 30);
            System.out.println("   [CANHÃO AT-RT] " + this.getNome() + " disparou 30 de dano em " + alvo.getNome() + "!");
        }
    }
    
}
