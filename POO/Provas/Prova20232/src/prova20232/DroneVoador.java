/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20232;

/**
 *
 * @author queir
 */
public class DroneVoador extends Drone {
    private final int autonomiaVoo;
    
    public DroneVoador(int autonomiaVoo, int numeroSerie, int anoFabricacao) {
        super(numeroSerie, anoFabricacao);
        this.autonomiaVoo = autonomiaVoo;

    }

    public int getAutonomiaVoo() {
        return autonomiaVoo;
    }

    @Override
    public double getValor() {
        return (autonomiaVoo * numeroSerie / anoFabricacao);
    }
    
}
