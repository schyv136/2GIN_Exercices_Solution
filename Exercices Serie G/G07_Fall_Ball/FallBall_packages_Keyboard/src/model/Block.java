package model;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author robertfisch, Fred Faber
 */
public class Block extends MovingObject {

    //(x,y) coordinates <=> upper left corner of the block
    protected int width;
    protected int height;

    public Block(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
        stepY = -3;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(0, 200, 0, 180));
        g.fillRect(x, y, width, height);
        g.setColor(new Color(0, 150, 0, 150)); //shadow
        g.drawRect(x + 1, y + 1, width, height);
        
    }

    public boolean isTouching(Ball ball) {
        //version 1: contrôle tout l'arc inférieur de la balle
//        boolean result = false;
//        for(int i=0; i<180; i++)
//        {
//            int cx = (int) (ball.x+ball.getRadius()*Math.cos(i/180.*Math.PI));
//            int cy = (int) (ball.y+ball.getRadius()*Math.sin(i/180.*Math.PI));
//            //System.out.println(ball.x+" --> "+cx+" --"+i);
//            if(x<=cx && cx<=x+width &&
//               y<=cy && cy<=y+height) {
//                result = true;
//            }
//        }
//        return result;
         
        //Version 2 (simplifiée): contrôle uniquement le point inférieur de la balle
        int cx = ball.x;
        int cy = ball.y + ball.getRadius();
        //System.out.println(ball.x+" --> "+cx+" --"+i);
        return   x <= cx && cx <= x + width
              && y <= cy && cy <= y + height;
    }

    public void speedUp() {
        stepY--;
    }
}
