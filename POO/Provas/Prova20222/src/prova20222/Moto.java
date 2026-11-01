/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20222;

/**
 *
 * @author queir
 */
public class Moto extends Veiculo {
    private String cor;
    
    public Moto(String cor, String fabricante, int anoFab, int anoMod, int cilindradas, int qtRodas) {
        super(fabricante, anoFab, anoMod, cilindradas, qtRodas);
        this.cor = cor;
    }

    public Moto(String fabricante, int anoFab, int anoMod, int cilindradas, int qtRodas) {
        this("Incolor", fabricante, anoFab, anoMod, cilindradas, qtRodas);
    }

    @Override
    public int getPotencia() {
        return cilindradas / qtRodas;
    }

    public String getCor() {
        return cor;
    }
    
}
