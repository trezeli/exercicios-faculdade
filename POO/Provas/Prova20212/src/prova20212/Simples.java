/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20212;

public class Simples extends Oni {

    public Simples(String nome) {
        super(nome, 10);
    }

    @Override
    public void atacar(Oni alvo) {
        String tipo = alvo.getClass().getSimpleName();
        if (tipo.equals("Simples")){
            alvo.receberDano(getPoder());
        }
    }
   
}
