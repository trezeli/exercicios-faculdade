package prova20152;

public class UsaClasses {

    public static void main(String[] args) {
        // Todo alimento quando é criado
        // possui peso e validade
        Legume l1 = new Inhame(10.5, "04/04/2013");
        Legume l2 = new Batata(10.6, "22/03/2013");
        // Seta l2 em l1, ou seja, l1 sabe que l2 é a combinação com ele e portando
        // guarda essa informação
        l1.combinar(l2);
        // Deve imprimir:
        // Os alimentos da combinação são: Inhame e Batata
        System.out.println("Os alimentos da combinação são: " + l1.getCombinacao());
        System.out.println("Peso de l2: " + l2.getPeso() + " \nValidade de l2: " + l2.getValidade());
        
        Alimento f1 = new Morango(2.3, "04/05/2013");
        Fruta f2 = new Uva(2.7, "04/05/2013");
        // Deverá ser impresso:
        // Inhame possui Ferro, Proteína e Fibras
        System.out.println(l1.getNome() + " possui " + l1.getNutrientes());
        // Batata possui Cálcio, Ferro, Potássio, Fosforo e Carboidratos
        System.out.println(l2.getNome() + " possui " + l2.getNutrientes());
        // Morango possui Potássio e Vitamina A
        System.out.println(f1.getNome() + " possui " + f1.getNutrientes());
        // Uva possui Cobre e Vitamina K
        System.out.println(f2.getNome() + " possui " + f2.getNutrientes());
        
        // Deve ser impresso valor 4 pois foram criados 4 alimentos
        System.out.println("A quantidade de Alimentos criados é: " + Alimento.getQuantidade());
    }
}
