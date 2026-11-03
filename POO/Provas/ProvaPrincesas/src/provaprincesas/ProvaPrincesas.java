package provaprincesas;

public class ProvaPrincesas {

    public static void main(String[] args) {
        Princesa p1 = new Mulan(20);
        Princesa p2 = new Elsa(25);
        Princesa p3 = new Guerreira("Merida", "Escócia", 18, "Arco");
        Princesa p4 = new Encantada("Cinderela", "Reino Distante", 19, 30);
        System.out.println(p3);
        p3.atacar(p1);
        p1.atacar(p3);
        p2.atacar(p1);
        p1.atacar(p2);
        p1.atacar(p3);
        p1.atacar(p3); // Merida é derrotada
        p1.atacar(p4);
        p4.atacar(p2);
        Princesa[] todas = {p1, p2, p3, p4};
        for (Princesa p : todas) {
            System.out.println(p.getNome() + " tem " + p.getEnergia()
                    + " de energia");
        }
        System.out.println("Foram criadas " + Princesa.getQt() + " princesas");
        Princesa p5 = new Guerreira("Merida", "Brave", 30, "Espada");
        if (p5.equals(p3)) {
            System.out.println(p5.getNome() + " é a mesma princesa");
        }
    }
}
