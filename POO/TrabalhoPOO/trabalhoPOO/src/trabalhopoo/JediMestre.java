/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

public class JediMestre extends Guerreiro {
    
    public JediMestre(String nome, int idade, int peso) {
        super(nome, idade, peso);
    }

    @Override
    public void atacar(Guerreiro alvo) {
        int energiaAtualAlvo = alvo.getEnergia();
        alvo.setEnergia(energiaAtualAlvo - 35);
    }
    
    
}
