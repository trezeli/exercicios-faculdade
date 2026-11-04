/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20162;

/**
 *
 * @author Leter 07
 */
public class Asimov2D extends Soccer2D {

    public Asimov2D(String logo, int maxMembros, int atualMembros) {
        super(logo, maxMembros, atualMembros);
    }


    @Override
    public String jogar(Equipe equipe) {
        this.desempenhoPadrao++;
        return definirVencedor(this, equipe);
    }
    
    
}
