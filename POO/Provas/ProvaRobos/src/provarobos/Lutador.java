/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provarobos;

/**
 *
 * @author 2025122760375
 */
public abstract class Lutador extends Robo {
    private int forca, resistencia;
    private static int qt = 0;
    
    public Lutador(String cod, String categoria, String nome, int forca, int resistencia) {
        super(cod, categoria, nome);
        this.forca = forca;
        this.resistencia = resistencia;
        qt++;
    }

    public static int getQt() {
        return qt;
    }

    @Override
    public abstract String obterGolpe();
    
    public boolean ehPoderoso(){
        return ((forca * resistencia ) > 10);
    }
}
