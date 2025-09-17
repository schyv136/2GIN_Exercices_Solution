
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
     * Version recommandée: 
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
     * Recherche la meilleure note. Cette recherche du maximum peut seulement
     * être utilisée dans les cas où on connaît la plus petite valeur possible
     * (ici: note 0 ou 1)
     *
     * @return	la meilleure note ou "-1" s'il n'y a pas encore de notes
     */
    public int getBestMark_1() {
        int max = -1;  //doit être inférieur à la plus petite valeur possible!
        for (int i = 0; i < alMarks.size(); i++) {
            if (alMarks.get(i) > max) {
                max = alMarks.get(i);
            }
        }
        return max;
    }

    /**
     * Version recommandée: 
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
     * Recherche la note la plus mauvaise. Cette recherche du minimum peut
     * seulement être utilisée dans les cas où on connaît la plus grande valeur
     * possible (ici: note 60)
     *
     * @return	la meilleure note ou "-1" s'il n'y a pas encore de notes
     */
    public int getWorstMark_1() {
        if (alMarks.size() > 0) { //test s'il y a au moins une valeur dans la liste
            int min = 60; //doit être supérieur ou égal à la plus grande valeur possible!
            for (int i = 0; i < alMarks.size(); i++) {
                if (alMarks.get(i) < min) {
                    min = alMarks.get(i);
                }
            }
            return min;
        } else {
            return -1;
        }
    }

    //********* Discussion de quelques alternatives  ********************************
    
    /**
     * Recherche la note la plus mauvaise. Version profitant de
     * la méthode 'contains' et travaillant avec une variable booléenne.
     * Version non recommandée, parce que très lente (dans 'contains' se cache une boucle...)
     *
     * @return	la note la plus mauvaise ou ou "-1" s'il n'y a pas encore de
     * notes
     */
    public int getWorstMark_2() {
        int worst = -1;
        boolean found = false; 
        if (alMarks.size() > 0) {
            while (!found) {
                worst++;
                if (alMarks.contains(worst)) {
                    found = true;
                }
            }
        }
        return worst;
    }

    /**
     * Recherche la note la plus mauvaise. Version profitant de la méthode 'contains'.
     * Version non recommandée, parce que très lente (dans 'contains' se cache une boucle...)
     *
     * @return	la note la plus mauvaise ou ou "-1" s'il n'y a pas encore de
     * notes
     */
    public int getWorstMark_3() {
        int worst = -1;
        if (alMarks.size() > 0) {
            while (!alMarks.contains(worst)) {
                worst++;
            }
        }
        return worst;
    }
}
