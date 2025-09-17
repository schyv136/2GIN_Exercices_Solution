
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Rectangle;

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
        g.fillOval(getX() + 2, getY() + 6, 16, 16);
        // draw head
        g.fillOval(getX() + 7, getY() + 0, 6, 8);
        // draw legs
        g.drawLine(getX() + 0, getY() + 7, getX() + 20, getY() + 24);
        g.drawLine(getX() + 20, getY() + 7, getX() + 0, getY() + 24);

        //Demo: show Rectangle
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(getX(), getY(), 21, 25);

    }

    /**
     * deplace la tortue de quelques pixel à droite
     *
     * @param pDist le nombre de pixel à déplacer
     */
    public void goRight(int pDist) {
        setLocation(getX() + pDist, getY());
    }

    /**
     * deplace la tortue de quelques pixel à gauche
     *
     * @param pDist le nombre de pixel à déplacer
     */
    public void goLeft(int pDist) {
        setLocation(getX() - pDist, getY());
    }

    /**
     * deplace la tortue de quelques pixel vers le haut
     *
     * @param pDist le nombre de pixel à déplacer
     */
    public void goUp(int pDist) {
        setLocation(getX(), getY() - pDist);
    }

    /**
     * deplace la tortue de quelques pixel vers le bas
     *
     * @param pDist le nombre de pixel à déplacer
     */
    public void goDown(int pDist) {
        setLocation(getX(), getY() + pDist);
    }

    /**
     * déplace la tortue aléatoirement d'une distance de -10 à 10 points
     */
    public void makeRandomMove() {
        setLocation(getX() + (int) (Math.random() * 21) - 10,
                getY() + (int) (Math.random() * 21) - 10);
    }

    /**
     * déplace la tortue d'une distance donnée
     */
    public void moveBy(int diffX, int diffY) {
        setLocation(getX() + diffX, getY() + diffY);
    }

}
