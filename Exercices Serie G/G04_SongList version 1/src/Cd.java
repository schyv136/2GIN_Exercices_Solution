/**
 * Cette classe représente un CD.
 *
 * @author Fred Faber
 * @version 29/1/2014
 */
public class Cd extends SongList {

    /**
     * la capacité en secondes
     */
    private int capacity = 74 * 60;

    public int getCapacity() {
        return capacity;
    }
    
    /**
     * crée un nouveau CD avec une capacité donnée
     *
     * @param	pCapacity	la capacité du CD en secondes (entier)
     */
    public Cd(int pCapacity) {
        capacity = pCapacity;
    }

    /**
     * crée un nouveau CD avec une capacité donnée
     *
     * @param	pCapacity	la capacité du CD en minutes (n.réel)
     */
    public Cd(double pCapacity) {
//		int minutes = (int) pCapacity;
//		int secondes = (int) ((pCapacity-minutes)*60);
//		capacity = minutes*60 + secondes;

        capacity = (int) (pCapacity * 60);
    }

    /**
     * ajoute une chanson au CD s'il y a assez de place disponible
     *
     * @param	pSong	la chanson à ajouter
     */
    @Override
    public boolean add(Song pSong) {
        if (calculateDuration() + pSong.getDuration() <= capacity) {
            return super.add(pSong); //appel de la méthode héritée
        } else {
            return false;
        }
    }

    /**
     * 
     * @return la capacité actuellement libre du CD
     */
    public int getFreeCapacity() {
        return capacity-calculateDuration();
    }
    
}