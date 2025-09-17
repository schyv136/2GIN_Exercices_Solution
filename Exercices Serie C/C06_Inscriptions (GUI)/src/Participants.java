
import java.util.ArrayList;

/**
 * Cette classe représente la liste des inscriptions
 *
 * @author robertfisch
 * @version 01/02/2011 08:44:34
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

    //return the size of the list
    public int size() {
        return alParticipants.size();
    }

    //return the participant at given index
    public Participant get(int index) {
        return alParticipants.get(index);
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

    //return the contents of the list as an array of objects (-> JList)
    public Object[] toArray() {
        return alParticipants.toArray();
    }

}
