/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

/**
 *
 * @author 2025122760375
 */
public abstract class PrincesaGuerreira extends Princesa {
    private final String nome;
    private final int poder;
    private static int qt;

    public PrincesaGuerreira(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
        qt++;
    }
    
    @Override
    public String obterNome() {
        return nome;
    }

    @Override
    public int obterPoder() {
        return poder;
    }

    public static int getQtPrincesasGuerreiras() {
        return qt;
    }
    
}
