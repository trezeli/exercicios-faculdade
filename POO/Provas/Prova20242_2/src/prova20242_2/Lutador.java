/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20242_2;

/**
 *
 * @author queir
 */
public abstract class Lutador {
    private final String nome;
    protected double peso, energia;
    protected int idade;

    public Lutador(String nome, double peso, int idade) {
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.energia = 100;
    }

    public String getNome() {
        return nome;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }
    
    public abstract void atacar(Lutador alvo);

    @Override
    public String toString() {
        return "O Lutador " + nome + " atualmente pesa " + peso + " kilos, tem " + idade + " anos";
    }

}
