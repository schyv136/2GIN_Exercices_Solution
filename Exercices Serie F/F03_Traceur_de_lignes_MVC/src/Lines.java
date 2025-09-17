
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Cette classe sait gérer et dessiner une liste de lignes
 * @author Fabfr
 */
public class Lines {
    private ArrayList<Line> alLines = new ArrayList<Line>();    
     
    public void add(Line l) {
        alLines.add(l);
    }
    
    public void clear() {
        alLines.clear();
    }
     
    public void draw(Graphics g) {
        // draw the alLines
        for(int i = 0 ; i < alLines.size() ; i++)  {
            alLines.get(i).draw(g);
        }
    }   
        
    public Object[] toArray() {
        return alLines.toArray();
    }
}