package model;

/**
 * @author robertfisch, Fred Faber
 */
public abstract class MovingObject {

    protected int x;
    protected int y;
    
    protected int stepX = 0;
    protected int stepY = 0;

    public MovingObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        x += stepX;
        y += stepY;
    }

    //Amélioration
    public abstract void speedUp();
}
