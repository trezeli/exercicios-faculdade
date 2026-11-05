/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20252;

/**
 *
 * @author queir
 */
public abstract class Magia {
    private static int qt = 0;

    public Magia() {
        qt++;
    }

    public static int getQtMagia() {
        return qt;
    }
    
    public abstract String obterNomeUsuario();
    public abstract String obterCor();
    public abstract int obterPoder();
}
