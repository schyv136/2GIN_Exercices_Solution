
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Fred Faber
 * @version 6/2/2012
 */

public class Polynomial {

    /**
     * liste des alCoefficients du polynôme
     */
    private ArrayList<Double> alCoefficients = new ArrayList<>();

    //les limites mathématiques du graphique
    /**
     * xmin l'abscisse mathématique minimale à représenter
     */
    private double xmin;
    /**
     * xmax l'abscisse mathématique maximale à représenter
     */
    private double xmax;
    /**
     * ymin l'ordonnée mathématique minimale à représenter
     */
    private double ymin;
    /**
     * ymax l'ordonnée mathématique maximale à représenter
     */
    private double ymax;

    //Fixe les limites mathématiques du graphique & actualisation du dessin
    public void setLimits(double xmin, double xmax, double ymin, double ymax) {
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
    }

    /**
     * Ajoute un coefficient au polynôme
     *
     * @param pCoeff le coefficient à ajouter
     */
    public void add(double pCoeff) {
        alCoefficients.add(pCoeff);
    }

    /**
     * Evalue le polynôme pour une valeur x donnée
     *
     * @param pX la valeur de x
     * @return la valeur de y=f(x) (f étant le polynôme)
     */
    public double evaluate(double pX) {
        double p = 0;
        for (int i = 0; i < alCoefficients.size(); i++) {
            p = p + alCoefficients.get(i) * Math.pow(pX, i);
        }
        return p;
    }

    /**
     * Evalue le polynôme pour une valeur x donnée. L'évaluation se fait par
     * l'algorithme de Horner.
     *
     * @param pX la valeur de x
     * @return la valeur de y=f(x) (f étant le polynôme)
     */
    public double evaluateHorner(double pX) {
        double p = 0;
        for (int i = alCoefficients.size() - 1; i >= 0; i--) {
            p = p * pX + alCoefficients.get(i);
        }
        return p;
    }

    /**
     * Retourne la liste des alCoefficients sous forme d'un "array" d'objets
     *
     * @return la liste des alCoefficients
     */
    public Object[] toArray() {
        return alCoefficients.toArray();
    }

    /**
     * Retourne l'équation du polynôme sous forme de texte
     *
     * @return l'équation du polynôme
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < alCoefficients.size(); i++) {
            s = alCoefficients.get(i) + "x^" + i + s;
            if (i != alCoefficients.size() - 1
                    && Double.valueOf(alCoefficients.get(i)) >= 0) {
                s = "+" + s;
            }
        }
        return s;
    }

    /**
     * Dessine la courbe du polynôme sur un canevas
     *
     * @param g le canevas destination
     * @param pWidth la largeur du canevas
     * @param pHeight la hauteur du canevas
     * @param pColor la couleur de la courbe
     */
    public void draw(Graphics g, int pWidth, int pHeight, Color pColor) {
        //calculer les facteurs de proportionnalité en horizontale et verticale
        double xfactor = (xmax - xmin) / pWidth;
        double yfactor = (ymax - ymin) / pHeight;

        //tracer la courbe
        g.setColor(pColor);
        //parcourir tous les points (x graphiques) en horizontale
        for (int xgraph = 0; xgraph < pWidth; xgraph++) {
            //calculer la valeur x mathématique
            double x = xmin + xgraph * xfactor;
            //calculer la valeur y mathématique
            double y = evaluateHorner(x);
            //calculer la valeur x graphique
            int ygraph = pHeight - (int) ((y - ymin) / yfactor);
            //dessiner les points
            g.drawLine(xgraph, ygraph, xgraph, ygraph);
        }
        //représentation de l'équation sur le graphique
        g.setColor(Color.LIGHT_GRAY);
        g.drawString("f(x) = " + toString(), 4, 21);
        g.setColor(Color.BLUE);             //avec une 'ombre'  :-)                
        g.drawString("f(x) = " + toString(), 2, 20);
        g.drawString("f(x) = " + toString(), 3, 20);
    }

}
