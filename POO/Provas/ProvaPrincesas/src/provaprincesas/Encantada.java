/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

/**
 *
 * @author queir
 */
public class Encantada extends Princesa {
    private int poderMagico;
    
    public Encantada(String nome, String reino, int idade, int poderMagico) {
        super(nome, reino, idade);
        this.poderMagico = poderMagico;
    }

    @Override
    public void atacar(Princesa alvo) {
        pagarCongelamento();
        alvo.setEnergia(alvo.getEnergia() - this.poderMagico);
        this.setEnergia((this.getEnergia() + 10));
    }
    
}
