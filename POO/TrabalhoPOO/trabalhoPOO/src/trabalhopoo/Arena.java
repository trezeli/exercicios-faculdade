/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

public class Arena {
    
    private LinkedList<Guerreiro>[] lado1;
    private LinkedList<Guerreiro>[] lado2;
    
    public static Guerreiro provocaLado1 = null;
    public static boolean primeiroAtaque = false;
    public static Guerreiro ultimoAtacante = null;
    public static Guerreiro ultimoDerrotado = null;
    public static boolean DEBUG = false;
    private java.util.Random sorteio = new java.util.Random();

    public Arena(LinkedList<Guerreiro>[] lado1, LinkedList<Guerreiro>[] lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    
    public static int filaDe(LinkedList<Guerreiro>[] lado, Guerreiro g){
        for (int i = 0; i < 4; i++){
            if (lado[i].contains(g)) return i;
        }
        return -1;
    }
    
    public static int obterFilaAlvo(LinkedList<Guerreiro>[] ladoInimigo, int fila) {
        if (provocaLado1 != null && provocaLado1.isVivo()) {
            int f = filaDe(ladoInimigo, provocaLado1);
            if (f != -1) {
                return f;
            }
        }
        for (int k = 0; k < 4; k++) {
            int f = (fila + k) % 4;          // fila, fila+1, fila+2... circular
            if (!ladoInimigo[f].isEmpty()) {
                return f;
            }
        }
        return -1;
    }

    public static Guerreiro obterAlvo(LinkedList<Guerreiro>[] ladoInimigo, int fila) {
        int f = obterFilaAlvo(ladoInimigo, fila);
        if (f == -1) {
            return null;
        }
        if (provocaLado1 != null && ladoInimigo[f].contains(provocaLado1)) {
            return provocaLado1;
        }
        return ladoInimigo[f].getFirst();
    }
    
    public static boolean temGuerreirosVivos(LinkedList<Guerreiro>[] lado){
        for (int i = 0; i < 4; i++){
            if (!lado[i].isEmpty()){
                return true;
            }
        }
        return false;
    }
    
    public void exibirRelatorioInicial(){
        // dados de ambos lados
        System.out.println("a)\nLADO 1:");
        for (int i = 0; i < 4; i++){
            System.out.println("Fila " + (i + 1) + ":");
            for (Guerreiro g : lado1[i]){
                System.out.println(" "+ g.getTipo() + ": " + g.getNome() + ", " + g.getIdade() + " anos, "+ g.getPeso() + " kilos");
            }
        }
        
        System.out.println("\nLADO 2:");
        for (int i = 0; i < 4; i++){
            System.out.println("Fila " + (i + 1) + ":");
            for (Guerreiro g : lado2[i]){
                System.out.println(" "+ g.getTipo() + ": " + g.getNome() + ", " + g.getIdade() + " anos, "+ g.getPeso() + " kilos");
            }
        }
        
        // soma dos pesos
        int pesoLado1 = 0, pesoLado2 = 0;
        for (int i = 0; i < 4; i++) {
            for (Guerreiro g : lado1[i]) pesoLado1 += g.getPeso();
            for (Guerreiro g : lado2[i]) pesoLado2 += g.getPeso();
        }
        
        System.out.println("\nb)\nJedi e Clones pesam " + pesoLado1 + " kilos");
        System.out.println("Sith e Droides pesam " + pesoLado2 + " kilos");
        
        // guerreiro mais velho
        Guerreiro maisVelho = null;
        for (int i = 0; i < 4; i++){
            for (Guerreiro g : lado1[i]){
                if (maisVelho == null || g.getIdade() > maisVelho.getIdade()) {
                    maisVelho = g;
                }
            }
            for (Guerreiro g : lado2[i]){
                if (maisVelho == null || g.getIdade() > maisVelho.getIdade()) {
                    maisVelho = g;
                }
            }
        }
        System.out.println("\nc)");
        if (maisVelho != null){
            System.out.println("O " + maisVelho.getTipo() + " " + maisVelho.getNome() + " é o mais velho e tem " + maisVelho.getIdade() + " anos\n");
        }
    }
    
    public void iniciarSimulacao() {
        exibirRelatorioInicial();
        int rodada = 1;
        while (temGuerreirosVivos(lado1) && temGuerreirosVivos(lado2)) {
            System.out.println("--- RODADA " + rodada + " ---");
            provocaLado1 = null;
            primeiroAtaque = true;

            Guerreiro[] atq1 = primeiros(lado1);
            Guerreiro[] atq2 = primeiros(lado2);

            if (sorteio.nextBoolean()) {                 // sorteio de quem começa
                faseDeAtaque(atq1, lado1, lado2);
                faseDeAtaque(atq2, lado2, lado1);
            } else {
                faseDeAtaque(atq2, lado2, lado1);
                faseDeAtaque(atq1, lado1, lado2);
            }

            rodizio(atq1, lado1);
            rodizio(atq2, lado2);
            rodada++;
        }
        exibirRelatorioFinal();
    }

    private Guerreiro[] primeiros(LinkedList<Guerreiro>[] lado) {
        Guerreiro[] r = new Guerreiro[4];
        for (int i = 0; i < 4; i++) {
            r[i] = lado[i].isEmpty() ? null : lado[i].getFirst();
        }
        return r;
    }

    private void faseDeAtaque(Guerreiro[] atacantes, LinkedList<Guerreiro>[] meu, LinkedList<Guerreiro>[] inimigo) {
        for (int i = 0; i < 4; i++) {
            Guerreiro a = atacantes[i];
            if (a == null || !a.isVivo() || !temGuerreirosVivos(inimigo)) {
                continue;
            }

            if (a.isImpedido()) {            // foi empurrado pelo Mestre
                a.setImpedido(false);
                continue;
            }

            a.aplicarVeneno();               // veneno do Assassino
            if (!a.isVivo()) {
                removerMortos(meu, null);
                continue;
            }

            a.atacar(inimigo, meu, i);
            primeiroAtaque = false;

            removerMortos(inimigo, a);       // remove na hora e dispara aoSerEliminado
            removerMortos(meu, null);
        }
    }

    private void removerMortos(LinkedList<Guerreiro>[] lado, Guerreiro atacante) {
        for (int i = 0; i < 4; i++) {
            LinkedList<Guerreiro> mortos = new LinkedList<>();
            for (Guerreiro g : lado[i]) {
                if (!g.isVivo()) {
                    mortos.add(g);
                }
            }
            for (Guerreiro g : mortos) {
                lado[i].remove(g);
                if (atacante != null) {
                    ultimoAtacante = atacante;
                }
                ultimoDerrotado = g;
                g.aoSerEliminado(lado, i);   // divisão do droide, acólitos do Lorde
            }
        }
    }

    private void rodizio(Guerreiro[] atacantes, LinkedList<Guerreiro>[] lado) {
        for (int i = 0; i < 4; i++) {
            Guerreiro a = atacantes[i];
            if (a == null) {
                continue;
            }
            a.setImpedido(false);
            if (a.isVivo() && lado[i].size() > 1 && lado[i].remove(a)) {
                lado[i].addLast(a);          // primeiro vai para o final
            }
        }
    }
   
    public void exibirRelatorioFinal() {
        boolean lado1Venceu = temGuerreirosVivos(lado1);

        System.out.println("\nd)");
        System.out.println(lado1Venceu ? "Jedi e Clones venceram." : "Sith e Droides venceram.");

        System.out.println("\ne)");
        if (ultimoDerrotado != null) {
            String ladoPerdedor = lado1Venceu ? "Sith e Droides" : "Jedi e Clones";
            System.out.println("O " + ultimoDerrotado.getTipo() + " " + ultimoDerrotado.getNome() + 
                               ", de " + ultimoDerrotado.getIdade() + " anos e " + ultimoDerrotado.getPeso() + 
                               " kilos, foi o ultimo a ser derrotado no lado dos " + ladoPerdedor);
        }

        System.out.println("\nf)");
        if (ultimoAtacante != null && ultimoDerrotado != null) {
            System.out.println("O " + ultimoAtacante.getTipo() + " " + ultimoAtacante.getNome() + 
                               ", de " + ultimoAtacante.getIdade() + " anos e " + ultimoAtacante.getPeso() + 
                               " kilos, desferiu o ultimo ataque no " + ultimoDerrotado.getTipo() + 
                               " " + ultimoDerrotado.getNome() + ", de " + ultimoDerrotado.getIdade() + 
                               " anos e " + ultimoDerrotado.getPeso() + " kilos.");
        }
    }
    
    public static void log(String msg) {
        if (DEBUG) {
            System.out.println(msg);
        }
    }
}