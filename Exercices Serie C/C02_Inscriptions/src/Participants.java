
import java.util.ArrayList;

/**
 * Cette classe représente la liste des inscriptions
 *
 * @author robertfisch
 * @version 01/02/2011 08:44:34
 */
public class Participants {

    private ArrayList<Participant> alParticipants = new ArrayList<>();

    public boolean add(Participant pParticipant) {
        return alParticipants.add(pParticipant);
    }

    public Participant remove(int index) {
        return alParticipants.remove(index);
    }

    public int size() {
        return alParticipants.size();
    }

    public Participant get(int index) {
        return alParticipants.get(index);
    }

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

}
