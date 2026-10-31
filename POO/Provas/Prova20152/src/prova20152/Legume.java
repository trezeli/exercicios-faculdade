/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20152;

public abstract class Legume extends Alimento {
    private Legume combinacao;
    
    public Legume(double peso, String validade) {
        super(peso, validade);
    }
    
    public void combinar(Legume outro){
        this.combinacao = outro;
    }
    
    public String getCombinacao(){
        return getNome() + " e " + combinacao.getNome();
    }
    @Override
    public abstract String getNutrientes();
}
