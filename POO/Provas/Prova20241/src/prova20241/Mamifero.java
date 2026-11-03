/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20241;

/**
 *
 * @author queir
 */
public abstract class Mamifero extends Animal {
    private int qtLeiteConsumido;
    
    public Mamifero(String nome, double peso, int idade, int qtLeiteConsumido) {
        super(nome, peso, idade);
        this.qtLeiteConsumido = qtLeiteConsumido;
    }

    @Override
    public abstract String comer();

}
