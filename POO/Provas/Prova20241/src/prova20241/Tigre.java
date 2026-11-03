/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20241;

/**
 *
 * @author queir
 */
public class Tigre extends Mamifero {

    public Tigre(String nome, double peso, int idade, int qtLeiteConsumido) {
        super(nome, peso, idade, qtLeiteConsumido);
    }

    public Tigre acasalar(Tigre papai){
        String filhote = this.getNome() + papai.getNome();
        return new Tigre(filhote, 10, 0, 10);
    }
    
    @Override
    public String comer() {
        return "Roarrrrr";
    }
    
}
