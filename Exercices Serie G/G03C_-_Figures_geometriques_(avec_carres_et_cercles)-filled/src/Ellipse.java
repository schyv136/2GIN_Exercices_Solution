
import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends IrregularShape {

    public Ellipse(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }

}
