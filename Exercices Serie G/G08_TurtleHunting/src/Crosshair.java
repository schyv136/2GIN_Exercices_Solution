
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

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
        g.drawLine(x, y - 40, x, y + 40);
        g.drawLine(x - 40, y, x + 40, y);
        g.drawOval(x - 10, y - 10, 21, 21);
        g.drawOval(x - 25, y - 25, 51, 51);
        
        //Demo: show Rectangle
        g.setColor(Color.RED);
        g.drawRect(x, y, width, height);
    }

}
