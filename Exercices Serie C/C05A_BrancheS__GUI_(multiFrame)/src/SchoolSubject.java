
import java.util.ArrayList;

/**
 * Représente une branche d'un élève.
 *
 * @author robert fisch, fred faber
 * @version 2019
 */
public class SchoolSubject {

    /**
     * Le nom de la branche
     */
    private String name;

    /**
     * La liste des notes de la branche
     */
    private ArrayList<Integer> alMarks = new ArrayList<>();

    /**
     * Construit une nouvelle branche avec un nom donné
     *
     * @param le nom de la branche
     */
    public SchoolSubject(String pName) {
        name = pName;
    }

    /**
     * Retourne le nom de la branche
     *
     * @return	le nom de la branche
     */
    public String getName() {
        return name;
    }

    /**
     * Ajoute une note
     *
     * @param	la note à ajouter
     */
    public void addMark(int score) {
        alMarks.add(score);
    }

    /**
     * Calcule la moyenne non arrondie de la branche
     *
     * @return	la moyenne non arrondie
     */
    public double calculateAverage() {
        int sum = 0;
        for (int i = 0; i < alMarks.size(); i++) {
            sum = sum + alMarks.get(i);
        }
        return (double) sum / alMarks.size(); //Attention: forcer une division de n. réels!
    }

    /**
     * Calcule la moyenne arrondie vers le haut de la branche
     *
     * @return	la moyenne arrondie vers le haut
     */
    public int calculateRoundedAverage() {
        double average = calculateAverage();
        if (average == (int)average) {
            return (int) average;
        } else {
            return (int) average + 1;
        }

        //ou bien: 
//        return (int) Math.ceil(calculateAverage());
    }

    /**
     * Recherche la meilleure note. Cette recherche du
     * maximum peut être utilisée dans tous les cas.
     *
     * @return	la meilleure note ou "-1" s'il n'y a pas encore de notes
     */
    public int getBestMark() {
        if (alMarks.size() > 0) {
            int max = alMarks.get(0); //on commence par la première valeur de la liste
            for (int i = 1; i < alMarks.size(); i++) {
                if (alMarks.get(i) > max) {
                    max = alMarks.get(i);
                }
            }
            return max;
        } else {
            return -1;
        }
    }

    /**
     * Recherche la note la plus mauvaise. Cette recherche
     * du minimum peut être utilisée dans tous les cas.
     *
     * @return	la note la plus mauvaise ou "-1" s'il n'y a pas encore de notes
     */
    public int getWorstMark() {
        if (alMarks.size() > 0) {
            int result = alMarks.get(0); //on commence par la première valeur de la liste
            for (int i = 1; i < alMarks.size(); i++) {
                if (alMarks.get(i) < result) {
                    result = alMarks.get(i);
                }
            }
            return result;
        } else {
            return -1;
        }
    }

    
    /**
     * Méthode retournant le contenue de la liste dans un tableau (array)
     * Utilisé pour pouvoir afficher le contenu de la liste dans une jList.
     *
     * @return tableau contenant les objets de la liste
     */
    public Object[] toArray() {
        return alMarks.toArray();
    }

    /**
     * Efface le contenu (les éléments) de la liste. La liste elle-même (l'objet
     * alMarks) reste intacte.
     */
    public void clear() {
        alMarks.clear();
    }  
    
    
    /**
     * Retourne une description textuelle de l'état de la liste
     */
    @Override
    public String toString() {
        return name+" ("+alMarks.size()+")";
    }
    
}