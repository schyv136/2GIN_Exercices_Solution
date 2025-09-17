
import java.awt.Graphics;

/**
 * Emoticon surprised :o
 * @author fred faber
 */
public class EmoSurprised extends Emoticon {

    public EmoSurprised(double pX, double pY, int pRadius, double pXStep, double pYStep) {
        super(pX, pY, pRadius, pXStep, pYStep);
    }
  
    @Override
    public void draw (Graphics g) {
        super.draw(g);
        double x = getX();
        double y = getY();
        int radius = getRadius();
        g.fillOval( (int)(x-radius*0.25),
                    (int)(y+radius*0.25),
                    (int)(  radius*2*0.25),
                    (int)(  radius*2*0.25));
    }
    
}
