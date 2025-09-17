
import java.time.LocalTime;

/**
 * Mémorisation du temps en heures et minutes
 *
 * @author Michel Mercatoris & Fred Faber & Jens Getreu
 * @version 30/12/2011
 */
public class UniversalTime {

    /**
     * les heures
     */
    private int hours;
    /**
     * les minutes
     */
    private int minutes;

    /**
     * constructeur
     *
     * @param pHours	l'heure
     * @param pMinutes	les minutes
     */
    public UniversalTime(int pHours, int pMinutes) {
        minutes = pMinutes;
        hours = pHours;
    }

    /**
     * retourne le temps actuel en minutes
     *
     * @return le temps actuel en minutes
     */
    public int getTimeInMinutes() {
        return minutes + hours * 60;
    }

    /**
     * Initialise le temps actuel par le temps actuel (de l'ordinateur) Ici, on
     * profite de la classe LocalTime (qui doit être importée avant la
     * définition de la classe)
     */
    public void setToSystemTime() {
        //Créer une nouvelle instance now de la classe prédéfinie LocalTime
        LocalTime now = LocalTime.now();
        // Utiliser l'instance now pour obtenir l'heure et les minutes actuelles
        hours = now.getHour();
        minutes = now.getMinute();
    }

    public String getLocalTime() {
        return valueOf(hours, minutes);
    }

    public String getUtcTime() {
        return valueOf((24 + hours - 1) % 24, minutes);
    }

    public String getNewYorkTime() {
        return valueOf((24 + hours - 6) % 24, minutes);
    }

    public String getTallinnTime() {
        return valueOf((24 + hours + 1) % 24, minutes);
    }

    public String getLosAngelesTime() {
        return valueOf((24 + hours - 9) % 24, minutes);
    }

    public String getBangkokTime() {
        return valueOf((24 + hours + 6) % 24, minutes);
    }

    public String getMoscowTime() {
        return valueOf((24 + hours + 3) % 24, minutes);
    }

    public String getDelhiTime() {
        int h = hours + 4;
        int m = minutes + 30;
        if (m >= 60) {
            m = m - 60;
            h = h + 1;
        }
        //ou bien :
        //h = hours+diffUTC+5+(minutes+30)/60;
        //m = (minutes+30)%60;
        return valueOf((24 + h) % 24, m);
    }

    /**
     * Retourner comme texte le temps passé comme paramètre
     *
     * @return	texte contenant le temps donné
     */
    private String valueOf(int pHours, int pMinutes) {
        return pHours + ":" + pMinutes + "h";
    }

    /**
     * Retourner comme texte le temps actuel ainsi que le temps en minutes
     *
     * @return	texte contenant le temps actuel ainsi que le temps en minutes
     */
    public String toString() {
        return hours + ":" + minutes + "h (" + getTimeInMinutes() + " minutes)";
    }
}
