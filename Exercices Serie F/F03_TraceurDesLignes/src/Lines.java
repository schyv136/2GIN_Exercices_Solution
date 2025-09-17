
import java.awt.Graphics;
import java.util.ArrayList;

public class Lines {

    ArrayList<Line> alLines = new ArrayList<>();

    public void draw(Graphics g) {
        for (int i = 0; i < getSize(); i++) {
            alLines.get(i).draw(g);
        }
    }
    
    public void add(Line line){
        alLines.add(line);
    }
    
    public void clear(){
        alLines.clear();
    }

    public Object[] toArray(){
        return alLines.toArray();
    }
    
    public int getSize(){
        return alLines.size();
    }

    public ArrayList<Line> getAlLines() {
        return alLines;
    }
    
}
