/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prova20242_2;

/**
 *
 * @author queir
 */
public class ProvaLutador {

    public static void main(String[] args) {
        Lutador lutador1 = new Karateca("Azul", "Pedro", 80.3, 35);
        Lutador lutador2 = new LutadorDeRua(70.4, 23);
        lutador1.atacar(lutador2);
        lutador2.atacar(lutador1);
        System.out.println(lutador1);
        System.out.println(lutador2);
        System.out.println(lutador1.getNome() + " tem "
                + lutador1.getEnergia() + " de energia");
        System.out.println(lutador2.getNome() + " tem "
                + lutador2.getEnergia() + " de energia");
        JiuJiteiro jiujitero1 = new JiuJiteiro("N�mero 1", "Tonh�o", 102.3, 25);
        JiuJiteiro jiujitero2 = new JiuJiteiro("Corpus", "Aznos", 80.2, 22);
        JiuJiteiro jiujitero3 = new JiuJiteiroGracie("Gracie Mania", "Leto", 140.0, 28);
        JiuJiteiro jiujitero4 = new JiuJiteiroGracie("Thunder", "Fink", 107.9, 40);
        System.out.println("Foram criados " + JiuJiteiro.getQt() + " jiujiteros");
        System.out.println(jiujitero1);
        System.out.println(jiujitero2);
        System.out.println(jiujitero3);
        System.out.println(jiujitero4);

        lutador1.atacar(jiujitero1);
        lutador2.atacar(jiujitero1);
        System.out.printf(jiujitero1.getNome() + " tem "
                + " %.2f de energia\n", jiujitero1.getEnergia());

        System.out.printf(jiujitero2.getNome() + " tem "
                + " %.2f de energia\n", jiujitero2.getEnergia());
        System.out.printf(jiujitero3.getNome() + " tem "
                + " %.2f de energia\n", jiujitero3.getEnergia());

        jiujitero2.atacar(jiujitero4);
        System.out.printf(jiujitero4.getNome() + " tem "
                + " %.2f de energia\n", jiujitero4.getEnergia());
        jiujitero3.atacar(jiujitero4);
        System.out.printf(jiujitero4.getNome() + " tem "
                + " %.2f de energia\n", jiujitero4.getEnergia());

    }
}
