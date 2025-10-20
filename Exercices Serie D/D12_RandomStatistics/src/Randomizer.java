
/**
 * <b>Écrivez la classe « Randomizer » qui implémente les méthodes suivantes :</b>
 * <ul>
 *      <li>Randomizer(long pMin, long pMax)</li>
 *      <li>long getNext()</li>
 * </ul>
 */
public class Randomizer {

    /**
     * borne inférieure de l'espace des nombres aléatoires
     */
    private long min;
    /**
     * borne supérieure de l'espace des nombres aléatoires
     */
    private long max;

    /**
     * Constructeur pour des objets de la classe Randomizer
     *
     * @param pMin,pMax nouvelles bornes de l'espace des nombres aléatoires
     */
    public Randomizer(long pMin, long pMax) {
        if (pMin <= pMax) {
            min = pMin;
            max = pMax;
        } else {
            min = pMax;
            max = pMin;
        }
    }

    /**
     * Retourne le prochain nombre aléatoire entre min et max (bornes incluses)
     *
     * @return le prochain nombre aléatoire
     */
    public long getNext() {
        return (long) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * Affiche une série de n nombres aléatoires entre les bornes actuelles -->
     * sert seulement à tester la classe en Unimozer -- --- mis en entre
     * commentaires, car cette méthode semble irriter les élèves --- dans le
     * diagramme UML
     *
     * @param n le nombre de valeurs aléatoires à produire
     */
//    public void afficher(long n) {
//        for (long i = 1; i <= n; i++) {
//            System.out.print(getNext() + "  ");
//            if (i % 20 == 0) {
//                System.out.println();
//            }
//        }
//    }
}
