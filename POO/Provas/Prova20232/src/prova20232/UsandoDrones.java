/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prova20232;

public class UsandoDrones {

    public static void main(String[] args) {
        // Par�metros (nessa ordem): autonomia de voo, numero de s�rie, ano de fabrica��o
        DroneVoador v1 = new DroneVoador(13, 20001, 2023);
        // Par�metros (nessa ordem): numero de s�rie, ano de fabrica��o
        Drone v2 = new Tello(20001, 2023);
        // Dois Drones s�o equivalentes se seu n�mero de s�rie � equivalente
        // Isso ocorre independente do tipo do Drone
        if(v1.equals(v2)){
            System.out.println("S�o iguais: \n v1 = " + v1 +
                    " \n v2 = " + v2);
            System.out.println("Valor de v1 = " + v1.getValor());
            System.out.println("Valor de v2 = " + v1.getValor());
            System.out.println("Autonomia de voo de v1 = " + v1.getAutonomiaVoo());
            System.out.println("Autonomia de voo de v2 = " + ((Tello)v2).getAutonomiaVoo());
        } 
        
        // Par�metros (nessa ordem): resolu��o visual, numero de s�rie, ano de fabrica��o
        Mavic m1 = new ProFly(500.3, 20008, 2022);
        // Par�metros (nessa ordem): resolu��o visual, numero de s�rie, ano de fabrica��o
        Mavic m2 = new ClassicDJI(300.7, 20033, 2022);
        if (!m1.equals(m2)){
            System.out.println("Valor de m1 = " + m1.getValor());
            System.out.println("Valor de m2 = " + m2.getValor());
        }
        
        System.out.println("Resolu��o Visual de m1 = " + m1.getResolucaoVisual());
        System.out.println("Resolu��o Visual de m2 = " + m2.getResolucaoVisual());
        m1.setResolucaoVisual(700.23);
        m2.setResolucaoVisual(800.67);
        System.out.println("Resolu��o Visual de m1 = " + m1.getResolucaoVisual());
        System.out.println("Resolu��o Visual de m2 = " + m2.getResolucaoVisual());
        
        System.out.println("Valor de m1 = " + m1.getValor());
        System.out.println("Valor de m2 = " + m2.getValor());
        
        System.out.println("Autonomia de voo de m1 = " + m1.getAutonomiaVoo());
        System.out.println("Autonomia de voo de m2 = " + m2.getAutonomiaVoo());
    }
}
