/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

/**
 *
 * @author queir
 */
public class Guerreira extends Princesa {
    private String arma;
    
    public Guerreira(String nome, String reino, int idade, String arma) {
        super(nome, reino, idade);
        this.arma = arma;
    }

    
    @Override
    public void atacar(Princesa alvo) {
        pagarCongelamento();
        alvo.setEnergia(alvo.getEnergia() - getDano());
    }
 
    protected int getDano(){
        if (arma.equals("Espada")){
            return 35;
        } else {
            return 25;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + ", arma " + arma;
    }
    
}
