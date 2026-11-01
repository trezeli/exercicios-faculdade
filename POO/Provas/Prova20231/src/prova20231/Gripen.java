/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20231;

/**
 *
 * @author queir
 */
public class Gripen extends Caca {

    public Gripen(String fabricante, int anoFabricacao, int anoModelo, int capacidadeCarga, int avionica) {
        super(fabricante, anoFabricacao, anoModelo, capacidadeCarga, 6, avionica);
    }

    @Override
    public double getCapacidadeAtaque() {
        return super.getCapacidadeAtaque() * 1.5;
    }
    
}
