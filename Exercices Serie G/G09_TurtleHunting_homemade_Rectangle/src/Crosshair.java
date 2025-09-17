
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Rectangle;   //on n'utilise plus la classe prédéfinie...

/**
 *
 * @author Georges Kugener
 */
public class Crosshair extends Rectangle {

    public Crosshair(int pX, int pY) {
        super(pX, pY, 1, 1);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(getX(), getY() - 40, getX(), getY() + 40);
        g.drawLine(getX() - 40, getY(), getX() + 40, getY());
        g.drawOval(getX() - 10, getY() - 10, 21, 21);
        g.drawOval(getX() - 25, getY() - 25, 51, 51);
    }

}
