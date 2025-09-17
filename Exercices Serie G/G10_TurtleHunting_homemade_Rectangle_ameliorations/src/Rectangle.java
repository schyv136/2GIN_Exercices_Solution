/**
 * @author FabFr, FasFr
 */
public class Rectangle {

    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    
    /**
     * Moves this Rectangle to the specified location.
     */
    public void setLocation(int px, int py) {
        x = px;
        y = py;
    }

    /**
     * Checks whether or not this Rectangle contains the point at the specified
     * location (x,y).
     */
    public boolean contains(int px, int py) { //contains a point?
        return px >= x && px <= x + width
            && py >= y && py <= y + height;
    }

    /**
     * Checks whether or not this Rectangle entirely contains the other
     * Rectangle.
     */
    public boolean contains(Rectangle other) { //contains other rectangle?
        return  contains(other.x, other.y) && 
                contains(other.x + other.width, other.y) && //not necessary...
                contains(other.x, other.y + other.height)   && //not necessary...
                contains(other.x + other.width, other.y + other.height);
    }

    /**
     * Determines whether or not this Rectangle and the specified Rectangle
     * intersect.
     * http://leetcode.com/2011/05/determine-if-two-rectangles-overlap.html
     */
    public boolean intersects(Rectangle other) {
        return !(x + width < other.x  || x > other.x + other.width
              || y + height < other.y || y > other.y + other.height);
    }

    /**
     * Variante Determines whether or not this Rectangle and the specified
     * Rectangle intersect.
     * http://stackoverflow.com/questions/14616829/java-method-to-find-the-rectangle-that-is-the-intersection-of-two-rectangles-usi
     */
    public boolean intersects2(Rectangle other) {
        int xmin = Math.max(x, other.x);
        int xmax1 = x + width;
        int xmax2 = other.x + other.width;
        int xmax = Math.min(xmax1, xmax2);
        if (xmax > xmin) {
            int ymin = Math.max(y, other.y);
            int ymax1 = y + height;
            int ymax2 = other.y + other.height;
            int ymax = Math.min(ymax1, ymax2);
            if (ymax > ymin) {
                return true;
            }
        }
        return false;
    }

}
