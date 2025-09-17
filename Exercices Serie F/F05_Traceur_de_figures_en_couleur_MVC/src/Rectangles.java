
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Cette classe sait gérer et dessiner une liste de rectangles
 * @author Fabfr
 */
public class Rectangles {
    private ArrayList<Rectangle> alRectangles = new ArrayList<>();    
     
    public void add(Rectangle r) {
        alRectangles.add(r);
    }
    
    public void clear() {
        alRectangles.clear();
    }
     
    public void draw(Graphics g) {
        // draw the alRectangles
        for(int i = 0 ; i < alRectangles.size() ; i++)  {
            alRectangles.get(i).draw(g);
        }
    }   
        
    public Object[] toArray() {
        return alRectangles.toArray();
    }
}
