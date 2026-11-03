/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20242_2;

/**
 *
 * @author queir
 */
public class Karateca extends Lutador {
    protected String faixa;
    
    public Karateca(String faixa, String nome, double peso, int idade) {
        super(nome, peso, idade);
        this.faixa = faixa;
    }

    @Override
    public void atacar(Lutador alvo) {
        if (faixa.equals("Branca") || faixa.equals("Amarela")){
            alvo.setEnergia(alvo.getEnergia() - 5);
        }  else if (faixa.equals("Preta")){
            alvo.setEnergia(alvo.getEnergia() - 20);
        } else {
            alvo.setEnergia(alvo.getEnergia() - 10);
        }
    }

    @Override
    public String toString() {
        return "O Karateca " + getNome() + " esta na faixa " + faixa;
    }
    
}
