/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20152;

public class Inhame extends Legume {

    public Inhame(double peso, String validade) {
        super(peso, validade);
    }

    @Override
    public String getNutrientes() {
        return "Ferro, Proteína e Fibras";
    }
    
}
