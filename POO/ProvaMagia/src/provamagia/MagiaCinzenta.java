/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provamagia;

/**
 *
 * @author queir
 */
public class MagiaCinzenta extends MagiaComposta {

    public MagiaCinzenta(MagiaSagrada m1, MagiaDemoniaca m2) {
        super(m1, m2);
    }
    public MagiaCinzenta(MagiaDemoniaca m2, MagiaSagrada m1) {
        super(m1, m2);
    }

    @Override
    public String obterCor() {
        return "Cinza";
    }
    
    public String obterLado(){
        if (this.m1.obterPoder() > this.m2.obterPoder()){
            return "Magia do bem";
        } else {
            return "Magia do mal";
        }
    }
}
