
/**
 *
 * @author robertfisch
 */
public class MovingObject {

    private int x;
    private int y;
    
    private int stepX = 0;
    private int stepY = 0;

    public MovingObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStepX() {
        return stepX;
    }

    public void setStepX(int stepX) {
        this.stepX = stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public void setStepY(int stepY) {
        this.stepY = stepY;
    }

    public void move() {
        x += stepX;
        y += stepY;
    }
}
