/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20162;

/**
 *
 * @author Leter 07
 */
public abstract class Equipe {
    protected int maxMembros, atualMembros, desempenhoPadrao, partDisputadas;

    public Equipe(int maxMembros, int atualMembros) {
        this.maxMembros = maxMembros;
        this.atualMembros = atualMembros;
        this.desempenhoPadrao = 1;
        this.partDisputadas = 0;
    }

    public int getDesempenho() {
        return desempenhoPadrao;
    }

    public void setDesempenho(int desempenhoPadrao) {
        this.desempenhoPadrao = desempenhoPadrao;
    }
    
    public String jogar(Equipe equipe){
        equipe.partDisputadas++;
        this.partDisputadas++;
        return "";
    }
    
    protected static String definirVencedor(Equipe equipe1, Equipe equipe2) {
        double valorEQuipe1 = Math.random();
        double valorEquipe2 = Math.random();
        if ((valorEQuipe1 * equipe1.getDesempenho()) > valorEquipe2 * equipe2.getDesempenho()) {
            return equipe1.getClass().getSimpleName() + " VENCEU " + equipe2.getClass().getSimpleName();
        } else {
            return equipe1.getClass().getSimpleName() + " PERDEU para " + equipe2.getClass().getSimpleName();
        }

    }

}
