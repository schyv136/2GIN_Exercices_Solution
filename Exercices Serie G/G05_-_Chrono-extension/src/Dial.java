
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Georges Kugener
 */
public class Dial {
    
    private int x;
    private int y;
    private int width;
    private int height;
    private int numberOfTicks;
    private int majorTick;
    private int currentTick;

    public Dial(int pX, int pY, int pWidth, int pHeight, int pNumberOfTicks, int pMajorTick) {
        x = pX;
        y = pY;
        width = pWidth;
        height = pHeight;
        numberOfTicks = pNumberOfTicks;
        majorTick = pMajorTick;
        currentTick = 0;
    }

    public int getCurrentTick() {
        return currentTick;
    }

    public void setCurrentTick(int pCurrentTick) {
        currentTick = pCurrentTick;
    }
        
    public void draw(Graphics g)
    {
        // Calculs préliminaires
        
        int radius = Math.min(width, height) / 2;
        int offsetX = x + width / 2 - radius;
        int offsetY = y + height / 2 - radius;
        int xCenter = offsetX + radius;
        int yCenter = offsetY + radius;
        
        // Dessine le cadran
        
        g.setColor(Color.BLACK);
        g.drawOval(offsetX, offsetY, 2*radius, 2*radius);
        
        // Variables utilisées par la suite
        
        Point endPoint;
        Point startPoint;
        double angle;
        
        // Dessine les graduations
        
        int lengthTick = radius / 10;
        int lengthMajorTick = radius / 5;
        for (int i=0; i < numberOfTicks; i++)
        {
            angle = (i / (double)numberOfTicks) * 2*Math.PI;
            if ((majorTick > 0) && (i % majorTick == 0))
                startPoint = new PolarPoint(radius-lengthMajorTick, angle);
            else
                startPoint = new PolarPoint(radius-lengthTick, angle);
            endPoint = new PolarPoint(radius, angle);
            g.drawLine(xCenter + startPoint.x, yCenter + startPoint.y,
                       xCenter + endPoint.x,   yCenter + endPoint.y);
        }
             
        // Fait pointer l'aiguille vers le tic actuel
        
        g.setColor(Color.RED);
        angle = ((double)currentTick / (double)numberOfTicks) * 2*Math.PI;
        endPoint = new PolarPoint(radius-lengthTick-1, angle);
        g.drawLine(xCenter, yCenter, xCenter + endPoint.x, yCenter - endPoint.y);
    }

}
