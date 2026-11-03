/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20241;

/**
 *
 * @author queir
 */
public abstract class Animal {
    private final String nome;
    private double peso;
    private int idade;

    public Animal(String nome, double peso, int idade) {
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
    }
    
    public abstract String comer();

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "O(a) " +getClass().getSimpleName() + " de nome " + getNome() +" possui peso igual a " + peso +" e idade igual a " + idade;
    }
    
    
}
