/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20152;

public abstract class Alimento {
    private double peso;
    private String nutrientes;
    private String validade;
    private static int qt;

    public Alimento(double peso, String validade) {
        this.peso = peso;
        this.validade = validade;
        qt++;
    }

    public String getNome() {
        return getClass().getSimpleName();
    }

    public static int getQuantidade() {
        return qt;
    }

    public double getPeso() {
        return peso;
    }

    public String getValidade() {
        return validade;
    }

    public abstract String getNutrientes();
    
    
    
}
