package logic;

import java.awt.Graphics;
import java.util.ArrayList;

public class Shapes {
 
    private ArrayList<Shape> alShapes = new ArrayList<>();
    
    public void addShape(Shape s){
        alShapes.add(s);
    }
    
    public int size(){
        return alShapes.size();
    }
    
    public void draw(Graphics g){
        for(int i = 0; i < size(); i++){
            alShapes.get(i).draw(g);
        }
    }
    
}
