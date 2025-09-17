
import java.util.ArrayList;

/**
 * Cette classe représente la liste des inscriptions
 * 
 * @author Fred Faber
 * @version 06_12_2019
 */
public class Participants {

    private ArrayList<Participant> alParticipants = new ArrayList<>();

    //add in order (order is defined inside Participant by compareTo and equals)	
    public void add(Participant pParticipant) {
        // Ajouter le nouveau participant à la fin de la liste
        alParticipants.add(pParticipant);
        // En parcourant la liste de la fin au début, déplacer 
        // d'une position vers l'arrière les anciens alParticipants
        // qui suivent le nouveau participant dans l'ordre 
        // alphabétique
        int i = alParticipants.size() - 2;
        while ((i >= 0)
                && (pParticipant.compareTo(alParticipants.get(i)) < 0)) { // utilisation de compareTo redéfini
            alParticipants.set(i + 1, alParticipants.get(i));
            i--;
        }
        // Insérer le nouveau participant
        alParticipants.set(i + 1, pParticipant);
    }

    public void remove(int i) {
        alParticipants.remove(alParticipants.get(i));
    }

    //find minimum (by birthyear)
    public Participant getEldest() {
        if (alParticipants.size() > 0) {
            Participant eldest = alParticipants.get(0);
            for (int i = 1; i < alParticipants.size(); i++) {
                if (alParticipants.get(i).isOlder(eldest)) { // utilisation de isOlder
                    eldest = alParticipants.get(i);
                }
            }
            return eldest;
        } else {
            return null;
        }
    }

    //find maximum (by birthyear)
    public Participant getYoungest() {
        if (alParticipants.size() > 0) {
            Participant youngest = alParticipants.get(0);
            for (int i = 1; i < alParticipants.size(); i++) {
                if (alParticipants.get(i).isYounger(youngest)) { // utilisation de isYounger
                    youngest = alParticipants.get(i);
                }
            }
            return youngest;
        } else {
            return null;
        }
    }

    //linear search (order is defined inside Participant by compareTo and equals)
    public int linearSearch(Participant pP) { //recherche linéaire
        int result = -1;
        int i = 0;
        while (i < alParticipants.size() && result == -1) {
            if (pP.equals(alParticipants.get(i))) { //utilisation de equals redéfini
                result = i;
            }
            i++;
        }
        return result;
    }

    //binary search (order is defined inside Participant by compareTo and equals)
    public int binarySearch(Participant pP) { //recherche dichotomique
        boolean found = false;
        int lowerLimit = 0;
        int upperLimit = alParticipants.size() - 1;
        int middleIndex = 0;
        while ((!found) && (lowerLimit <= upperLimit)) {
            middleIndex = (upperLimit + lowerLimit) / 2;
            Participant middle = alParticipants.get(middleIndex);
            if (middle.equals(pP)) { // utilisation de equals redéfini
                found = true;
            } else if (middle.compareTo(pP) > 0) { // utilisation de compareTo redéfini
                upperLimit = middleIndex - 1;
            } else {
                lowerLimit = middleIndex + 1;
            }
        }
        if (found) {
            return middleIndex;
        } else {
            return -1;
        }
    }

    //return the contents of the list as an array of objects (-> JList)
    public Object[] toArray() {
        return alParticipants.toArray();
    }

}
