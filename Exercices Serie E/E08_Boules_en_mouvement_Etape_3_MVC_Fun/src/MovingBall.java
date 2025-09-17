
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Cette classe représente une boule en mouvement. La classe elle-même connaît
 * les dimensions de son environnement. Elle sait donc se déplacer elle-même. Au
 * lieu de step, xDir et yDir, elle possède deux attributs xStep et yStep du
 * type double qui définissent ses pas en horizontale et en verticale.
 *
 * @author fred faber
 * @version 2015
 */
public class MovingBall {

    private double x;
    private double y;
    private int radius;
    private int r, g, b;

    private double xStep;  // positif <-> droite  ;  négatif <-> gauche 
    private double yStep;  // positif <-> bas     ;  négatif <-> haut 

    public MovingBall(double pX, double pY, int pRadius, double pXStep, double pYStep) {
        x = pX;
        y = pY;
        radius = pRadius;
        xStep = pXStep;
        yStep = pYStep;
        r = 128 + (int) (Math.random() * 128); //use light colors only
        g = 128 + (int) (Math.random() * 128);
        b = 128 + (int) (Math.random() * 128);
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

    public void draw(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(1.1f));
        for (int i = 0; i < 20; i++) {
            g2d.setColor(new Color(r, g, b, 200 - 10 * i));
            g2d.drawOval((int) x - radius + i,
                    (int) y - radius + i,
                    radius * 2 - 2 * i,
                    radius * 2 - 2 * i);
            g2d.setColor(new Color(255, 255, 255, 32));
            g2d.fillRect((int) (x - radius * 3.2 / 6 + x / 220), (int) (y - radius * 3.2 / 6 + x / 220), 15, 10);
            g2d.setColor(new Color(255, 255, 200, 16));
            g2d.fillRect((int) (x - radius * 3.2 / 6 + x / 100) + 10, (int) (y - radius * 3.2 / 6 + y / 100) + 6, 15, 10);
        }

    }
}
