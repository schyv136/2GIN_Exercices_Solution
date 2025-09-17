
public class Test {

    /**
     * Test de démonstration du travail avec des objets et des variables du type objet
     *
     */
    public static void main(String[] args) {
        Fraction f1;

        f1 = new Fraction(0.75);

        System.out.println("1: f1=" + f1.toString());

        Fraction f2 = new Fraction(4, 12);

        System.out.println("2: f2=" + f2.toString());

        f1 = f2;

        System.out.println("3: f1=" + f1.toString() + ",\t f2=" + f2.toString());

        f1.reduce();

        System.out.println("4: f1=" + f1.toString() + ",\t f2=" + f2.toString());

        f2 = null;

        System.out.println("5: f2=" + f2.toString());

    }

}
