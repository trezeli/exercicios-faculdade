/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20192;


public class Nobre extends Cruzada {
    private int nobres; 
    
    public Nobre(int soldados, int nobres) {
        super(soldados);
        this.nobres = nobres;
    }

    @Override
    public String lema() {
        return "Cruzada forte tem de ter nobres";
    }

    @Override
    public int getForca() {
        return ((soldados - nobres) * 10) + (nobres * 20) ; 
    }
    
}
