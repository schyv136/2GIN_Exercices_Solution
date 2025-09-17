
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

/**
 * @author Fred Faber
 * @version 29/6/2012
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
     * ymin l'ordonnée mathématique minimale à représenter --> calculée
     * automatiquement
     */
    /**
     * ymax l'ordonnée mathématique maximale à représenter --> calculée
     * automatiquement
     */
    //Fixe les limites mathématiques du graphique & actualisation du dessin
    public void setLimits(double xmin, double xmax) {
        this.xmin = xmin;
        this.xmax = xmax;
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
     * Retourne l'équation du polynôme sous forme de texte avec améliorations.
     *
     * @return l'équation du polynôme
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < alCoefficients.size(); i++) {
            if (alCoefficients.get(i) != 0) //ne pas afficher les termes nuls
            {
                if (i > 0) //ne pas afficher x^0
                {
                    if (i == 1) {
                        s = "x" + s; //afficher x au lieu de x^1
                    } else {
                        s = "x^" + i + s;
                    }
                }
                if (alCoefficients.get(i) != 1 || i == 0) //ne pas afficher 1.0x^...
                {
                    s = alCoefficients.get(i) + s;
                }
                if (i != alCoefficients.size() - 1
                        && //éviter '+' devant '-'             
                        Double.valueOf(alCoefficients.get(i)) >= 0) {
                    s = " +" + s;
                } else {
                    s = " " + s;
                }
            }
        }
        //s'il n'y a pas de termes non nuls retourner 0
        if (s.equals("")) {
            s = "0";
        }

        return s;
    }

    /**
     * Dessine la courbe du polynôme sur un canevas avec améliorations.
     *
     * @param g le canevas destination
     * @param pWidth la largeur du canevas
     * @param pHeight la hauteur du canevas
     * @param pColor la couleur de la courbe
     */
    public void draw(Graphics g0, int pWidth, int pHeight, Color pColor) {
        //pour avancés: représentation avec anti-alias  
        // => utilisation de Graphics2D
        Graphics2D g = (Graphics2D) g0;
        g.setStroke(new BasicStroke(2));  //largeur des lignes 2 points
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //calculer les facteurs de proportionnalité en horizontale 
        double xfactor = (xmax - xmin) / pWidth;

        //Calculer ymin et ymax :
        //calculer une valeur initiale pour ymin et ymax
        double y = evaluateHorner(xmin);
        double ymin = y;
        double ymax = y;
        //calculer toutes les valeurs et déterminer ymin et ymax
        for (int xgraph = 0; xgraph < pWidth; xgraph++) {
            //calculer la valeur x mathématique
            double x = xmin + xgraph * xfactor;
            //calculer la valeur y mathématique
            y = evaluateHorner(x);
            //changer ymin et ymax si nécessaire
            if (y < ymin) {
                ymin = y;
            }
            if (y > ymax) {
                ymax = y;
            }
        }

        //calculer le facteur de proportionnalité en vertictale
        double yfactor = (ymax - ymin) / pHeight;

        //Dessiner les axes
        g.setColor(Color.LIGHT_GRAY);
        if (xmin <= 0 && xmax >= 0) //s'il y a un changement de signe entre xmin et xmax
        {
            //axe des ordonnées (axe des y)
            double xPosYAxis = -xmin / xfactor;
            g.drawLine((int) xPosYAxis, 0,
                    (int) xPosYAxis, pHeight - 1);
        }
        if (ymin <= 0 && ymax >= 0) //s'il y a un changement de signe entre ymin et ymax
        {
            //axe des abscisses (axe des x)
            double yPosXAxis = -ymin / yfactor;
            g.drawLine(0, pHeight - 1 - (int) yPosXAxis,
                    pWidth - 1, pHeight - 1 - (int) yPosXAxis);
        }

        //tracer la courbe
        //couleur Foreground du panneau - peut être modifiée dans 
        //l'inspecteur d'objet en NetBeans
        g.setColor(pColor);

        //initialiser les variables pour les valeurs précédentes  
        //(servent à dessiner des lignes au lieu de points)
        int lastx = 0;
        int lasty = pHeight - 1 - (int) ((evaluateHorner(xmin) - ymin) / yfactor);

        //parcourir tous les points (x graphiques) en horizontale
        for (int xgraph = 0; xgraph < pWidth; xgraph++) {
            //calculer la valeur x mathématique
            double x = xmin + xgraph * xfactor;
            //calculer la valeur y mathématique
            y = evaluateHorner(x);
            //calculer la valeur x graphique
            int ygraph = pHeight - 1 - (int) ((y - ymin) / yfactor);
            //dessiner les points
            g.drawLine(lastx, lasty, xgraph, ygraph);
            //mémoriser les valeurs comme points de départ pour la 
            //prochaine ligne
            lastx = xgraph;
            lasty = ygraph;
        }

        //représentation de l'équation sur le graphique (améliorée)
        g.setColor(Color.LIGHT_GRAY);
        g.drawString("f(x) = " + toString(), 4, 21);
        g.setColor(Color.BLUE);
        g.drawString("f(x) = " + toString(), 2, 20);
        g.drawString("f(x) = " + toString(), 3, 20);

    }

}
