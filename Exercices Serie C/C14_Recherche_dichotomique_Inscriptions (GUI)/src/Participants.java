
import java.util.ArrayList;

/**
 * Cette classe représente la liste des inscriptions
 * 
 * @author Fred Faber, robert fisch, Georges Kugener
 * @version 06/12/2019
 */
public class Participants {

    private ArrayList<Participant> alParticipants = new ArrayList<>();

    //add in order (by name)
    public void addByName(Participant pParticipant) {
        // Ajouter un participant vide à la fin de la liste 
        // c.-à-d. ajouter une place vide à la liste
        alParticipants.add(null);
        // En parcourant la liste de la fin au début, déplacer 
        // d'une position vers l'arrière les anciens alParticipants
        // qui suivent le nouveau participant dans l'ordre 
        // alphabétique
        int i = alParticipants.size() - 2;
        String fullName = pParticipant.getFullName();
        while ((i >= 0)
                && (fullName.compareTo(alParticipants.get(i).getFullName()) < 0)) {
            alParticipants.set(i + 1, alParticipants.get(i));
            i--;
        }
        // Insérer le nouveau participant
        alParticipants.set(i + 1, pParticipant);
    }

    //remove participant at index i     
    public void remove(int i) {
        alParticipants.remove(alParticipants.get(i));
    }

    //find minimum (by birthyear)
    public Participant getEldest() {
        if (alParticipants.size() > 0) {
            Participant eldest = alParticipants.get(0);
            for (int i = 1; i < alParticipants.size(); i++) {
                if (alParticipants.get(i).getBirthYear() < eldest.getBirthYear()) {
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
                if (alParticipants.get(i).getBirthYear() > youngest.getBirthYear()) {
                    youngest = alParticipants.get(i);
                }
            }
            return youngest;
        } else {
            return null;
        }
    }

    //Binary search (by name)
    public int searchByName(String pName) { 
        boolean found = false;
        int lowerLimit = 0;
        int upperLimit = alParticipants.size() - 1;
        int middleIndex = 0;
        while ((!found) && (lowerLimit <= upperLimit)) {
            middleIndex = (upperLimit + lowerLimit) / 2;
            String currentName = alParticipants.get(middleIndex).getName();
            if (currentName.equals(pName)) {
                found = true;
            } else if (currentName.compareTo(pName) > 0) {
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

    //Selection sort (by name)
    public void sortByName() {  
        int size = alParticipants.size();
        for (int i = 0; i < size - 1; i++) {
            // recherche de la position du minimum (derrière la position i)
            int positionMinimum = i;
            for (int j = i + 1; j < size; j++) {
                if (alParticipants.get(j).getName().compareTo(
                        alParticipants.get(positionMinimum).getName()) < 0) {
                    positionMinimum = j;
                }
            }
            //échange si nécessaire
            if (positionMinimum != i) {
                // permutation: version standard
                Participant temp = alParticipants.get(positionMinimum);
                alParticipants.set(positionMinimum, alParticipants.get(i));
                alParticipants.set(i, temp);

                // permutation: version alternative
                // Cette version profite du fait que set retourne 
                // l'objet qui est remplacé comme résultat.
                //persons.set(i,persons.set(positionMinimum, persons.get(i)));
            }
        }
    }

    //return the contents of the list as an array of objects (-> JList)
    public Object[] toArray() {
        return alParticipants.toArray();
    }

}
