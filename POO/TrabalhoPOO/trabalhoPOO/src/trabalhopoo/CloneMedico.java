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
public class CloneMedico extends Guerreiro {

    public CloneMedico(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        
        // ataque normal no inimigo da frente 
        if (!ladoInimigo[minhaFila].isEmpty()) {
            Guerreiro alvo = ladoInimigo[minhaFila].getFirst();
            alvo.setEnergia(alvo.getEnergia() - 20);
        }
        
        // curar o aliado de tras
        // so tenta curar se a fila tiver pelo menos 2 pessoas (medico e aliado)
        if (meuLado[minhaFila].size() > 1){
            // acessa guerreiro pos 1 da lista
            Guerreiro aliado = meuLado[minhaFila].get(1);
            aliado.setEnergia(aliado.getEnergia() + 20);
            
            System.out.println("   [CURA] " + this.getNome() + " curou " + aliado.getNome() + " em 25 pontos!");
        }
    }
    
}
