
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }

}
