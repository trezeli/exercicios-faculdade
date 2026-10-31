/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usaclasses;

public abstract class B extends Carro {
    private static int qtB;

    public B(double aceleracao, double velocidadeMax, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMax, dirigibilidade, propulsao);
        B.qtB++;
    }
    
    public static int getQtB() {
        return qtB;
    }
}
