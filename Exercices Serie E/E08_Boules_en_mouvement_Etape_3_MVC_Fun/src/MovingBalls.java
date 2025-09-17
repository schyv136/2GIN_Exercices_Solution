
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Georges Kugener
 */
public class MovingBalls {

    private ArrayList<MovingBall> alBalls = new ArrayList<>();

    public void add(MovingBall pBall) {
        alBalls.add(pBall);
    }
    
    public void doStep(int width, int height)    {
        for(int i=0; i<alBalls.size();i++)
        {
            MovingBall ball = alBalls.get(i);
            ball.doStep(width, height);
        }
    }

    public void draw(Graphics2D g)    {
        // draw the balls
        for(int i=0; i < alBalls.size(); i++)
            alBalls.get(i).draw(g);
       
        // draw lines between the balls
//        for(int i=0; i < alBalls.size(); i++)
//        {
//            MovingBall fromBall = alBalls.get(i);
//            MovingBall toBall   = alBalls.get((i+1) % alBalls.size());
//            g.setColor(Color.RED);
//            g.drawLine((int)fromBall.getX(),
//                       (int)fromBall.getY(),
//                       (int)toBall.getX(),
//                       (int)toBall.getY());
//        }
        
    }
}
