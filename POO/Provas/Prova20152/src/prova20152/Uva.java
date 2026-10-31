/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20152;

public class Uva extends Fruta {

    public Uva(double peso, String validade) {
        super(peso, validade);
    }

    @Override
    public String getNutrientes() {
        return "Cobre e Vitamina K";
    }
    
}
