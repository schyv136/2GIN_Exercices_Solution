
/**
 * Création d'une instance de UniversalTime dans une méthode run
 *
 * @author     fred
 * @version 06/09/2011 18:47:30
 */
public class UniversalTimeController {

    public void run() {
        UniversalTime uTime = new UniversalTime(12, 20);
        System.out.println(uTime);
    }
}
