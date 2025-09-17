
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author FisRo156
 */
public class Square {

    private int x;
    private int y;
    private int side;
    private Color color;

    public Square(int x, int y, int side, Color color) {
        this.x = x;
        this.y = y;
        this.side = side;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, side, side);
    }
}
