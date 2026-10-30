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
    
    public static Guerreiro provocaLado1 = null;

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
    
    public static boolean temGuerreirosVivos(LinkedList<Guerreiro>[] lado){
        for (int i = 0; i < 4; i++){
            if (!lado[i].isEmpty()){
                return true;
            }
        }
        return false;
    }
    
    public static Guerreiro obterAlvo(LinkedList<Guerreiro>[] ladoInimigo, int fila){
        // 1. O Taunt só redireciona se o Clone Pesado estiver dentro do ladoInimigo que está sendo atacado!
        if (provocaLado1 != null && provocaLado1.isVivo()){
            for (int i = 0; i < 4; i++){
                if (ladoInimigo[i].contains(provocaLado1)){
                    return provocaLado1;
                }
            }  
        }
        
        // se nao houver provocacao pega o primeiro guerreiro da fila normal
        if (!ladoInimigo[fila].isEmpty()){
            return ladoInimigo[fila].getFirst();
        }
        
        // fallback: Se a fila oposta estiver vazia, busca na primeira fila inimiga que tiver gente
        for (int i = 0; i < 4; i++){
            if(!ladoInimigo[i].isEmpty()){
                return ladoInimigo[i].getFirst();
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        LinkedList<Guerreiro>[] lado1 = new LinkedList[4];
        LinkedList<Guerreiro>[] lado2 = new LinkedList[4];
       
        for (int i = 0; i < 4; i++){
            lado1[i] = new LinkedList<>();
            lado2[i] = new LinkedList<>();
        }
        
        // Preenche as 4 filas de cada lado dinamicamente
        for (int i = 0; i < 4; i++) {
            preencherFila("fila1" + (i + 1) + ".txt", lado1[i], 1);
            preencherFila("fila2" + (i + 1) + ".txt", lado2[i], 2);
        }
        
        int numeroDaRodada = 1;

        // O Jogo roda enquanto os DOIS lados tiverem sobreviventes
        while (temGuerreirosVivos(lado1) && temGuerreirosVivos(lado2)) {

            System.out.println("\n--- RODADA " + numeroDaRodada + " ---");
            
            provocaLado1 = null;

            // Varrer as 4 filas (índices 0, 1, 2 e 3)
            for (int i = 0; i < 4; i++) {

                // --- VEZ DO LADO 1 ---
                if (!lado1[i].isEmpty()) {
                    Guerreiro lutador1 = lado1[i].getFirst();

                    // Checa veneno antes do ataque
                    if (lutador1.isEnvenenado()) {
                        lutador1.setEnergia(lutador1.getEnergia() - 5);
                        System.out.println("   [VENENO] " + lutador1.getNome() + " perdeu 5 de energia por estar envenenado!");
                    }

                    // Só ataca se não tiver morrido por dano em área ou pelo veneno!
                    if (lutador1.isVivo()) {
                        lutador1.atacar(lado2, lado1, i);
                    }

                    // Tira da frente. Se estiver vivo vai pro final, se não, é eliminado
                    lado1[i].removeFirst();
                    if (lutador1.isVivo()) {
                        lado1[i].addLast(lutador1);
                    } else {
                        System.out.println(lutador1.getNome() + " (Lado 1, Fila " + (i + 1) + ") foi eliminado!");
                        lutador1.aoSerEliminado(lado1, i);
                    }
                }

                // --- VEZ DO LADO 2 ---
                if (!lado2[i].isEmpty()) {
                    Guerreiro lutador2 = lado2[i].getFirst();

                    // Checa veneno antes do ataque
                    if (lutador2.isEnvenenado()) {
                        lutador2.setEnergia(lutador2.getEnergia() - 5);
                        System.out.println("   [VENENO] " + lutador2.getNome() + " perdeu 5 de energia por estar envenenado!");
                    }

                    if (lutador2.isVivo()) {
                        lutador2.atacar(lado1, lado2, i);
                    }

                    lado2[i].removeFirst();
                    if (lutador2.isVivo()) {
                        lado2[i].addLast(lutador2);
                    } else {
                        System.out.println(lutador2.getNome() + " (Lado 2, Fila " + (i + 1) + ") foi eliminado!");
                        lutador2.aoSerEliminado(lado2, i);
                    }
                }
            }
            numeroDaRodada++;
        }
        System.out.println("--- FIM DA RODADA ---\n");
        if (temGuerreirosVivos(lado1)){
            System.out.println("A Republica (Jedi e Clones) Venceu!");
        } else {
            System.out.println("Os Separatistas (Sith e Droids) Venceu!");
        }

    }
   
}