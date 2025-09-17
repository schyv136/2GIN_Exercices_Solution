
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class RightTriangle extends Shape {

    public RightTriangle(Point pFrom, Point pTo, Color color) {
        super(pFrom, pTo, color);
    }

    public RightTriangle(int pX1, int pY1, int pX2, int pY2, Color pColor) {
        super(pX1, pY1, pX2, pY2, pColor);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g); 
        g.drawLine(getFrom().x, getFrom().y,getTo().x, getTo().y);
        g.drawLine(getTo().x, getTo().y,getFrom().x, getTo().y);
        g.drawLine(getFrom().x, getTo().y,getFrom().x, getFrom().y);
    }

    @Override
    public String toString() {
       return "RightTriangle " + super.toString();
    }
    
}
