
import java.awt.Color;
import java.awt.Graphics;

public class Square extends RegularShape {

    public Square(int x, int y, int side, Color color) {
        super(x, y, side, color);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawRect(getX(), getY(), getSide(), getSide());
    }

}
