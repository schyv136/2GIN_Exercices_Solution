/**
 * Classe représentant une citerne d'un certain volume.
 * Il est possible d'ajouter ou de retirer un certain volume de liquide.
 * Le volume fourni en trop est ignoré, c.-à-d. 
 *   la citerne sera pleine mais le volume débordant est perdu 
 * Le volume demandé en trop est ignoré, c.-à-d. 
 *   la citerne sera vide mais le volume demandé en trop est ignoré 
 */
public class Cistern
{

    /** capacité maximale de la citerne */
    private double maximumVolume;
    /** volume qui se trouve actuellement dans la citerne */
    private double currentVolume;

    /**
     * Constructeur : définit une nouvelle citerne par ses dimensions extérieures

     * @param pRadius    le rayon de la citerne en m
     * @param pHeight    la hauteur de la citerne en m
     */
    public Cistern(double pRadius, double pHeight)
    {   // Attention à la conversion m^3 -> litres
        maximumVolume = Math.PI * pRadius*pRadius * pHeight * 1000; 
        currentVolume = 0;
    }

    /**
     * Ajouter de l'eau à la citerne jusqu'à faire le plein
     * @param pVolume   volume de liquide à ajouter
     */
    public void add(double pVolume)
    {
        if ( currentVolume + pVolume <= maximumVolume)
        {
             currentVolume = currentVolume + pVolume;
        }
        else
        {
            currentVolume = maximumVolume;
        }
    }

    /**
     * Retirer de l'eau de la citerne jusqu'à la vider
     * @param pVolume   volume de liquide à retirer
     */
    public void drain(double pVolume)
    {
        if (pVolume <= currentVolume)
        {
             currentVolume = currentVolume - pVolume;
        }
       else
        {
           currentVolume = 0;
        }
    }

    /**
     * Ajouter de l'eau à la citerne jusqu'à faire le plein
     * @param pVolume   volume de liquide à ajouter
     * @return   true si l'action a été effectuée sans déborder
     */
    public boolean addOk(double pVolume)
    {
        if (currentVolume + pVolume <= maximumVolume)
        {
          currentVolume = currentVolume + pVolume;
          return true;
        }
        else
        {
          currentVolume = maximumVolume;
          return false;
        }
    }

    /**
     * Retirer du liquide de la citerne jusqu'à la vider
     * @param    pVolume   volume de liquide à retirer
     * @return   true si tout le volume requis a pu être retiré
     */
    public boolean drainOk(double pVolume)
    {
        if (pVolume <= currentVolume)
        {
           currentVolume = currentVolume - pVolume;
           return true;
        }
        else
        {
           currentVolume = 0;
       	   return false;
        }
    }

    /**
     * Accesseur retournant le volume actuel
     * @return      volume actuel de liquide dans la citerne
     */
    public double getCurrentVolume()
    {
        return currentVolume;
    }

    /**
     * Accesseur retournant le taux de remplissage actuel
     * @return      taux de remplissage en pourcentage
     */
    public double getPercentage()
    {
        return currentVolume/maximumVolume * 100;
    }

    /**
     * Retourner un message indiquant le volume et le taux de remplissage actuels
     * @return      texte contenant le message d'information
     */
    @Override
    public String toString()
    {
        return "Fill level : "+currentVolume+" / "+maximumVolume
                +" liters ("+getPercentage()+"%)";
    }
}