/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class TrabalhoPOO {
    
    public static void preencherFila(String nomeArquivo, LinkedList<Guerreiro> filaDestino, int lado){
        try {
            File arquivo = new File(nomeArquivo);
            Scanner leitor = new Scanner(arquivo);
            
            while (leitor.hasNext()){
                int tipo = leitor.nextInt();
                String nome = leitor.next();
                int idade = leitor.nextInt();
                int peso = leitor.nextInt();
                
                if (lado == 1) {
                    // --- LADO 1: REPÚBLICA (JEDI E CLONES) ---
                    if (tipo == 1) {
                        filaDestino.add(new JediMestre(nome, idade, peso));
                    } else if (tipo == 2) {
                        filaDestino.add(new JediConsular(nome, idade, peso));
                    } else if (tipo == 3) {
                        filaDestino.add(new JediGeneral(nome, idade, peso));
                    } else if (tipo == 4) {
                        filaDestino.add(new CloneMedico(nome, idade, peso));
                    } else if (tipo == 5) {
                        filaDestino.add(new CloneComando(nome, idade, peso));
                    } else if (tipo == 6) {
                        filaDestino.add(new ClonePesado(nome, idade, peso));
                    }
                } else if (lado == 2) {
                    // --- LADO 2: SEPARATISTAS (DROIDES E SITH) ---
                    if (tipo == 1) {
                        filaDestino.add(new DroideBatalha(nome, idade, peso));
                    } else if (tipo == 2) {
                        filaDestino.add(new DroideAranha(nome, idade, peso));
                    } else if (tipo == 3) {
                        filaDestino.add(new DroideExterminador(nome, idade, peso));
                    } else if (tipo == 4) {
                        filaDestino.add(new AcolitoSith(nome, idade, peso));
                    } else if (tipo == 5) {
                        filaDestino.add(new AssassinoSith(nome, idade, peso));
                    } else if (tipo == 6) {
                        filaDestino.add(new LordeSith(nome, idade, peso));
                    }
                }
                
            }
            leitor.close();
        } catch(FileNotFoundException e){
            System.out.println("erro ao ler o arquivo: " + e.getMessage());
        }
    }
    
    public static void main(String[] args){
        LinkedList<Guerreiro>[] lado1 = new LinkedList[4];
        LinkedList<Guerreiro>[] lado2 = new LinkedList[4];
        
        for (int i = 0; i < 4; i++){
            lado1[i] = new LinkedList<>();
            lado2[i] = new LinkedList<>();
        }
        
        for (int i = 0; i < 4; i++){
            preencherFila("fila1" + (i + 1) + ".txt", lado1[i], 1);
            preencherFila("fila2" + (i + 1) + ".txt", lado2[i], 2);
        }
        
        Arena arena = new Arena(lado1, lado2);
        arena.iniciarSimulacao();
    }
}
