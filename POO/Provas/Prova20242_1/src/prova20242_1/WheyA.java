/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20242_1;

public class WheyA extends Whey {

    public WheyA(String codigo, String fabricante, String nomeProduto) {
        super(codigo, fabricante, nomeProduto, 45, 5);
    }

    @Override
    public String obterEfeito() {
        return "Força e musculatura";
    }
    
}
