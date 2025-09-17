
/**
 * @author FredFaber
 */
public class NumberInfo {

    /** numerical value */
    private double value;
    /** description de la valeur */
    private String label;

    
    /**
     * constructeur
     * @param value   la valeur numérique
     * @param label   la description de la valeur
     */
    public NumberInfo(double value, String label) {
        this.value = value;
        this.label = label;
    }
    
    /**
     * accesseur de la description
     * @return the value of description
     */
    public String getLabel() {
        return label;
    }

    /**
     * accesseur de la valeur
     * @return numerical value
     */
    public double getValue() {
        return value;
    }

    /**
     * retour du contenu sous forme de texte
     * @return un texte décrivant l'information
     */
    @Override
    public String toString() {
        return label +" : "+value;
    }   
    
}