
/**
 * Cette classe représente une chanson.
 *
 * @author     robertfisch
 * @version 18/10/2011 20:48:31
 */
public class Song {

    /**
     * la durée de la chanson en secondes
     */
    private int duration;

    /**
     * le nom de l'interprète
     */
    private String artist;

    /**
     * le titre
     */
    private String title;

    /**
     * construit une nouvelle chanson
     *
     * @param pTitle        le titre de la chanson
     * @param pArtist       l'interprète de la chanson
     * @param pDuration     la durée de la chanson en secondes
     */
    public Song(String pTitle, String pArtist, int pDuration) {
        title = pTitle;
        artist = pArtist;
        duration = pDuration;
    }

    /**
     * retourne la durée de la chanson
     *
     * @return	la durée de la chanson en secondes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * retourne l'interprète
     *
     * @return	l'interprète de la chanson
     */
    public String getArtist() {
        return artist;
    }

    /**
     * retourne le titre
     *
     * @return	le titre de la chanson
     */
    public String getTitle() {
        return title;
    }

    /**
     * retourne une représentation textuelle d'une chanson
     *
     * @return	une représentation textuelle d'une chanson
     */
    public String toString() {
        return title + " - " + artist + " (" + duration + ")";
    }
}
