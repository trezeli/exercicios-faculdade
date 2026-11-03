/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20232;

public abstract class Drone {
    protected final int numeroSerie, anoFabricacao;

    public Drone(int numeroSerie, int anoFabricacao) {
        this.numeroSerie = numeroSerie;
        this.anoFabricacao = anoFabricacao;
    }

    public abstract double getValor();
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof Drone)) return false;
        Drone outro = (Drone) obj;
        return this.numeroSerie == outro.numeroSerie;
    }

    @Override
    public String toString() {
        return numeroSerie +  " (numero de serie) " + anoFabricacao + " (ano de fabricacao) ";
    }
    
    
}
