/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20252;

/**
 *
 * @author queir
 */
public abstract class MagiaSimples extends Magia {
    private final String nomeUsuario;
    private final int poder;

    public MagiaSimples(String nomeUsuario, int poder) {
        this.nomeUsuario = nomeUsuario;
        this.poder = poder;
    }
    
    @Override
    public String obterNomeUsuario() {
        return nomeUsuario;
    }

    @Override
    public int obterPoder() {
        return poder;
    }
    
}
