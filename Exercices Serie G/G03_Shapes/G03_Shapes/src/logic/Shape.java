package logic;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
    
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color = Color.yellow;
    
    public Shape(int x, int y, int width, int height, Color color) {
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        if(width<0){
            width = -width;
            x -= width;
        }
        if(height<0){
            height = -height;
            y -= height;
        }
        
        if(color == null){
            int colorInt = (int) ((Math.random() * (3 - 1+1)) + 1);
            
            switch(colorInt){
                case 1:
                    this.color = Color.red;
                    return;
                case 2:
                    this.color = Color.green;
                    return;
                case 3:
                    this.color = Color.blue;
                    return;
                default:
                    this.color = Color.black;
                    return;
            }
            
        }else{
            this.color = color;
        }
    }
    
    public void draw(Graphics g){
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }
    
}
