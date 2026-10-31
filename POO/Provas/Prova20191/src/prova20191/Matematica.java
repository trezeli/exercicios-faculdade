/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20191;

public class Matematica extends Exatas {

    public Matematica(String ementa, String conteudoProgramatico) {
        super(ementa, conteudoProgramatico);
    }
    
    public Matematica() {
        super("Números", "123 456");
    }

    @Override
    public String getLema() {
        return "No meu universo tudo é exato";
    }
    
}
