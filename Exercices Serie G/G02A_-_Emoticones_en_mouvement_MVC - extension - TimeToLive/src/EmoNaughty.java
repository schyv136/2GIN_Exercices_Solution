
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Georges Kugener, fred faber
 */
public class EmoNaughty extends Emoticon {
    
     boolean tongueOut = false;
     int counter = (int)(Math.random()*10);

    public EmoNaughty(double pX, double pY, int pRadius, double pXStep, double pYStep) {
        super(pX, pY, pRadius, pXStep, pYStep);
    }
  
    @Override
    public void draw (Graphics g) {
        super.draw(g);
        double x = getX();
        double y = getY();
        int radius = getRadius();
        g.drawLine( (int)(x-radius*0.5),
                   (int)(y+radius*0.25),
                   (int)(x+radius*0.5),
                   (int)(y+radius*0.25));
        if (tongueOut)
        {
            g.setColor(Color.PINK);
            g.fillArc((int)(x-radius*0.3),
                      (int)(y-radius*0.25),
                      (int)(radius*0.6),
                      (int) (radius),
                        0, -180);
        }
    }

    @Override
    public void doStep(int width, int height) {
        super.doStep(width, height);
        counter++;
        if (counter >= 5)
        {
            tongueOut = !tongueOut;
            counter = 0;
        }
    }
    
    
}
