
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author loegu
 */
public class Ball {

    private double x;
    private double y;
    private int radius;
    private double dY = 0;
    private double friction;
    private Color color;
    private boolean falling = false;

    public Ball(double pX, double pY, int pRadius, Color pColor) {
        x = pX;
        y = pY;
        radius = pRadius;
        friction = Math.random() * (0.80 - 0.65) + 0.65;
        color = pColor;
    }

    public void draw(Graphics g) {
        for (int i = 0; i < 5; i++) {
            int tempColor = color.getRGB();
            tempColor = tempColor + 10 * i * 256 * 256;
            g.setColor(new Color(tempColor));
            g.fillOval( (int) x - radius + (int) (radius / 5.0) * i,
                        (int) y - radius + (int) (radius / 5.0) * i,
                             2 * (radius - (int) (radius / 5.0) * i),
                             2 * (radius - (int) (radius / 5.0) * i));
        }
    }

    public boolean isFalling() {
        return falling;
    }

    public void drop() {
        falling = true;
    }

    public void move(int pHeight) {
        if (falling) {
            dY = dY + 0.981;
            y = y + dY;
            if (y + radius > pHeight) {
                y = pHeight - radius;
                dY = -dY * friction;
            }
        }
    }
}
