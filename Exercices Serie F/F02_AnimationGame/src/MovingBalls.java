
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
    
    public void removeBall(Point target){
        int i=0;
        while(i!=alBalls.size()&&calculateDistance(new Point((int)alBalls.get(i).getX(),(int) alBalls.get(i).getY()), target)>alBalls.get(i).getRadius()){
            i++;
        }
        if(i!=alBalls.size()){
            alBalls.remove(i);
        }
    }
    
    public double calculateDistance(Point centre, Point target){
        return  Math.round(Math.sqrt(Math.pow(centre.x-target.x, 2)+Math.pow(centre.y-target.y, 2)));
    }

    public void draw(Graphics g)
    {
        // draw the balls
        for(int i=0; i < alBalls.size(); i++)
            alBalls.get(i).draw(g);
       
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
        
    }
}