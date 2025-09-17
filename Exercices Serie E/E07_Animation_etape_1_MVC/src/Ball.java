
import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents one ball on the screen
 *
 * @author robertfisch
 * @version 22/04/2012 14:02:15
 */
public class Ball {

    private int x = 30;
    private int y = 30;
    private int radius = 30;

    public int getX() {
        return x;
    }

    public void setX(int pX) {
        x = pX;
    }

    public int getY() {
        return y;
    }

    public void setY(int pY) {
        y = pY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int pRadius) {
        radius = pRadius;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawOval(x - radius, y - radius, 2 * radius + 1, 2 * radius + 1);
    }
}
