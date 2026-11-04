/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20242_1;

public class Creatina extends Suplemento {
    private int qtArginina, qtGlicina, qtMetionina;
    
    public Creatina(String codigo, String fabricante, String nomeProduto, int qtArginina, int qtGlicina, int qtMetionina) {
        super(codigo, fabricante, nomeProduto);
        this.qtArginina = qtArginina;
        this.qtGlicina = qtGlicina;
        this.qtMetionina = qtMetionina;
    }

    @Override
    public String obterEfeito() {
        return "Energia para celulas musculares";
    }
    
    public int obterPureza(){
        return (qtArginina * 10) + (qtGlicina * 5) + qtMetionina;
    }
}
