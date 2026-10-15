/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provamagia;

/**
 *
 * @author queir
 */
public abstract class MagiaSimples extends Magia {
    private final String nomeUsuario;
    private final int poder;

    public MagiaSimples(String nomeUsuario, int poder) {
        super();
        this.nomeUsuario = nomeUsuario;
        this.poder = poder;
    }

    @Override
    public int obterPoder(){
        return this.poder;
    }

    @Override
    public String obterNomeUsuario(){
        return this.nomeUsuario;
    }
    
}
