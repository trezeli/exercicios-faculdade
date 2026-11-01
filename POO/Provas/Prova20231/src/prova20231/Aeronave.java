/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20231;

/**
 *
 * @author queir
 */
public abstract class Aeronave {
    private String fabricante;
    private double capacidadeAtaque;
    protected int anoFabricacao, anoModelo, capacidadeCarga, quantidadeMisseis;
    

    public Aeronave(String fabricante, int anoFabricacao, int anoModelo, int capacidadeCarga, int quantidadeMisseis) {
        this.fabricante = fabricante;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.capacidadeCarga = capacidadeCarga;
        this.quantidadeMisseis = quantidadeMisseis;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public int getQuantidadeMisseis() {
        return quantidadeMisseis;
    }

    public abstract double getCapacidadeAtaque();
    
}
