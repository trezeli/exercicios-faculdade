/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20231;

/**
 *
 * @author queir
 */
public abstract class Helicoptero extends Aeronave {
    private int quantidadeHelices;
    private double potenciaMotor;

    public Helicoptero(String fabricante, int anoFabricacao, int anoModelo, int capacidadeCarga, int quantidadeMisseis, int quantidadeHelices, double potenciaMotor) {
        super(fabricante, anoFabricacao, anoModelo, capacidadeCarga, quantidadeMisseis);
        this.quantidadeHelices = quantidadeHelices;
        this.potenciaMotor = potenciaMotor;
    }

    @Override
    public double getCapacidadeAtaque() {
        return (double) (quantidadeHelices * potenciaMotor * 2) / quantidadeMisseis;
    }

    public int getQuantidadeHelices() {
        return quantidadeHelices;
    }

    public double getPotenciaMotor() {
        return potenciaMotor;
    }
    
    
}
