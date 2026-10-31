package prova20161;

public class UsaClasses {

    public static void main(String[] args) {
        // Zergs tem Colônia (nesse caso "Astargue")
        Raca zerg = new Barata("Astargue");
        // Humanos tem nome e unidade
        Raca humano = new Tanque("Omar", "Los pesados");
        // Protons tem número de série
        Raca proton = new Fanaticus(5);
        // zerg vai retirar 20 de energia de humano pois a distânca é MEDIO
        zerg.atacar(humano, Raca.MEDIO);
        // proton vai retirar 40 de energia de zerg pois a distância é PERTO
        proton.atacar(zerg, Raca.PERTO);
        // Humano vai retirar 30 de energia de proton
        humano.atacar(proton, Raca.LONGE);
        // A barata se entocou 4x para recuperar a energia
        Barata barata = (Barata) zerg;
        barata.entocar();
        barata.entocar();
        barata.entocar();
        barata.entocar();
        if (zerg.getEnergia() > humano.getEnergia()) {
            System.out.println("Barata menos ferida que tanque");
        } else {
            System.out.println("Tanque menos ferido que Barata");
        }
        System.out.println("A quantidade de tanques criados é: " + Tanque.getQt());
    }
}
