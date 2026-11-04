/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

import java.util.Objects;

public abstract class Princesa {
    private final String nome;
    private String reino;
    private int idade, energia = 100;
    private static int qt = 0;
    private boolean congelada = false;

    public Princesa(String nome, String reino, int idade) {
        this.nome = nome;
        this.reino = reino;
        this.idade = idade;
        this.energia = 100;
        qt++;
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia < 0) energia = 0;
        if (energia > 100) energia = 100;
        this.energia = energia;
    }

    @Override
    public String toString() {
        return "Princesa " + nome + " do reino " + reino + ", " + idade + " anos, energia " + energia;
    }

    public static int getQt() {
        return qt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Princesa)) {
            return false;
        }
        final Princesa other = (Princesa) obj;
        return this.nome.equals(other.nome);
    }
    
    public abstract void atacar(Princesa alvo);
    
    public void congelar(){
        congelada = true;
    }
    
    protected void pagarCongelamento(){
        if(congelada){
            setEnergia(getEnergia() - 5);
        }
    }
}
