/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provamagia;

/**
 *
 * @author queir
 */
public abstract class Magia {
    private static int qt = 0;

    public Magia() {
        Magia.qt++;
    }
    
    
    public static int getQtMagia(){
        return Magia.qt++;
    }
    
    public abstract String obterNomeUsuario();
    public abstract int obterPoder();
    public abstract String obterCor();
}
