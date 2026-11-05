/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20252;

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
    public String obterLado(){
        if (m1.obterPoder() > m2.obterPoder()){
            return "Magia do bem";
        } else {
            return "Magia do mal";
        }
    }
    
    @Override
    public String obterCor() {
        return "Cinza";
    }
    
}
