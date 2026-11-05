/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

/**
 *
 * @author 2025122760375
 */
public class PrincesaLunar extends PrincesaGuerreira {

    public PrincesaLunar(String nome, int poder) {
        super(nome, poder);
    }

    @Override
    public String obterArma() {
        return "Adaga das Sombras";
    }
    
}
