package shapes;

import java.awt.Color;
import java.awt.Graphics;
import logic.Shape;

public class Triangle extends Shape{

    public Triangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
    
    @Override
    public void draw(Graphics g){
        
        g.setColor(super.getColor());
        
        g.drawLine(x, y+height, x+width, y+height);
        g.drawLine(x, y+height, x+width/2, y);
        g.drawLine(x+width, y+height, x+width/2, y);
        
    }
    
}
