/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20212;

public class LuaSuperior extends Oni {

    public LuaSuperior(String nome, int poder) {
        super(nome, poder, 300);
    }

    @Override
    public void atacar(Oni alvo) {
        String tipo = alvo.getClass().getSimpleName();
        if (tipo.equals("Simples") || (tipo.equals("LuaInferior"))){
            alvo.receberDano(this.getEnergia());
        } else if (tipo.equals("LuaSuperior")){
            alvo.receberDano(getPoder());
        }
    }

}
