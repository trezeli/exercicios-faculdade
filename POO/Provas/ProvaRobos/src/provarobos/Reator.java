/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provarobos;

/**
 *
 * @author 2025122760375
 */
public class Reator extends Robo {
    private int titanio, cobre, silicio;

    public Reator(String cod, String categoria, String nome, int titanio, int cobre, int silicio) {
        super(cod, categoria, nome);
        this.titanio = titanio;
        this.cobre = cobre;
        this.silicio = silicio;
    }
    

    @Override
    public String obterGolpe() {
        return "Descarga de Energia Total"; 
    }
    
    public int obterPotencia(){
        return ((titanio * 5) + (cobre * 2) + (silicio * 3));
    }
}
