
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape {

    public Line(int pX1, int pY1, int pX2, int pY2, Color pColor) {
        super(pX1, pY1, pX2, pY2, pColor);
    }

    public Line(Point pFrom, Point pTo, Color pColor) {
        super(pFrom, pTo, pColor);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g); 
        g.drawLine(getFrom().x, getFrom().y, getTo().x, getTo().y);
    }   
 
    @Override
    public String toString() {
       return "Line " + super.toString();
    }
}
