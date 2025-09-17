
import java.awt.Color;

/**
 * @author fred
 */
public class RegularShape extends Shape {

    private int side;

    public int getSide() {
        return side;
    }

    public RegularShape(int x, int y, int side, Color color) {
        super(x, y, color);
        this.side = side;
    }

    @Override
    public void setDimensions(int x, int y, int width, int height) {
        super.setDimensions(x, y, width, height);
        side = Math.min(width, height);
    }

}
