/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20161;

public class Barata extends Zerg {

    public Barata(String colonia) {
        super(colonia);
    }

    @Override
    public void atacar(Raca alvo, int distancia) {
        if(distancia == PERTO){
            alvo.setEnergia(alvo.getEnergia() - 25);
        } else if (distancia == MEDIO){
            alvo.setEnergia(alvo.getEnergia() - 20);
        }
    }
    
    public void entocar(){
        setEnergia(getEnergia() + 5);
    }
    
}
