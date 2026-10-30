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
        this.setEnergiaMaxima(Integer.MAX_VALUE);
    }

    @Override
    public void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila) {
        Guerreiro alvo = Arena.obterAlvo(ladoInimigo, minhaFila);
        if (alvo != null) {
            alvo.setEnergia(alvo.getEnergia() - 20);
            System.out.println("   [BLASTER] " + this.getNome() + " atacou " + alvo.getNome() + "!");
        }

        // cura o aliado que está logo atrás dele na fila
        int pos = meuLado[minhaFila].indexOf(this);
        if (pos != -1 && pos + 1 < meuLado[minhaFila].size()) {
            Guerreiro aliado = meuLado[minhaFila].get(pos + 1);
            aliado.setEnergia(aliado.getEnergia() + 20);
            System.out.println("   [CURA] " + this.getNome() + " curou " + aliado.getNome() + " em 20 pontos!");
        }
    }
    
    @Override
    public String getTipo() {
        return "Clone Medico";
    }
    
}
