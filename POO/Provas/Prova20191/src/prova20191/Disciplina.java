/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20191;

public abstract class Disciplina {
    protected String ementa;
    protected String conteudoProgramatico;
    protected String lema;
    private static int qt = 0;

    public Disciplina(String ementa, String conteudoProgramatico) {
        this.ementa = ementa;
        this.conteudoProgramatico = conteudoProgramatico;
        qt++;
    }

    public String getLema() {
        return lema;
    } 

    public static int getQtDisciplinas() {
        return qt;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " tem ementa = " + ementa + " e conteudoProgramatico = " + conteudoProgramatico;
    }
    
    
}
