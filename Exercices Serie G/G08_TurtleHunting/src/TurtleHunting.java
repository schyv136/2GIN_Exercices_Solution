
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author sibcl
 */
public class TurtleHunting {

    private Turtle turtle = null;
    private Crosshair crosshair = null;
    private int shots;
    private int hits;
    private int width;  // width and height of the canvas (Graphics)
    private int height;

    public TurtleHunting(int pWidth, int pHeight) {
        width = pWidth;
        height = pHeight;
        crosshair = new Crosshair(width / 2, height / 2);
        turtle = new Turtle(0, 0, Color.BLACK);

        positionTurtleRandomly();
        shots = 0;
        hits = 0;
    }

    public void fire() {
        shots++;
        if (turtle.intersects(crosshair)) {
            hits++;
            positionTurtleRandomly();
        }
    }

    private void positionTurtleRandomly() {
        turtle.setLocation((int) (Math.random() * (width - turtle.width)),
                (int) (Math.random() * (height - turtle.height)));
    }

    public void moveCrosshairUp() {
        turtle.goDown(10);
    }

    public void moveCrosshairDown() {
        turtle.goUp(10);
    }

    public void moveCrosshairRight() {
        turtle.goLeft(10);
    }

    public void moveCrosshairLeft() {
        turtle.goRight(10);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);
        int side = Math.min(width, height);
        g.fillOval((width - side) / 2, (height - side) / 2, side, side);

        g.setColor(Color.YELLOW);
        g.drawString("Shots: " + shots, 5, 20);

        Turtle turtleIcon = new Turtle(0, 0, Color.YELLOW);
        turtleIcon.setLocation(width - 50, 2);
        turtleIcon.draw(g);

        g.drawString(String.valueOf(hits), width - 20, 20);

        turtle.draw(g);
        crosshair.setLocation(width / 2, height / 2);
        crosshair.draw(g);
    }

}
