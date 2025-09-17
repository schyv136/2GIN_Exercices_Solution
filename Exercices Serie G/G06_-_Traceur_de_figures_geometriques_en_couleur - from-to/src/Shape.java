
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Shape {

    private Point from;
    private Point to;
    private Color color;
    
    //Construtor needing 4 separate coordinates
    public Shape(int pX1, int pY1, int pX2, int pY2, Color pColor)    {
        from = new Point(pX1,pY1);
        to   = new Point(pX2,pY2);
        color= pColor;
    }

    //Constructor needing two points 
    public Shape(Point pFrom, Point pTo, Color pColor)    {
        from   = pFrom;
        to     = pTo;
        color  = pColor;
    }

    public Point getFrom()              {        return from;       }
    public Point getTo()                {        return to;         }
    public void setFrom(Point pFrom)    {        from = pFrom;      }
    public void setTo(Point pTo)        {        to = pTo;          } 
    
    public void draw(Graphics g)    {
        // draw the line in current color
        g.setColor(color);
    }
    
    @Override
    public String toString() {
       return "("+from.x+","+from.y+") -> ("+to.x+","+to.y+")"; 
    }
    
    public int getLeft() {  
        return Math.min(from.x, to.x);
    }

    public int getTop() {    
        return Math.min(from.y, to.y);
    }

    public int getRight() {  
        return Math.max(from.x, to.x);
    }

    public int getBottom() {    
        return Math.max(from.y, to.y);
    }

    public int getWidth() {  
        return Math.abs(from.x-to.x);
    }

    public int getHeight() {  
        return Math.abs(from.y-to.y);
    }
}
