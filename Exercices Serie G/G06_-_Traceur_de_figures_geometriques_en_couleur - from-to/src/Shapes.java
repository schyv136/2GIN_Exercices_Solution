
import java.awt.Graphics;
import java.util.ArrayList;

public class Shapes {
    
    private ArrayList<Shape> alShapes = new ArrayList<Shape>();    
     
    public void add(Shape l) {
        alShapes.add(l);
    }
    
    public void clear() {
        alShapes = new ArrayList<Shape>();
    }
     
    public void draw(Graphics g) {
        for(int i=0 ; i<alShapes.size() ; i++)  {
            alShapes.get(i).draw(g);
        }
    }   
        
    public Object[] toArray() {
        return alShapes.toArray();
    }
}
