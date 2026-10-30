/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class CloneComando extends Guerreiro {

    public CloneComando(String nome, int idade, int peso) {
        super(nome, idade, peso);
        this.setEnergiaMaxima(Integer.MAX_VALUE);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        if (!ladoInimigo[minhaFila].isEmpty()){
            
            // conta qnts clone com estao em sequencia atras 
            int clonesAtras = 0;
            LinkedList<Guerreiro> minhaLista = meuLado[minhaFila];
            
            // comeca do indice 1 (logo atras do atacante)
            for (int i = 1; i < minhaLista.size(); i++){
                if (minhaLista.get(i) instanceof CloneComando){
                    clonesAtras++;
                } else {
                    break;
                }
            }
            
            int danoTotal = 40 + (clonesAtras * 8);
            
            Guerreiro alvo = ladoInimigo[minhaFila].getFirst();
            alvo.setEnergia(alvo.getEnergia() - danoTotal);
            
            System.out.println("   [ESQUADRAO COMANDO] " + this.getNome() +  
                               " atacou com " + danoTotal + " de dano! (" +
                               clonesAtras + " comandos na retaguarda)");          
        }
    }
    
}
