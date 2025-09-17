
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sibcl, fred faber
 */
public class TurtleHunting {
    
    private Turtle turtle = null;
    private Crosshair crosshair = null;
    private int bulletsLeft;
    private int turtlesLeft;
    private int width;  // width and height of the canvas (Graphics)
    private int height;
     
    private boolean gameOver=false;
    
    public TurtleHunting(int pWidth, int pHeight) {
        width = pWidth;
        height = pHeight;
        crosshair = new Crosshair(width/2, height/2);
        turtle = new Turtle(0,0, new Color(100, 200,0));
        
        positionTurtleRandomly();
        bulletsLeft = 10;
        turtlesLeft = 5;
    }
    
    public void fire() {
        if (!gameOver) {
            bulletsLeft--;
            if (turtle.intersects(crosshair)) {
                turtlesLeft--;
                positionTurtleRandomly();
            }
            if (bulletsLeft <= 0 || turtlesLeft <= 0) {
                gameOver = true;
            }
        }
    }
    
    private void positionTurtleRandomly()
    {
        turtle.setLocation((int)(Math.random()*(width -turtle.getWidth())),
                           (int)(Math.random()*(height-turtle.getHeight())));
    }

    public void makeTurtleMoveRandomly() {
        turtle.makeRandomMove();
    }
    
    

    public void moveCrosshairUp()
    {
        turtle.goDown(10);
    }
    
    public void moveCrosshairDown()
    {
        turtle.goUp(10);
    }
    
    public void moveCrosshairRight()
    {
        turtle.goLeft(10);
    }
    
    public void moveCrosshairLeft()
    {
        turtle.goRight(10);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);
        int side = Math.min(width,height);
        g.fillOval((width-side)/2, (height-side)/2, side, side);
        
        g.setColor(Color.YELLOW);
        g.drawString("Bullets left: "+bulletsLeft, 5, 20);
        
        Turtle turtleIcon = new Turtle(0,0, Color.YELLOW);
        turtleIcon.setLocation(width-50, 2);
        turtleIcon.draw(g);
        
        g.drawString(String.valueOf(turtlesLeft), width-20, 20);
   
        if (!gameOver) turtle.draw(g);
        
        crosshair.setLocation(width/2, height/2);
        crosshair.draw(g);
        
        if (gameOver) {
            g.setColor(Color.red);
            if (turtlesLeft>0) 
                g.drawString("You lose this game!", width/2-55, height/4);
            else 
                g.drawString("You win this game!", width/2-55, height/4);
        }
    }

    public void moveCrosshairBy(int diffX, int diffY) {
        turtle.moveBy(diffX, diffY);
        //System.out.println(diffX+":"+diffY);
    }
    
}
