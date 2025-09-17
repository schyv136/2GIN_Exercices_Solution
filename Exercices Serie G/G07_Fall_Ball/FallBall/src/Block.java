
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author robertfisch
 */
public class Block extends MovingObject {

    private int width;
    private int height;

    public Block(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;

        setStepY(-3);
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(getX(), getY(), width, height);
        g.setColor(Color.BLACK);
        g.drawRect(getX(), getY(), width, height);
    }

    public boolean isTouching(Ball ball) {
        //version 1: contrôle tout l'arc inférieur de la balle
//        boolean result = false;
//        for(int i=0; i<180; i++)
//        {
//            int cx = (int) (ball.getX()+ball.getRadius()*Math.cos(i/180.*Math.PI));
//            int cy = (int) (ball.getY()+ball.getRadius()*Math.sin(i/180.*Math.PI));
//            //System.out.println(ball.getX()+" --> "+cx+" --"+i);
//            if(getX()<=cx && cx<=getX()+width &&
//               getY()<=cy && cy<=getY()+height)
//            {
//                result = true;
//            }
//        }
//        return result;

        //Version 2 (simplifiée): contrôle uniquement le point inférieur de la balle
        int cx = ball.getX();
        int cy = ball.getY() + ball.getRadius();
        //System.out.println(ball.getX()+" --> "+cx+" --"+i);
        return (getX() <= cx && cx <= getX() + width
             && getY() <= cy && cy <= getY() + height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
