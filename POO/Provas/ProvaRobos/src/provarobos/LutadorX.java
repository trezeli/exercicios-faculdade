/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provarobos;

/**
 *
 * @author 2025122760375
 */
public class LutadorX extends Lutador {

    public LutadorX(String cod, String categoria, String nome) {
        super(cod, categoria, nome, 5, 10);
    }



    @Override
    public String obterGolpe() {
        return "Golpe Esmagador";
    }
    
}
