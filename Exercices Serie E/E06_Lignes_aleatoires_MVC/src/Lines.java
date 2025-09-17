
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Georges Kugener
 */
public class Lines {
    
    private ArrayList<Line> alLines = new ArrayList<>();

    public void add(Line line) {
        alLines.add(line);
    }

    public void draw(Graphics g)
    {
        for (int i = 0; i < alLines.size(); i++)
            alLines.get(i).draw(g);
    }          
}