/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20161;

public abstract class Raca {
    public static final int PERTO = 1;
    public static final int MEDIO = 2;
    public static final int LONGE = 3;
    
    private int energia;    

    public Raca() {
        this.energia = 100;
    }
    
    public Raca(int energia) {
        this.energia = energia;
    }    

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
    
    public abstract void atacar(Raca alvo, int distancia);
}
