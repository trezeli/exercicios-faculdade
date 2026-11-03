/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20242_2;

/**
 *
 * @author queir
 */
public class JiuJiteiro extends Lutador {
    private String academia;
    private static int qt;
    
    public JiuJiteiro(String academia, String nome, double peso, int idade) {
        super(nome, peso, idade);
        this.academia = academia;
        qt++;
    }

    public static int getQt() {
        return qt;
    }

    @Override
    public void atacar(Lutador alvo) {
        alvo.setEnergia(alvo.getEnergia() - (this.peso / 5));
    }

    @Override
    public String toString() {
        return super.toString() + " e luta na academia " + academia;
    }
    
}
