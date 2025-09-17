
import java.util.ArrayList;

/**
 * Cette classe représente la liste des inscriptions
 * 
 * @author Fred Faber
 * @version 10/03/2016
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

    //------------ Recherche linéaire: Différentes versions --------------------
    
    
    //Version 1 : Trouver l'indice de la DERNIERE occurrence avec for	
    //version lente (parcourt toujours le tableau entier)
    public int searchByBirthYear(int pBirthYear) {
        int result = -1;  //l'indice à retourner comme résultat
        for (int i = 0; i < alParticipants.size(); i++) {
            if (alParticipants.get(i).getBirthYear() == pBirthYear) {
                result = i;
            }
        }
        return result;
    }

    //Version 2 : Trouver l'indice de la PREMIERE occurrence avec for A REBOURS
    //version lente (parcourt toujours le tableau entier)
    public int searchByBirthYear_2(int pBirthYear) {
        int result = -1;  //l'indice à retourner comme résultat
        for (int i = alParticipants.size() - 1; i >= 0; i--) {
            if (alParticipants.get(i).getBirthYear() == pBirthYear) {
                result = i;
            }
        }
        return result;
    }

    //Version 3 : Trouver l'indice de la PREMIERE occurrence avec for
    //version lente (parcourt toujours le tableau entier)
    //Attention au test sur result==-1 car il faut mémoriser la 1ère occurrence!
    public int searchByBirthYear_3(int pBirthYear) {
        int result = -1;  //l'indice à retourner comme résultat
        for (int i = 0; i < alParticipants.size(); i++) {
            if (alParticipants.get(i).getBirthYear() == pBirthYear && result == -1) {
                result = i;
            }
        }
        return result;
    }

    //Version 4 : Trouver l'indice de la PREMIERE occurrence avec while 
    //plus rapide (on s'arrête dès qu'on connaît la solution)
    public int searchByBirthYear_4(int pBirthYear) {       // <<< Méthode conseillée!
        int result = -1;  //l'indice à retourner comme résultat
        int i = 0;
        while (i < alParticipants.size() && result == -1) {
            if (alParticipants.get(i).getBirthYear() == pBirthYear) {
                result = i;
            }
            i++;
        }
        return result;
    }

    //Version 5 : Trouver l'indice de la PREMIERE occurrence avec while
    //et en utilisant une variable logique
    //plus rapide (on s'arrête dès qu'on connaît la solution)
    public int searchByBirthYear_5(int pBirthYear) {
        boolean found = false;
        int i = 0;
        while ((!found) && (i < alParticipants.size())) {
            if (pBirthYear == alParticipants.get(i).getBirthYear()) {
                found = true;
            } else {
                i++;
            }
        }
        if (found) {
            return i;
        } else {
            return -1;
        }
    }

    //Recherche d'après le nom:
    //Trouve la PREMIERE OCCURRENCE
    //Attention : on compare des objets (String) ==> utiliser equals!
    public int searchByName(String pName) {
        int result = -1;  //l'indice à retourner comme résultat
        for (int i = 0; i < alParticipants.size(); i++) {
            if (pName.equals(alParticipants.get(i).getName()) && result == -1) {
                result = i;
            }
        }
        return result;
    }

    //--------------------------------------------------------------------------
    
    //return the contents of the list as an array of objects (-> JList)
    public Object[] toArray() {
        return alParticipants.toArray();
    }

}
