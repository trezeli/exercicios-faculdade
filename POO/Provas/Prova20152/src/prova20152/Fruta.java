/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20152;

public abstract class Fruta extends Alimento {

    public Fruta(double peso, String validade) {
        super(peso, validade);
    }

    @Override
    public abstract String getNutrientes();
    
}
