/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20192;


public abstract class Cruzada {
    protected int soldados;
    private int forca;
    private static int qt;

    public Cruzada(int soldados) {
        this.soldados = soldados;
        qt++;
    }

    public int getForca() {
        return soldados * 10;
    }

    public static int getQt_Cruzada() {
        return qt;
    }
    
    public abstract String lema();
    
}
