/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usaclasses;

public abstract class Carro {
    private double aceleracao;
    private double velocidadeMax;
    private double dirigibilidade;
    private int propulsao;

    public Carro(double aceleracao, double velocidadeMax, double dirigibilidade, int propulsao) {
        this.aceleracao = aceleracao;
        this.velocidadeMax = velocidadeMax;
        this.dirigibilidade = dirigibilidade;
        this.propulsao = propulsao;
    }

    public abstract double getPreco();

    @Override
    public String toString() {
        return  "Aceleracao = " + aceleracao + 
                ", Velocidade Maxima = " + velocidadeMax + 
                ", Dirigibilidade = " + dirigibilidade + 
                ", Propulsao = " + propulsao ;
    }
}
