/**		JEU DU LOUP
 *
 * Cette classe représente une piste et 
 * deux coureurs. Le joueur essaie de rattraper
 * le loup alors que le loup avance aléatoirement.
 * 
 * @author Jens Getreu, Fred Faber
 * @version 3.0.0
 */
public class RunningTrack
{
    /**
     * La longueur de la piste (running track).
     */
    public static final int POS_MAX = 20;
    /**
     * Le nombre maximal de pas.
     */
    public static final int STEP_MAX = 5;
    /**
     * Le nombre minimal de pas.
     */
    public static final int STEP_MIN = 1;
    /**
     * La position du loup.
     */
    private int posWolf;
    /**
     * La position du joueur.
     */
    private int posPlayer;

    /**
     * Un constructeur pour objets de la classe 
     * 
     * @param headStart l'avance initiale du loup
     */
    public RunningTrack(int headStart)
    {
       // initialiser la piste
       posWolf = 1 + headStart;
       posPlayer = 1;
    }

    /**
     * Cette méthode avance le joueur
     * de step et le loup aléatoirement
     * @param step pas du joueur
     * @return faux si le jeu est terminé
     */
    public boolean move(int step)
    {
        if ( step >= STEP_MIN && step <= STEP_MAX ) 
        {
            posPlayer = posPlayer + step;
        }
        
        posWolf = posWolf + 
                       (int)(Math.random() *(STEP_MAX-STEP_MIN+1)) + STEP_MIN;
        
        return (posPlayer < POS_MAX) 
               && (posWolf < POS_MAX)
               && (posWolf != posPlayer);
    }
    
    /**
     * Cette méthode renvoie la position d'arrivée
     * @return position maximale
     */
    public int getPosMax()
    {
        return POS_MAX;
    }
       
    /**
     * Cette méthode renvoie la
     * position du joueur 
     * @return position du joueur
     */
    public int getPosPlayer()
    {
        return posPlayer;
    }
  
    /**
     * Cette méthode renvoie la
     * position du loup 
     * @return position du loup
     */
    public int getPosWolf()
    {
        return posWolf;
    }
}