/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prova20192;

public class Prova20192 {

    public static void main(String[] args) {

        // Toda cruzada possui a quantidade soldados (nesse caso 3000),
        // mas a Popular também controla
        // a quantidade de mulheres, velhos e crianças (nessa ordem)
        Cruzada mendigos = new Popular(3000, 1500, 500, 2000);

        // A força de uma cruzada popular é dada por:
        // Força de uma Cruzada (classe Cruzada) + número de mulheres * 3 +
        // número de velhos * 2 + número de crianças * 1
        System.out.println("A força dessa cruzada é: " + mendigos.getForca()
                + " e seu lema é " + mendigos.lema());

        // A cruzada nobre além da quantidade total de soldados,
        // controla a quantidade de nobres nesse exercíto (nesse caso
        // existem 8000 - 3000 = 5000 soldados não nobres)
        Cruzada nobre = new Nobre(8000, 3000);

        // A força de uma Cruzada Nobre é dada por:
        // número de soldados não nobres * 10 + número de soldados
        // nobres * 20
        System.out.println("A força dessa cruzada é: " + nobre.getForca()
                + " e seu lema é " + nobre.lema());

        // A Segunda Cruzada possui apenas a quantidade de soldados
        Cruzada segunda = new Segunda(5000);

        // A força de Segunda é a mesma de uma Cruzada (classe Cruzada):
        // número de soldados * 10
        System.out.println("A força dessa cruzada é: " + segunda.getForca()
                + " e seu lema é " + segunda.lema());

        System.out.println("A quantidade de cruzadas criadas foi "
                + Cruzada.getQt_Cruzada());
    }
}
