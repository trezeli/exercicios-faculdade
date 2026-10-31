/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usaclasses;

public class Tesla extends D {

    public Tesla(double aceleracao, double velocidadeMax, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMax, dirigibilidade, propulsao);
    }

    @Override
    public double getPreco() {
        return 60000;
    }
    
}
