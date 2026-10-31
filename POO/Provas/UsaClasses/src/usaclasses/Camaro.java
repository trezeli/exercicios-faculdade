/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usaclasses;

public class Camaro extends C {

    public Camaro(double aceleracao, double velocidadeMax, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMax, dirigibilidade, propulsao);
    }

    @Override
    public double getPreco() {
        return 110000;
    }
    
}
