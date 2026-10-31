/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usaclasses;

public abstract class D extends Carro {
    private static int qtD;

    public D(double aceleracao, double velocidadeMax, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMax, dirigibilidade, propulsao);
        D.qtD++;
    }

    public static int getQtD() {
        return qtD;
    }
    
    
}
