/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

/**
 *
 * @author queir
 */
public class Mulan extends Guerreira {
    private static int qtDerrotadas = 0;
    
    public Mulan(int idade) {
        super("Mulan", "China", idade, "Espada");
    }

    @Override
    protected int getDano() {
        return super.getDano() + 5 * qtDerrotadas;
    }

    @Override
    public void atacar(Princesa alvo) {
        boolean estavaViva = alvo.getEnergia() > 0;
        
        super.atacar(alvo);
        
        if (estavaViva && alvo.getEnergia() == 0){
            qtDerrotadas++;
        }
    }
    
    
}
