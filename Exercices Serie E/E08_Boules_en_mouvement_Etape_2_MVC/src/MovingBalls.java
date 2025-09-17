
import java.awt.Graphics;
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
    
    public void doStep(int width, int height)
    {
        for(int i=0; i<alBalls.size();i++)
        {
            MovingBall ball = alBalls.get(i);
            ball.doStep(width, height);
        }
    }

    public void draw(Graphics g)
    {
        // draw the balls
        for(int i=0; i < alBalls.size(); i++)
            alBalls.get(i).draw(g);
    }
}
