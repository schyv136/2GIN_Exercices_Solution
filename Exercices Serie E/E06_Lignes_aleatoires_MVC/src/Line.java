
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line {

    private Point from;
    private Point to;
    private Color color = Color.BLACK;  // pour les plus rapides

    public Line(int pX1, int pY1, int pX2, int pY2) {
        from = new Point(pX1, pY1);
        to = new Point(pX2, pY2);
    }

    public Line(Point pFrom, Point pTo) {
        from = pFrom;
        to = pTo;
    }
 
    /**
     * pour les plus rapides :
     * @param pColor the color to set
     */
    public void setColor(Color pColor) {
        color = pColor;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(from.x, from.y, to.x, to.y);
    }
}
