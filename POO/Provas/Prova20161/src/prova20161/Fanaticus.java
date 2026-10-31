/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20161;

public class Fanaticus extends Proton {

    public Fanaticus(int energia) {
        super(energia);
    }

    @Override
    public void atacar(Raca alvo, int distancia) {
        if (distancia == PERTO){
            alvo.setEnergia(alvo.getEnergia() - 40);
        }
    }


    
}
