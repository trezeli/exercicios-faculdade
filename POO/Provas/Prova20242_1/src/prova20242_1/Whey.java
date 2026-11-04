/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20242_1;

public abstract class Whey extends Suplemento {
    private double qtProteina, qtCarboidrato;
    
    public Whey(String codigo, String fabricante, String nomeProduto, double qtProteina, double qtCarboidrato) {
        super(codigo, fabricante, nomeProduto);
        this.qtProteina = qtProteina;
        this.qtCarboidrato = qtCarboidrato;
    }
    
    public abstract String obterEfeito();
    
    public boolean isForte(){
        return (qtProteina /qtCarboidrato) > 5;
    }
}
