/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provamagia;

/**
 *
 * @author queir
 */
public class MagiaDemoniaca extends MagiaSimples {

    public MagiaDemoniaca(String nomeUsuario, int poder) {
        super(nomeUsuario, poder);
    }

    @Override
    public String obterCor() {
        return "Preto e Vermelho";
    }
    
}
