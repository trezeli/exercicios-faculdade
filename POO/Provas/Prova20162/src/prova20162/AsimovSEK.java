/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20162;

/**
 *
 * @author Leter 07
 */
public class AsimovSEK extends SEK {

    public AsimovSEK(int qtRobo, int maxMembros, int atualMembros) {
        super(qtRobo, maxMembros, atualMembros);
    }
    

    @Override
    public String jogar(Equipe equipe) {
        if (this.atualMembros > 3){
            this.setDesempenho(getDesempenho() + 3);
        }
        this.desempenhoPadrao++;
        return definirVencedor(this, equipe);
    }
    
    
}
