/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20242_2;

/**
 *
 * @author queir
 */
public class JiuJiteiroGracie extends JiuJiteiro{
    
    public JiuJiteiroGracie(String academia, String nome, double peso, int idade) {
        super(academia, nome, peso, idade);
    }

    @Override
    public void atacar(Lutador alvo) {
        alvo.setEnergia(alvo.getEnergia() - (this.peso / 3));
    }
    
    
}
