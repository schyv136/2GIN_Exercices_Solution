
import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends IrregularShape {

    public Triangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(getX() + getWidth() / 2, getY(), getX(), getY() + getHeight());
        g.drawLine(getX(), getY() + getHeight(), getX() + getWidth(), getY() + getHeight());
        g.drawLine(getX() + getWidth(), getY() + getHeight(), getX() + getWidth() / 2, getY());
    }
}
