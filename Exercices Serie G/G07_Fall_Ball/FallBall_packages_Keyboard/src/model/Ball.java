package model;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author robertfisch, modif. Fred Faber
 */
public class Ball extends MovingObject {

    //(x,y) coordinates <=> center of the ball
    private int radius;
    private int ballSpeedX = 10; //step to use when moving

    public Ball(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
        stepY = 5;
    }

    public void move(int width) {
        super.move();
        if (x < radius) {
            x = radius; //balle touche à gauche
        } else if (x + radius > width) {
            x = width - radius; //balle touche à droite
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g.setColor(new Color(150,0,0)); //shadow
        g.drawOval(x - radius + 1, y - radius + 1, 2 * radius, 2 * radius);
    }

    public int getRadius() {
        return radius;
    }

    //these methods are better defined inside class Ball
    public void stop() {
        stepX = 0;
    }

    public void left() {
        stepX = -ballSpeedX;
    }

    public void right() {
        stepX = ballSpeedX;
    }

    public void speedUp() {
        ballSpeedX++;
    }
}