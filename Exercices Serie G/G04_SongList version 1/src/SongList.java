
import java.util.ArrayList;

/**
 * Cette classe représente une liste de chanson. 
 * Elle ne peut contenir deux fois
 * la même chanson.
 *
 * @author robertfisch, Fred Faber
 * @version 29/1/2014
 */
public class SongList {

    /**
     * la liste des chansons
     */
    private ArrayList<Song> alSongs = new ArrayList<>();

    /**
     * calcule la durée totale de la liste
     *
     * @return la durée totale en secondes
     */
    public int calculateDuration() {
        int total = 0;
        for (int i = 0; i < alSongs.size(); i++) {
            total += alSongs.get(i).getDuration();
        }
        return total;
    }

    /**
     * ajoute une chanson à la liste si elle n'y est pas encore
     *
     * @param	pSong	la chanson à ajouter.
     * @return true ssi la chanson a pu être ajoutée avec succès
     */
    public boolean add(Song pSong) {
        if (!alSongs.contains(pSong)) {
            return alSongs.add(pSong);
        } else {
            return false;
        }
    }
}
