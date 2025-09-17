
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Ellipse extends Shape  {

    public Ellipse(int pX1, int pY1, int pX2, int pY2, Color pColor) {
        super(pX1, pY1, pX2, pY2, pColor);
    }

    public Ellipse(Point pFrom, Point pTo, Color color) {
        super(pFrom, pTo, color);
    }
    
    @Override
    public void draw(Graphics g) {
        super.draw(g); 
        g.drawOval(getLeft(), getTop(), getWidth(), getHeight());        
    }
    
    @Override
    public String toString() {
       return "Ellipse " + super.toString();
    }
    
}