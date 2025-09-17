
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author FabFr
 */
public class Rectangle {

    private Point from;
    private Point to;
    private Color color;
    
    //Construtor needing 4 separate coordinates
    public Rectangle(int pX1, int pY1, int pX2, int pY2, Color pColor)
    {
        from  = new Point(pX1,pY1);
        to    = new Point(pX2,pY2);
        color = pColor;
    }

    //Constructor needing two points 
    public Rectangle(Point pFrom, Point pTo, Color pColor)
    {
        from  = pFrom;
        to    = pTo;
        color = pColor;
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
        // draw the line in current color
        g.setColor(color);
        g.drawRect(Math.min( from.x,  to.x ),
                   Math.min( from.y,  to.y ),
                   Math.abs( from.x - to.x ),   
                   Math.abs( from.y - to.y ));
    }
    
    @Override
    public String toString() {
       return "rect(" + from.x + "," + from.y + ") -> (" + to.x + "," + to.y + ")"; 
    }
}
