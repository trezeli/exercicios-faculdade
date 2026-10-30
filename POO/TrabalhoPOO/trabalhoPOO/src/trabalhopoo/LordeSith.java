/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class LordeSith extends Guerreiro {

    public LordeSith(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        Guerreiro alvo = TrabalhoPOO.obterAlvo(ladoInimigo, minhaFila);
            if (alvo != null) {
                alvo.setEnergia(alvo.getEnergia() - 50);
            
            // reanimacao
            if (!alvo.isVivo()){
                EspectroSith fantasma = new EspectroSith(alvo.getNome(), alvo.getIdade(), alvo.getPeso());
                meuLado[minhaFila].addLast(fantasma);
                System.out.println("   [NECROMANCIA] " + this.getNome() + " reanimou " + alvo.getNome() + " como um Espectro Sith!");
            }
        }
    }
    
    @Override
    public void aoSerEliminado(LinkedList<Guerreiro>[] meuLado, int minhaFila){
        System.out.println("   [VINGANCA SITH] O Lorde " + this.getNome() + " caiu! 4 Acolitos surgem para o vingar!");
        for (int i = 0; i < 4; i++){
            AcolitoSith acolito = new AcolitoSith(this.getNome(), 0, 60);
            meuLado[minhaFila].addLast(acolito);
        }
    }
    
}
