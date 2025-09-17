
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author FabFr297
 */
public class Shapes {

    private ArrayList<Shape> alShapes = new ArrayList<>();

    public Object[] toArray() {
        return alShapes.toArray();
    }

    public Shape get(int index) {
        return alShapes.get(index);
    }

    public boolean add(Shape e) {
        return alShapes.add(e);
    }

    public void clear() {
        alShapes.clear();
    }

    public void draw(Graphics g) {
        for (int i = 0; i < alShapes.size(); i++) {
            alShapes.get(i).draw(g);
        }
    }

}
