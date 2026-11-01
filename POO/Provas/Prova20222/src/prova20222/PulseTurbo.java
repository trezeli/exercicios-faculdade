/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20222;

/**
 *
 * @author queir
 */
public class PulseTurbo extends Carro{
    
    public PulseTurbo(int qt_portas, String fabricante, int anoFab, int anoMod, int cilindradas) {
        super(qt_portas, "Vermelho", "Branco", fabricante, anoFab, anoMod, cilindradas);
    }

    @Override
    public int getPotencia() {
        return super.getPotencia() + 500; 
    }
    
    
    
}
