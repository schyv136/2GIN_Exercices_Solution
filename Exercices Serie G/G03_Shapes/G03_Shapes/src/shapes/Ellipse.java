package shapes;

import java.awt.Color;
import java.awt.Graphics;
import logic.Shape;

public class Ellipse extends Shape{

    public Ellipse(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
    
    @Override
    public void draw(Graphics g){
        
        g.setColor(super.getColor());
        g.drawOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        
    }
    
}
