
import java.util.ArrayList;

/**
 * Représente une liste de nombres aléatoires
 *
 * @author robertfisch
 * @version 01/02/2011 09:02:36
 */
public class RandomNumbers {

    private ArrayList<Long> alNumbers = new ArrayList<>();

    public void addSeries(int count, long min, long max) {
        Randomizer ran = new Randomizer(min, max);
        for (int i = 0; i < count; i++) {
            alNumbers.add(ran.getNext());
        }
    }

    public void clear() {
        alNumbers.clear();
    }

    public double getAverage() {
        long sum = 0;
        for (int i = 0; i < alNumbers.size(); i++) {
            sum = sum + alNumbers.get(i);
        }
        return (double) sum / alNumbers.size();
    }

    public Long getMin() {
        if (alNumbers.size() > 0) {
            long result = alNumbers.get(0);
            for (int i = 1; i < alNumbers.size(); i++) {
                if (result > alNumbers.get(i)) {
                    result = alNumbers.get(i);
                }
            }
            return result;
        } else {
            return null;
        }
    }

    public Long getMax() {
        if (alNumbers.size() > 0) {
            long result = alNumbers.get(0);
            for (int i = 1; i < alNumbers.size(); i++) {
                if (result < alNumbers.get(i)) {
                    result = alNumbers.get(i);
                }
            }
            return result;
        } else {
            return null;
        }
    }

    /**
     * Méthode ajoutée pour pouvoir afficher le nombre d'éléments dans la liste
     *
     * @return le nombre de valeurs aléatoires
     */
    public int size() {
        return alNumbers.size();
    }

    /**
     * Méthode ajoutée pour pouvoir afficher la liste dans une JList
     *
     * @return
     */
    public Object[] toArray() {
        return alNumbers.toArray();
    }

}
