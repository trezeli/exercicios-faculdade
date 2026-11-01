/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20212;

public abstract class Oni {
    private final String nome;
    private int poder;
    private int energia;
    private static int qt;
    
    public Oni(String nome, int poder, int energia) {
        this.nome = nome;
        this.poder = poder;
        this.energia = energia;
        qt++;
    }

    public Oni(String nome, int poder) {
        this(nome, poder, 100);
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = Math.max(0, energia);
    }

    public static int getQt() {
        return qt;
    }
    
    public String getNome() {
        return getClass().getSimpleName();
    }

    public int getPoder() {
        return poder;
    }
    
    public abstract void atacar(Oni alvo);
    
    public void receberDano(int dano){
        setEnergia(this.energia - dano);
    }
}
