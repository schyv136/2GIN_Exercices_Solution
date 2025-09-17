
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author robertfisch
 */
public class Ball extends MovingObject {

    private int radius;

    public Ball(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
        setStepY(5);
    }

    public void move(int width) {
        super.move();
        if (getX() < radius) //balle touche à gauche
        {
            setX(radius);
        } else if (getX() + radius > width) //balle touche à droite
        {
            setX(width - radius);
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(getX() - radius, getY() - radius, 2 * radius, 2 * radius);
        g.setColor(Color.BLACK);
        g.drawOval(getX() - radius, getY() - radius, 2 * radius, 2 * radius);
    }

    public int getRadius() {
        return radius;
    }
}
