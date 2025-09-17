
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Georges Kugener
 */
public class Chronometer {

    private int time = 0; // temps en 10èmes de secondes
    
 /*   public Chronometer()
    {
    } */
    
    public int getTime() 
    {
        return time;
    }

    public void setTime(int pTime) 
    {
        time = pTime;
    }
    
    public int getMinutes()
    {
        return time / 600;
    }
    
    public int getSeconds()
    {
        return time % 600 / 10;
    }
    
    public int getTenthsOfSeconds()
    {
        return time % 600 % 10;
    }
            
    public void nextTick()
    {
        time++;
    }
    
    public void draw(Graphics g, int pWidth, int pHeight)
    {
        g.setColor(Color.BLACK);
        g.drawString(getMinutes()+" min "+getSeconds()+" sec "+getTenthsOfSeconds()+" sec/10", pWidth/2-60, pHeight-5);
    }
}
