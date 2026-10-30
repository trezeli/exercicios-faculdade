/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class AcolitoSith extends Guerreiro {

    public AcolitoSith(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        if(!ladoInimigo[minhaFila].isEmpty()){
            
            //primeiro ataque no primeiro da fila dano 15
            Guerreiro alvoDaFrente = ladoInimigo[minhaFila].getFirst();
            alvoDaFrente.setEnergia(alvoDaFrente.getEnergia() - 15);
            
            //segundo ataque no ultimo da fila dano 15
            // se tiver apenas 1 ele sofre os dois ataques
            if(!ladoInimigo[minhaFila].isEmpty()){
                Guerreiro alvoDeTras = ladoInimigo[minhaFila].getLast();
                alvoDeTras.setEnergia(alvoDeTras.getEnergia() - 15);
            }
        }
    }
    
}
