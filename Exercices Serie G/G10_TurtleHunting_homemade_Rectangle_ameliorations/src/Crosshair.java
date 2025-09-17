
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Rectangle;

public class Crosshair extends Rectangle{

    //size of the 'hot' rectangle = 11
    
    public Crosshair(int pX, int pY) { //x,y is the center of the Crosshair
        super(pX-5, pY-5, 11, 11);  //position the 'hot' rectangle around the center!
    }
    
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine(getX()+5,    getY()+5-40, getX()+5,    getY()+5+40);
        g.drawLine(getX()+5-40, getY()+5,    getX()+5+40, getY()+5);
        g.drawOval(getX()+5-10, getY()+5-10, 21, 21);
        g.drawOval(getX()+5-25, getY()+5-25, 51, 51);
        
        //Demo: show Rectangle
        g.setColor(Color.RED);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}
