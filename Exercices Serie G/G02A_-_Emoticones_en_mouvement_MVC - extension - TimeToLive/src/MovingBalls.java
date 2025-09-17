
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Georges Kugener, fred faber
 */
public class MovingBalls {

    private ArrayList<MovingBall> alBalls = new ArrayList<>();

    public void add(MovingBall pBall) {
        alBalls.add(pBall);
    }
    
    public void doStep(int width, int height)
    {
        for(int i=0; i<alBalls.size();i++)
        {
            MovingBall ball = alBalls.get(i);
            ball.doStep(width, height);
        }
        //get rid of dead Sad Smileys
        for(int i = alBalls.size()-1; i>=0; i--)
            if (alBalls.get(i) instanceof EmoSad)                   //!!
                if (((EmoSad)alBalls.get(i)).getTimeToLive() <= 0)  //!!
                    alBalls.remove(i);
            }

    public void draw(Graphics g)
    {
        // draw the balls
        for(int i=0; i < alBalls.size(); i++)
            alBalls.get(i).draw(g);
        /*
        // draw lines between the balls
        for(int i=0; i < alBalls.size(); i++)
        {
            MovingBall fromBall = alBalls.get(i);
            MovingBall toBall   = alBalls.get((i+1) % alBalls.size());
            g.setColor(Color.RED);
            g.drawLine((int)fromBall.getX(),
                       (int)fromBall.getY(),
                       (int)toBall.getX(),
                       (int)toBall.getY());
        }
         */
        
    }
}
