
import java.awt.Graphics;

/**
 * Emoticon sad :(
 * @author fred faber
 */
public class EmoSad extends Emoticon {

    private int timeToLive;  //in ms
    private int speed;      //in ms (<=> timer interval)

    public int getTimeToLive() {
        return timeToLive;
    }    
    
    public EmoSad(double pX, double pY, int pRadius, double pXStep, double pYStep, 
                  int timeToLive, int speed) {
        super(pX, pY, pRadius, pXStep, pYStep);
        this.timeToLive=timeToLive;
        this.speed=speed;
    }
  
    
    public void doStep(int width, int height)
    {
        super.doStep(width, height);
        timeToLive = timeToLive-speed;
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
                   (int)(  radius*2*0.5),  0, 180);
        g.drawString(timeToLive+"",(int)(x-radius/3),(int)(y+4*radius/3));
    }
    
}
