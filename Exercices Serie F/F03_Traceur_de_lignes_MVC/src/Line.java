
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author FisRo156
 */
public class Line {

    private Point from;
    private Point to;
    
    public Line(int pX1, int pY1, int pX2, int pY2)
    {
        from = new Point(pX1,pY1);
        to   = new Point(pX2,pY2);
    }

    public Line(Point pFrom, Point pTo)
    {
        from = pFrom;
        to   = pTo;
    }

    public Point getFrom() {
        return from;
    }

   public void setFrom(Point pFrom) {
        from = pFrom;
    }

    public Point getTo() {
        return to;
    }

   public void setTo(Point pTo) {
        to = pTo;
    } 
    
    public void draw(Graphics g)
    {
        // draw the line in black
        g.setColor(Color.BLACK);
        g.drawLine(getFrom().x, getFrom().y, getTo().x,   getTo().y);
    }
    
    @Override
    public String toString() {
       return "(" + from.x + "," + from.y + ") -> (" + to.x + "," + to.y + ")"; 
    }
}