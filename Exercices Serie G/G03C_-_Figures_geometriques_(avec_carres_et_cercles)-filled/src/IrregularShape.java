
import java.awt.Color;

/**
 *
 * @author fred
 */
public class IrregularShape extends Shape {

    private int width;
    private int height;

    public IrregularShape(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void setDimensions(int x, int y, int width, int height) {
        super.setDimensions(x, y, width, height);
        this.height = height;
        this.width = width;
    }

}
