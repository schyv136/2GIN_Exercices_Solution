
import java.awt.Color;
import java.awt.Graphics;

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
    
    /**
     * dessine la ligne sur le canevas g
     * @param g  le canevas cible
     * @param color  la couleur du rectangle
     * @param left   coordonnée gauche 
     * @param bottom coordonnée inférieure (=height du canevas)
     * @param width  largeur 
     * @param heightFactor facteur d'agrandissement en hauteur
     */
    public void draw(Graphics g, Color color, int left, int bottom, int width, double heightFactor) {
        g.setColor(color);                
        //hauteur d'un rectangle
        int barHeight = (int)(value*heightFactor);                   
        //affichage du fond des rectangles
        g.fillRect(left,  bottom-barHeight, 
                   width,        barHeight);
        //afficher la bordure en rouge
        g.setColor(Color.RED);
        g.drawRect(left,  bottom-barHeight, 
                   width,        barHeight);
        //afficher le libellé et la valeur
        g.setColor(Color.BLUE);
        g.drawString(                label , left+2, bottom-4);
        g.drawString( String.valueOf(value), left+2, bottom-18);            
     }    

}