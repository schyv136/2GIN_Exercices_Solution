
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Georges Kugener
 */
public class Turtle extends Rectangle {

    private Color color;

    public Turtle(int pX, int pY, Color pColor) {
        super(pX, pY, 21, 25);
        color = pColor;
    }

    public void draw(Graphics g) {
        // choose color
        g.setColor(color);
        // draw body
        g.fillOval(x + 2, y + 6, 16, 16);
        // draw head
        g.fillOval(x + 7, y + 0, 6, 8);
        // draw legs
        g.drawLine(x + 0, y + 7, x + 20, y + 24);
        g.drawLine(x + 20, y + 7, x + 0, y + 24);
    }

    /**
     * deplace la tortue de quelques pixel à droite
     *
     * @param pDist le nombre de pixel à déplacer
     */
    public void goRight(int pDist) {
        x = x + pDist;
    }

    /**
     * deplace la tortue de quelques pixel à gauche
     *
     * @param pDist le nombre de pixel à déplacer
     */
    public void goLeft(int pDist) {
        x = x - pDist;
    }

    /**
     * deplace la tortue de quelques pixel vers le haut
     *
     * @param pDist le nombre de pixel à déplacer
     */
    public void goUp(int pDist) {
        y = y - pDist;
    }

    /**
     * deplace la tortue de quelques pixel vers le bas
     *
     * @param pDist le nombre de pixel à déplacer
     */
    public void goDown(int pDist) {
        y = y + pDist;
    }

}
