/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova20232;

/**
 *
 * @author queir
 */
public class Mavic extends DroneVoador {
    private double resolucaoVisual;
    
    public Mavic(double resolucaoVisual, int numeroSerie, int anoFabricacao, int autonomiaVoo) {
        super(autonomiaVoo, numeroSerie, anoFabricacao);
        this.resolucaoVisual = resolucaoVisual;        
    }

    public double getResolucaoVisual() {
        return resolucaoVisual;
    }

    public void setResolucaoVisual(double resolucaoVisual) {
        this.resolucaoVisual = resolucaoVisual;
    }

    @Override
    public double getValor() {
        return super.getValor() + resolucaoVisual / 10;
    }
    
}
