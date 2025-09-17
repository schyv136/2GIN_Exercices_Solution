
import java.awt.Color;
import java.awt.Graphics;

public class Shape {

    private int x;
    private int y;
    private Color color;

    public int getX()       {        return x;    }
    public int getY()       {        return y;    }
    public Color getColor() {        return color;    }

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
    }
    
    public void setDimensions(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
    }
}