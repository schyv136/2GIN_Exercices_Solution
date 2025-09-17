
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {

    public Rectangle(int pX1, int pY1, int pX2, int pY2, Color pColor) {
        super(pX1, pY1, pX2, pY2, pColor);
    }

    public Rectangle(Point pFrom, Point pTo, Color pColor) {
        super(pFrom, pTo, pColor);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g); 
        g.drawRect(getLeft(), getTop(), getWidth(), getHeight());        
    }
 
    @Override
    public String toString() {
       return "Rectangle " + super.toString();
    }

}
