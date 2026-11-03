/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20241;

/**
 *
 * @author queir
 */
public abstract class Inseto extends Animal {
    private static int prox = 1;
    
    public Inseto(double peso, int idade) {
        super(String.valueOf(prox++), peso, idade);
    }

    @Override
    public abstract String comer();


    
}
