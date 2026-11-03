/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provaprincesas;

import java.util.Objects;

public abstract class Princesa {
    private final String nome;
    private String reino;
    private int idade, energia;
    private static int qt = 0;

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
        this.energia = Math.max(0, energia);
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Princesa other = (Princesa) obj;
        return Objects.equals(this.nome, other.nome);
    }
    
    public abstract void atacar(Princesa alvo);
    
    
}
