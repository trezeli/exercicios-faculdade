/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20192;


public class Popular extends Cruzada {
    private int mulheres, velhos, criancas;
    
    public Popular(int soldados, int mulheres, int velhos, int criancas) {
        super(soldados);
        this.mulheres = mulheres;
        this.velhos = velhos;
        this.criancas = criancas;
    }

    @Override
    public int getForca() {
        return super.getForca() + (mulheres * 3) + (velhos * 2) + criancas; 
    }

    @Override
    public String lema() {
        return "Viver é preciso, mas faltam recursos";
    }
    
}
