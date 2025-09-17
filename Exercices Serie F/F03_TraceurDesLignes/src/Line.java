
import java.awt.Graphics;
import java.awt.Point;

public class Line {

    private Point from;
    private Point to;

    public Line(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    public Line(int fromX, int fromY, int toX, int toY) {
        this.from = new Point(fromX, fromY);
        this.to = new Point(toX, toY);
    }

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

    public void setFrom(Point from) {
        this.from = from;
    }

    public void setTo(Point to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Line{" + "from=" + from + ", to=" + to + '}';
    }
    
    public void draw(Graphics g) {
        g.drawLine(from.x, from.y, to.x, to.y);
    }

}
