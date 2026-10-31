/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20161;

public class Tanque extends Humano {
    private static int qt = 0;

    public Tanque(String nome, String unidade) {
        super(nome, unidade);
        qt++;
    }
    
    @Override
    public void atacar(Raca alvo, int distancia) {
        alvo.setEnergia(alvo.getEnergia() - 30);
    }

    public static int getQt() {
        return qt;
    }

    
}
