/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20212;

public class LuaInferior extends Oni {

    public LuaInferior(String nome, int poder) {
        super(nome, poder, 200);
    }

    @Override
    public void atacar(Oni alvo) {
        String tipo = alvo.getClass().getSimpleName();
        if (tipo.equals("Simples")){
            alvo.receberDano(getPoder());
        } else if (tipo.equals("LuaInferior")){
            alvo.receberDano(getPoder() / 2);
        } else if (tipo.equals("LuaSuperior")){
            alvo.receberDano(getPoder() / 10);
        }
    }
    
}
