/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20222;

/**
 *
 * @author queir
 */
public abstract class Carro extends Veiculo {
    private int qt_portas;
    private String corCarroceria, corTeto;
    
    public Carro(int qt_portas, String corCarroceria, String corTeto, String fabricante, int anoFab, int anoMod, int cilindradas) {
        super(fabricante, anoFab, anoMod, cilindradas, 4);
        this.corCarroceria = corCarroceria;
        this.corTeto = corTeto;
        this.qt_portas = qt_portas;
    }

    @Override
    public int getPotencia() {
        return cilindradas * qt_portas / 4; 
    }
    
}
