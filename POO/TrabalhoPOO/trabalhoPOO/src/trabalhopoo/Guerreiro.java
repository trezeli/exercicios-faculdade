/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;
import java.util.LinkedList;

public abstract class Guerreiro {
    private String nome;
    private int idade;
    private int peso;
    private int energia = 100;
    private int energiaMaxima = 100;
    private boolean envenenado = false;

    public Guerreiro(String nome, int idade, int peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int novaEnergia) {
        if (novaEnergia > this.energiaMaxima){
            this.energia = this.energiaMaxima;   
        } else {
            this.energia = novaEnergia;
        }

    }

    public void setEnergiaMaxima(int energiaMaxima) {
        this.energiaMaxima = energiaMaxima;
    }

    public boolean isEnvenenado() {
        return envenenado;
    }

    public void setEnvenenado(boolean envenenado) {
        this.envenenado = envenenado;
    }
    
    public boolean isVivo(){
        return energia > 0;
    }
    
    public abstract void atacar(LinkedList<Guerreiro>[] ladoInimigo, LinkedList<Guerreiro>[] meuLado, int minhaFila);
    
    public void aoSerEliminado(LinkedList<Guerreiro>[] meuLado, int minhaFila){
        
    }
}
