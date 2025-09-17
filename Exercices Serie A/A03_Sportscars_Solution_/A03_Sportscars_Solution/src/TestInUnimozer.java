
/**
 * Test des classes Person et Sportscar
 *
 * @author     georges
 * @version 16/08/2019 19:18:20
 */
public class TestInUnimozer {

    /**
     * The main entry point for executing this program.
     */
    public static void main(String[] args) {
        Person georges = new Person("Georges", 25);
        Person aly = new Person("Aly", 43);
        Person angelina = new Person("Angelina", 23);

        SportsCar bugatti = new SportsCar("Bugatti", "Divo");
        SportsCar lamborghini = new SportsCar("Lamborghini", "Aventador");
        SportsCar tesla = new SportsCar("Tesla", "Vento");

        bugatti.setDriver(georges);
        bugatti.setPassenger(angelina);

        lamborghini.setDriver(aly);

        System.out.println(bugatti);
        System.out.println(lamborghini);
        System.out.println(tesla);
        
//        Unimozer.monitor(georges, "georges");
//        Unimozer.monitor(aly, "aly");
//        Unimozer.monitor(angelina, "angelina");
//        Unimozer.monitor(bugatti, "bugatti");
//        Unimozer.monitor(lamborghini, "lamborghini");
//        Unimozer.monitor(tesla, "tesla");
    }
}
