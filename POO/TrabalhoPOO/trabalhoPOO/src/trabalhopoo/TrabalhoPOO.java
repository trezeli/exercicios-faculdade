/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TrabalhoPOO {

    public static void preencherFila(String nomeArquivo, LinkedList<Guerreiro> filaDestino){
        try {
            File arquivo = new File(nomeArquivo);
            Scanner leitor = new Scanner(arquivo);
            
            while (leitor.hasNext()){
                int tipo = leitor.nextInt();
                String nome = leitor.next();
                int idade = leitor.nextInt();
                int peso = leitor.nextInt();
                
                if(tipo == 1){
                    JediMestre novoJedi = new JediMestre(nome, idade, peso);
                    filaDestino.add(novoJedi);
                } else if (tipo == 5){
                    DroideBatalha novoDroide = new DroideBatalha(nome, idade, peso);
                    filaDestino.add(novoDroide);
                }
            }
            leitor.close();
        } catch(FileNotFoundException e){
            System.out.println("erro ao ler o arquivo: " + e.getMessage());
        }
    }
    
    public static boolean temGuerreirosVivos(LinkedList<Guerreiro>[] lado){
        for (int i = 0; i < 4; i++){
            if (!lado[i].isEmpty()){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        LinkedList<Guerreiro>[] lado1 = new LinkedList[4];
        LinkedList<Guerreiro>[] lado2 = new LinkedList[4];
       
        for (int i = 0; i < 4; i++){
            lado1[i] = new LinkedList<>();
            lado2[i] = new LinkedList<>();
        }
        
        preencherFila("fila11.txt", lado1[0]);
        preencherFila("fila21.txt", lado2[0]);
        
        int numRodada = 1;
        
        System.out.println("\n--- INICIO DA RODADA ---");
        
        while (temGuerreirosVivos(lado1) && temGuerreirosVivos(lado2)){
            System.out.println("\n--- RODADA " + numRodada + " ---");
            
            for (int i = 0; i < 4; i++) {
                if (!lado1[i].isEmpty() && !lado2[i].isEmpty()) {

                    Guerreiro lutador1 = lado1[0].removeFirst();
                    Guerreiro lutador2 = lado2[0].removeFirst();

                    System.out.println("Combate na fila " + (i + 1) + ": " + lutador1.getNome() + " vs " + lutador2.getNome());

                    lutador1.atacar(lutador2);
                    lutador2.atacar(lutador1);

                    if (lutador1.isVivo()) {
                        lado1[0].addLast(lutador1);
                    } else {
                        System.out.println(lutador1.getNome() + " foi eliminado!");
                    }

                    if (lutador2.isVivo()) {
                        lado2[0].addLast(lutador2);
                    } else {
                        System.out.println(lutador2.getNome() + " foi eliminado!");
                    }
                }
            }
            numRodada++;
        }
        System.out.println("--- FIM DA RODADA ---\n");
        if (temGuerreirosVivos(lado1)){
            System.out.println("A Republica (Jedi e Clones) Venceu!");
        } else {
            System.out.println("Os Separatistas (Sith e Droids) Venceu!");
        }

    }
   
}