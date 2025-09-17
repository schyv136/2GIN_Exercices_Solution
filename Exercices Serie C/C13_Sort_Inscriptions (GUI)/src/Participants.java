
import java.util.ArrayList;

/**
 * Cette classe représente la liste des inscriptions
 * 
 * @author robertfisch, Georges Kugener, Fred Faber
 * @version 06_12_2019
 */
public class Participants {

    private ArrayList<Participant> alParticipants = new ArrayList<>();

    //add to the end of the list	
    public void add(Participant pParticipant) {
        alParticipants.add(pParticipant);
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

    //linear search (by birthyear)
    public int searchByBirthYear(int pBirthYear) {
        int result = -1;
        int i = 0;
        while ((result == -1) && (i < alParticipants.size())) {
            if (pBirthYear == alParticipants.get(i).getBirthYear()) {
                result = i;
            }
            i++;
        }
        return result;
    }

    //linear search (by name)
    public int searchByName(String pName) {
        int result = -1;
        int i = 0;
        while ((result == -1) && (i < alParticipants.size())) {
            if (pName.equals(alParticipants.get(i).getName())) {
                result = i;
            }
            i++;
        }
        return result;
    }

    //selection sort (by birthyear)
    public void sortByBirthYear() {
        int size = alParticipants.size();
        for (int i = 0; i < size - 1; i++) {
            // recherche de la position du minimum (derrière la position i)
            int positionMinimum = i;
            for (int j = i + 1; j < size; j++) {
                if (alParticipants.get(j).getBirthYear()
                        < alParticipants.get(positionMinimum).getBirthYear()) {
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

    //selection sort  (by name)
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
