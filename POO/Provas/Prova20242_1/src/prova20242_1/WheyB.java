/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20242_1;

public class WheyB extends Whey {

    public WheyB(double qtCarboidrato, String codigo, String fabricante, String nomeProduto) {
        super(codigo, fabricante, nomeProduto, 30, qtCarboidrato);
    }

    @Override
    public String obterEfeito() {
        if (this.isForte()) {
            return " Força e musculatura quase tão boa quanto WheyA ";
        } else {
            return " Um pouco de força e musculatura, mas nem tanto assim ";
        }
    }
    
}
