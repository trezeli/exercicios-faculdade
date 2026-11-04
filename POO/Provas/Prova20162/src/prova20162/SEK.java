/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20162;

/**
 *
 * @author Leter 07
 */
public abstract class SEK extends Equipe {
    private int qtRobo;
    
    public SEK(int qtRobo, int maxMembros, int atualMembros) {
        super(maxMembros, atualMembros);
        this.qtRobo = qtRobo;
    }
    
}
