
import java.awt.Color;
import java.awt.Graphics;

public class Circle extends RegularShape {

    public Circle(int x, int y, int side, Color color) {
        super(x, y, side, color);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawOval(getX(), getY(), getSide(), getSide());
    }

}
