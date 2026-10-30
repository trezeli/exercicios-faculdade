/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;
/**
 *
 * @author queir
 */
public class JediConsular extends Guerreiro {

    public JediConsular(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }
    
    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila){
        
        // ataque principal na mesma fila
        if (!ladoInimigo[minhaFila].isEmpty()){
            Guerreiro alvoPrincipal = ladoInimigo[minhaFila].getFirst();
            alvoPrincipal.setEnergia(alvoPrincipal.getEnergia() - 30);
        }
        
        // ataque fila de cima
        // if verifica se a fila atual eh maior q 0 e se a fila de cima nao ta vazia
        if (minhaFila > 0 && !ladoInimigo[minhaFila - 1].isEmpty()){
            Guerreiro alvoCima = ladoInimigo[minhaFila - 1].getFirst();
            alvoCima.setEnergia(alvoCima.getEnergia() - 15);
        }
        
        //ataque fila baixo
        if (minhaFila < 3 && !ladoInimigo[minhaFila + 1].isEmpty()){
            Guerreiro alvoBaixo = ladoInimigo[minhaFila + 1].getFirst();
            alvoBaixo.setEnergia(alvoBaixo.getEnergia() - 15);
        }
    }
}
