/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20242_1;

public abstract class Suplemento {
    private String codigo, fabricante, nomeProduto;
    private static int qt = 0;

    public Suplemento(String codigo, String fabricante, String nomeProduto) {
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.nomeProduto = nomeProduto;
        qt++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Suplemento other = (Suplemento) obj;
        return this.codigo == other.codigo;
    }
    
    public abstract String obterEfeito();

    public String getNomeProduto() {
        return nomeProduto;
    }

    public static int getQt() {
        return qt;
    }

    @Override
    public String toString() {
        return "O suplemento de codigo = " + codigo + " possui como fabricante = " + fabricante + " e nome = " + nomeProduto ;
    }
    
    
}
