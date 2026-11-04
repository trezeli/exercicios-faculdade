/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provarobos;

import java.util.Objects;

public abstract class Robo {
    private String cod, categoria, nome;

    public Robo(String cod, String categoria, String nome) {
        this.cod = cod;
        this.categoria = categoria;
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Robo other = (Robo) obj;
        return Objects.equals(this.cod, other.cod);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "O robo de codigo = " + cod + ", categoria = " + categoria + ", tem nome = " + nome;
    }
    
    public abstract String obterGolpe();
}
