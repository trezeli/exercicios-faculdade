/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20222;

public abstract class Veiculo {
    private String fabricante;
    protected int anoFab, anoMod, cilindradas, qtRodas;
    private int potencia;

    public Veiculo(String fabricante, int anoFab, int anoMod, int cilindradas, int qtRodas) {
        this.fabricante = fabricante;
        this.anoFab = anoFab;
        this.anoMod = anoMod;
        this.cilindradas = cilindradas;
        this.qtRodas = qtRodas;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getAno_fabricacao() {
        return anoFab;
    }

    public int getAno_modelo() {
        return anoMod;
    }

}
