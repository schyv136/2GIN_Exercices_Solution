
import java.awt.Graphics;

/**
 * Emoticon sad :(
 * @author fred faber
 */
public class EmoSad extends Emoticon {

    public EmoSad(double pX, double pY, int pRadius, double pXStep, double pYStep) {
        super(pX, pY, pRadius, pXStep, pYStep);
    }
  
    @Override
    public void draw (Graphics g) {
        super.draw(g);
        double x = getX();
        double y = getY();
        int radius = getRadius();
        g.drawArc( (int)(x-radius*0.5),
                   (int)(y+radius*0.25),
                   (int)(  radius*2*0.5),
                   (int)(  radius*2*0.5),
                    0, 180);
    }
    
}
