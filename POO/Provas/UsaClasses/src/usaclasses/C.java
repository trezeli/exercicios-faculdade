/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usaclasses;

public abstract class C extends Carro {
    private static int qtC;

    public C(double aceleracao, double velocidadeMax, double dirigibilidade, int propulsao) {
        super(aceleracao, velocidadeMax, dirigibilidade, propulsao);
        C.qtC++;
    }

    public static int getQtC() {
        return qtC;
    }
    
    
}
