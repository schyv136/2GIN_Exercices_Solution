
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created on Jan 14, 2013
 *
 * @author Fred Faber
 * @version 2013-01-14
 */
public class Lines {

    /**
     * liste de lignes
     */
    private ArrayList<Line> alLines = new ArrayList<>();

    public void add(Line pLine) {
        alLines.add(pLine);
    }

    public void draw(Graphics g) {
        // dessiner les lignes
        for (int i = 0; i < alLines.size(); i++) {
            alLines.get(i).draw(g);
        }
    }
}
