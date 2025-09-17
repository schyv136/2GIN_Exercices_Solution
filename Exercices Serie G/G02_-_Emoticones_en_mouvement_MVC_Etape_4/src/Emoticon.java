
import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstract class, base of all Emoticons
 * @author fred faber
 */
public abstract class Emoticon extends MovingBall {

    public Emoticon(double pX, double pY, int pRadius, double pXStep, double pYStep) {
        super(pX, pY, pRadius, pXStep, pYStep);
    }
  
    @Override
    public void draw (Graphics g) {
        double x = getX();
        double y = getY();
        int radius = getRadius();
        //Disk
        g.setColor(Color.YELLOW);
        g.fillOval((int)x-radius,
                   (int)y-radius,
                    radius*2,
                    radius*2);
        //Eyes
        g.setColor(Color.WHITE);
        //left eye part1 - background
        g.fillOval((int)(x-radius*5/8),  
                   (int)(y-radius*4/8),
                   (int)(radius/2),
                   (int)(radius/2));
        //right eye part1 - background
        g.fillOval((int)(x+radius*1/8),
                   (int)(y-radius*4/8),
                   (int)(radius/2),
                   (int)(radius/2));
        g.setColor(Color.BLUE);
        //left eye part2 - iris
        g.fillOval((int)(x-radius*5/8+radius*2/16),
                   (int)(y-radius*4/8+radius*3/16),
                   (int)(radius/4),
                   (int)(radius/4));
        //right eye part2 - iris
        g.fillOval((int)(x+radius*1/8+radius*2/16),
                   (int)(y-radius*4/8+radius*3/16),
                   (int)(radius/4),
                   (int)(radius/4));
        g.setColor(Color.DARK_GRAY);
        //left eye part3: border
        g.drawOval((int)(x-radius*5/8),
                   (int)(y-radius*4/8),
                   (int)(radius/2),
                   (int)(radius/2));
        //right eye part3
        g.drawOval((int)(x+radius*1/8),
                   (int)(y-radius*4/8),
                   (int)(radius/2),
                   (int)(radius/2));  
        //color is still dark_gray...
    }
    
}
