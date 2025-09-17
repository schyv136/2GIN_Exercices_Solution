
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;


/**
 * Classe pour des objets contenant les données d'une ligne
 * @author Fred Faber
 * @version 2013-01-14
 */
public class Line {

    /** point de départ de la ligne */
    private Point from;
    /** point d'arrivée de la ligne */
    private Point to;
    /** la couleur de la ligne */
    private Color color;

    
    /**
     * constructeur pour créer une nouvelle ligne à partir de 2 points
     * @param pFrom  le point de départ de la ligne
     * @param pTo    le point d'arrivée de la ligne
     * @param pColor la couleur de la ligne
     */
    public Line(Point pFrom, Point pTo, Color pColor) {
        from   = pFrom;
        to     = pTo;
        color  = pColor;
    }
    
    /**
     * constructeur pour créer une nouvelle ligne à partir de 4 coordonnées
     * @param fromX  abscisse du point de départ de la ligne
     * @param fromY  ordonnée du point de départ de la ligne
     * @param toX    abscisse du point d'arrivée de la ligne
     * @param toY    ordonnée du point d'arrivée de la ligne
     * @param pColor la couleur de la ligne
     */
    public Line(int fromX, int fromY, int toX, int toY, Color pColor) {
        from   = new Point(fromX, fromY);
        to     = new Point(toX  , toY  );
        color  = pColor;
    }

    // accesseurs / getters
    public Point getFrom() {
        return from;
    }
    
    public Point getTo() {
        return to;
    }
    
    public Color getColor() {
        return color;
    }

    
    /**
     * dessine la ligne sur le canevas g
     * @param g  le canevas cible
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(from.x, from.y, to.x, to.y);
        
        //Amélioration pour avancés: tracer des lignes plus épaisses
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(5.0f));
        g2.drawLine(from.x, from.y, to.x, to.y);
    }

}