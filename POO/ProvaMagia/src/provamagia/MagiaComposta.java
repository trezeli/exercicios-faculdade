/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provamagia;

/**
 *
 * @author queir
 */
public abstract class MagiaComposta extends Magia {
    protected MagiaSimples m1, m2;

    public MagiaComposta(MagiaSimples m1, MagiaSimples m2) {
        super();
        this.m1 = m1;
        this.m2 = m2;
    }

    @Override
    public String obterNomeUsuario() {
        return m1.obterNomeUsuario() + " e " + m2.obterNomeUsuario();
    }

    @Override
    public int obterPoder() {
        return m1.obterPoder() + m2.obterPoder();
    }
    
}
