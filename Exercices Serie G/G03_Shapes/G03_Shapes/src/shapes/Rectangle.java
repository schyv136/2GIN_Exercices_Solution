package shapes;

import java.awt.Color;
import java.awt.Graphics;
import logic.Shape;

public class Rectangle extends Shape{

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
    
    @Override
    public void draw(Graphics g){
        
        g.setColor(super.getColor());
        g.drawRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        
    }
    
}
