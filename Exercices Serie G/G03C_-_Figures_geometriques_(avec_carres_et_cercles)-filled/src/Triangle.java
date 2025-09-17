
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Triangle extends IrregularShape {

    public Triangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Polygon p = new Polygon();
        p.addPoint(getX() + getWidth() / 2, getY());
        p.addPoint(getX(), getY() + getHeight());
        p.addPoint(getX() + getWidth(), getY() + getHeight());
        g.fillPolygon(p);
    }
}
