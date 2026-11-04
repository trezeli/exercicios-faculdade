/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

public class Elsa extends Encantada {
    private boolean congelada = false;
    
    public Elsa(int idade) {
        super("Elsa", "Arendelle", idade, 40);
    }

    @Override
    public void atacar(Princesa alvo) {
        super.atacar(alvo);
        alvo.congelar();
    }
    
    
}
