
import java.awt.Color;
import java.awt.Graphics;

/**
 * Cette classe représente une boule en mouvement. La classe elle-même connaît
 * les dimensions de son environnement. Elle sait donc se déplacer elle-même. Au
 * lieu de step, xDir et yDir, elle possède deux attributs xStep et yStep du
 * type double qui définissent ses pas en horizontale et en verticale.
 *
 * @author fred faber, robert fisch
 * @version 11/6/2012
 */
public class MovingBall {

    private double x;
    private double y;
    private int radius;

    private double xStep;  // positif <-> droite  ;  négatif <-> gauche 
    private double yStep;  // positif <-> bas     ;  négatif <-> haut 

    public MovingBall(double pX, double pY, int pRadius, double pXStep, double pYStep) {
        x = pX;
        y = pY;
        radius = pRadius;
        xStep = pXStep;
        yStep = pYStep;
    }

    public double getXStep() {
        return xStep;
    }

    public double getYStep() {
        return yStep;
    }

    public void doStep(int width, int height) {
        //Pour éviter que lors d'un rétrécissement du canevas, les balles 
        //restent coincées en-dehors du champ visible, il vaut mieux introduire 
        //4 conditions séparées et surtout ne pas simplement inverser le signe :

        if (x + xStep + radius > width) {
            xStep = -Math.abs(xStep);
        }
        if (x + xStep - radius < 0) {
            xStep = Math.abs(xStep);
        }
        if (y + yStep + radius > height) {
            yStep = -Math.abs(yStep);
        }
        if (y + yStep - radius < 0) {
            yStep = Math.abs(yStep);
        }

        x = x + xStep;
        y = y + yStep;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawOval((int) x - radius,
                (int) y - radius,
                radius * 2,
                radius * 2);
    }
}
