/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provarobos;

/**
 *
 * @author 2025122760375
 */
public class LutadorY extends Lutador {

    public LutadorY(int resistencia, String cod, String categoria, String nome ) {
        super(cod, categoria, nome, 3, resistencia);
    }


    @Override
    public String obterGolpe() {
        if (ehPoderoso()){
            return "Golpe Avassalador";
        } else {
            return "Golpe Pluma";
        }
    }
    
}
