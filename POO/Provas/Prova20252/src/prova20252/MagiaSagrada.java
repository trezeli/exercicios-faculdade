/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20252;

/**
 *
 * @author queir
 */
public class MagiaSagrada extends MagiaSimples {
    
    public MagiaSagrada(String nomeUsuario, int poder) {
        super(nomeUsuario, poder);
    }

    @Override
    public String obterCor() {
        return "Branco";
                
    }

    @Override
    public int obterPoder() {
        return super.obterPoder(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
