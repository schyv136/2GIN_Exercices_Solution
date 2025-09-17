
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Mémorisation du temps en heures et minutes
 *
 * @author Michel Mercatoris & Fred Faber & Jens Getreu
 * @version 30/12/2011, 2017
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
     * difference to UTC Time
     */
    private int diffUTC;

    /**
     * constructeur
     *
     * @param pHours	l'heure
     * @param pMinutes	les minutes
     * @param pDiffUTC
     */
    public UniversalTime(int pHours, int pMinutes, int pDiffUTC) {
        minutes = pMinutes;
        hours = pHours;
        diffUTC = pDiffUTC;
    }

    /**
     * constructeur
     *
     * @param pDiffUTC
     */
    public UniversalTime(int pDiffUTC) {
        diffUTC = pDiffUTC;
        //initialise par le temps local
        setToSystemTime();
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
        return valueOf((24 + hours - diffUTC) % 24, minutes);
    }

    public String getNewYorkTime() {
        return valueOf((24 + hours - diffUTC - 5) % 24, minutes);
    }

    public String getTallinnTime() {
        return valueOf((24 + hours - diffUTC + 2) % 24, minutes);
    }

    public String getLosAngelesTime() {
        return valueOf((24 + hours - diffUTC - 8) % 24, minutes);
    }

    public String getBangkokTime() {
        return valueOf((24 + hours - diffUTC + 7) % 24, minutes);
    }

    public String getMoscowTime() {
        return valueOf((24 + hours - diffUTC + 4) % 24, minutes);
    }

    public String getDelhiTime() {
        int h = hours - diffUTC + 5;
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

    //version améliorée
//    private String valueOf(int pHours, int pMinutes) {
//        return pHours + ((pMinutes < 10) ? ":0" : ":") + pMinutes + "h";
//    }

    //version deluxe: formatage prédéfini
//    private String valueOf(int pHours, int pMinutes) {
//        //Créer une instance de Localtime avec le temps donné
//        LocalTime now = LocalTime.of(pHours, pMinutes);
//        // Utiliser les formatages prédéfinis
//        //MEDIUM: with seconds, SHORT without seconds
//        DateTimeFormatter formatter
//                = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
//        return now.format(formatter).toString() + "h";
//    }

    /**
     * Retourner comme texte le temps actuel ainsi que le temps en minutes
     *
     * @return	texte contenant le temps actuel ainsi que le temps en minutes
     */
    @Override
    public String toString() {
        return valueOf(hours, minutes) + " (" + getTimeInMinutes() + " minutes) diffUTC:" + diffUTC;
    }
}
