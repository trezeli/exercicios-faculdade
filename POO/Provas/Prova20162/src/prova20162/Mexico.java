/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20162;

/**
 *
 * @author Leter 07
 */
public class Mexico extends SEK {

    public Mexico(int qtRobo, int maxMembros, int atualMembros) {
        super(qtRobo, maxMembros, atualMembros);
        this.desempenhoPadrao = 5;
    }
    

    @Override
    public String jogar(Equipe equipe) {
        this.setDesempenho(getDesempenho() - 1);
        this.desempenhoPadrao++;
        return definirVencedor(this, equipe);
    }
    
}
