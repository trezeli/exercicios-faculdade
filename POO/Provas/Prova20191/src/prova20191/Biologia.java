/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20191;

public class Biologia extends Biomedicas {
    
    public Biologia(String ementa, String conteudoProgramatico) {
        super(ementa, conteudoProgramatico);
    }

    @Override
    public String getLema() {
        return "A vida é uma constante evolução";
    }
    
}
