
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author FisRo156
 */
public class Squares {

    private ArrayList<Square> alSquares = new ArrayList<>();

    public boolean add(Square e) {
        return alSquares.add(e);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < alSquares.size(); i++) {
            alSquares.get(i).draw(g);
        }
    }

    public void clear() {
        alSquares.clear();
    }

}
