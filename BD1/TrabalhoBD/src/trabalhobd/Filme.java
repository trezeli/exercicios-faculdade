/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhobd;

public class Filme {
    private int codFilme;
    private String nomFilme;
    private String codCor;
    private int codGenero;
    private String nomCor;
    private String nomGenero;
    
    public Filme(int codFilme, String nomFilme, String codCor, int codGenero) {
        this.codFilme = codFilme;
        this.nomFilme = nomFilme;
        this.codCor = codCor;
        this.codGenero = codGenero;
    }
    
    public Filme() {
        
    }

    public int getCodFilme() {
        return codFilme;
    }

    public void setCodFilme(int codFilme) {
        this.codFilme = codFilme;
    }

    public String getNomFilme() {
        return nomFilme;
    }

    public void setNomFilme(String nomFilme) {
        this.nomFilme = nomFilme;
    }

    public String getCodCor() {
        return codCor;
    }

    public void setCodCor(String codCor) {
        this.codCor = codCor;
    }

    public int getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    public String getNomCor() {
        return nomCor;
    }

    public void setNomCor(String nomCor) {
        this.nomCor = nomCor;
    }

    public String getNomGenero() {
        return nomGenero;
    }

    public void setNomGenero(String nomGenero) {
        this.nomGenero = nomGenero;
    }
    
    
    
}
