/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

/**
 *
 * @author 2025122760375
 */
public class PrincesaSolar extends PrincesaGuerreira {

    public PrincesaSolar(String nome, int poder) {
        super(nome, poder);
    }

    @Override
    public String obterArma() {
        return "Espada de Ouro";
    }
    
}
