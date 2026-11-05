/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

/**
 *
 * @author 2025122760375
 */
public class PrincesaCrepuscular extends AliancaPrincesas {

    public PrincesaCrepuscular(PrincesaSolar p1, PrincesaLunar p2) {
        super(p1, p2);
    }
    
    public PrincesaCrepuscular(PrincesaLunar p2, PrincesaSolar p1) {
        super(p1, p2);
    }

    @Override
    public String obterArma() {
        return "Cristal do Crepúsculo";
    }
    
    public String obterLado(){
        if (p1.obterPoder() > p2.obterPoder()){
            return "Princesa da Luz";
        } else {
            return "Princesa das Trevas";
        }
    }
}
