/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class JediGeneral extends Guerreiro {
    private int abates;

    public JediGeneral(String nome, int idade, int peso) {
        super(nome, idade, peso);
        this.abates = 0;
    }

    public int getAbates() {
        return abates;
    }
    
    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        Guerreiro alvo = Arena.obterAlvo(ladoInimigo, minhaFila);
        
        if (alvo != null){
            // dano base (50) + 5 p cada derrotado
            int danoComBonus = 50 + (this.abates * 5);
            alvo.setEnergia(alvo.getEnergia() - danoComBonus);
            
            // inimigo morreu com esse ataque?
            if (!alvo.isVivo()){
                this.abates++;
                
                this.setEnergia(this.getEnergia() + 20); // recupera 20
                
                System.out.println(" [EQUILIBRIO DA FORCA]" + this.getNome() +
                                   " derrotou " + alvo.getNome() +
                                   "! Abates: " + this.abates +
                                   " | Novo ataque: " + (50 + (this.abates * 5)));
            }
        }
    }
    
}
