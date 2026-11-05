/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

/**
 *
 * @author 2025122760375
 */
public abstract class AliancaPrincesas extends Princesa {
    protected PrincesaGuerreira p1, p2;
    private static int qt;

    public AliancaPrincesas(PrincesaGuerreira p1, PrincesaGuerreira p2) {
        this.p1 = p1;
        this.p2 = p2;
        qt++;
    }
    
    @Override
    public String obterNome() {
        return p1.obterNome() + " e " + p2.obterNome();
    }

    @Override
    public int obterPoder() {
        return (p1.obterPoder() + p2.obterPoder()); 
    }

    public static int getQtAliancaPrincesas() {
        return qt;
    }
    
}
