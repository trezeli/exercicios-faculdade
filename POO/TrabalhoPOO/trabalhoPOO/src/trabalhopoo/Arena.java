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
    public static Guerreiro ultimoAtacante = null;
    public static Guerreiro ultimoDerrotado = null;

    public Arena(LinkedList<Guerreiro>[] lado1, LinkedList<Guerreiro>[] lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    
    public static Guerreiro obterAlvo(LinkedList<Guerreiro>[] ladoInimigo, int fila){
        // a provocacao só redireciona se o Clone Pesado estiver dentro do ladoInimigo que está sendo atacado!
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
                System.out.println(" "+ g.getClass().getSimpleName() + ": " + g.getNome() + ", " + g.getIdade() + " anos, "+ g.getPeso() + " kilos");
            }
        }
        
        System.out.println("a)\nLADO 2:");
        for (int i = 0; i < 4; i++){
            System.out.println("Fila " + (i + 1) + ":");
            for (Guerreiro g : lado2[i]){
                System.out.println(" "+ g.getClass().getSimpleName() + ": " + g.getNome() + ", " + g.getIdade() + " anos, "+ g.getPeso() + " kilos");
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
            System.out.println("O " + maisVelho.getClass().getSimpleName() + " " + maisVelho.getNome() + " é o mais velho e tem " + maisVelho.getIdade() + " anos\n");
        }
    }
    
    public void iniciarSimulacao(){
        exibirRelatorioInicial();
        
        int rodada = 1;
        while (temGuerreirosVivos(lado1) && temGuerreirosVivos(lado2)){
            System.out.println("--- RODADA " + rodada + " ---");
            provocaLado1 = null; //reseta a provocacao no inicio do turno
            
            // executa o combate entre filas
            for (int i = 0; i < 4; i++){
                // lado1 ataca lado 2
                if (!lado1[i].isEmpty() && temGuerreirosVivos(lado2)){
                    Guerreiro atacante = lado1[i].getFirst();
                    Guerreiro alvo = obterAlvo(lado2, i);
                    
                    if (alvo != null){
                        atacante.atacar(lado2, lado1, i);
                        if (!alvo.isVivo()){
                            ultimoAtacante = atacante;
                            ultimoDerrotado = alvo;
                        }
                    }
                }
                
                // lado2 ataca lado 1
                if (!lado2[i].isEmpty() && temGuerreirosVivos(lado1)){
                    Guerreiro atacante = lado2[i].getFirst();
                    Guerreiro alvo = obterAlvo(lado1, i);
                    
                    if (alvo != null){
                        atacante.atacar(lado1, lado2, i);
                        if (!alvo.isVivo()){
                            ultimoAtacante = atacante;
                            ultimoDerrotado = alvo;
                        }
                    }
                }
            }
            
            limparMortos(lado1);
            limparMortos(lado2);
            
            rodada++;
        }
        
        exibirRelatorioFinal();
    }
    
    private void limparMortos(LinkedList<Guerreiro>[] lado){
        for (int i = 0; i < 4; i++){
            lado[i].removeIf(g -> !g.isVivo());
        }
    }
   
    public void exibirRelatorioFinal() {
        boolean lado1Venceu = temGuerreirosVivos(lado1);

        System.out.println("\nd)");
        System.out.println(lado1Venceu ? "Jedi e Clones venceram." : "Sith e Droides venceram.");

        System.out.println("\ne)");
        if (ultimoDerrotado != null) {
            String ladoPerdedor = lado1Venceu ? "Sith e Droides" : "Jedi e Clones";
            System.out.println("O " + ultimoDerrotado.getClass().getSimpleName() + " " + ultimoDerrotado.getNome() + 
                               ", de " + ultimoDerrotado.getIdade() + " anos e " + ultimoDerrotado.getPeso() + 
                               " kilos, foi o ultimo a ser derrotado no lado dos " + ladoPerdedor);
        }

        System.out.println("\nf)");
        if (ultimoAtacante != null && ultimoDerrotado != null) {
            System.out.println("O " + ultimoAtacante.getClass().getSimpleName() + " " + ultimoAtacante.getNome() + 
                               ", de " + ultimoAtacante.getIdade() + " anos e " + ultimoAtacante.getPeso() + 
                               " kilos, desferiu o ultimo ataque no " + ultimoDerrotado.getClass().getSimpleName() + 
                               " " + ultimoDerrotado.getNome() + ", de " + ultimoDerrotado.getIdade() + 
                               " anos e " + ultimoDerrotado.getPeso() + " kilos.");
        }
    }
}