
/**
 * @author     kugge et fabfr
 * @version 15/08/2019 09:46:07
 */
public class Test {

    /**
     * The main entry point for executing this program.
     */
    public static void main(String[] args) {
        Fraction frac1;
        frac1 = new Fraction(1, 4);
        System.out.println("frac1 = " + frac1);
	Unimozer.monitor(frac1,"frac1");

        Fraction frac2 = new Fraction(3, 8);
        System.out.println("frac2 = " + frac2);
	Unimozer.monitor(frac2,"frac2");

        frac1.add(frac2);
        System.out.println("frac1 = " + frac1 + " après addition");

        //Pour avancés: Tests du constructeur avec un réel
        Fraction frac3 = new Fraction(75.32);
        System.out.println("frac3 = " + frac3);
        Unimozer.monitor(frac3,"frac3");

        for (int i = 0; i < 1000; i++) {
            double d = Math.random() * 100 - 50;
            System.out.print(d);
            Fraction fraction = new Fraction(d);
            System.out.println(" \t -> " + fraction
                    + " \t -> " + fraction.getDecimal()
                    + " \t diff: " + (d - fraction.getDecimal()));
        }

    }
}
