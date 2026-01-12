
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author SchYv136
 */
public class Angle {
    private double degrees;

    public Angle(double value) {
        degrees=value;
    }
    public double getRadians(){
        return Math.toRadians(degrees);
    }
    public void setRadians(double value){
        degrees=Math.toDegrees(value);
    }
    public void setDegrees(double value){
        degrees=value;
    }
    public double getDegrees(){
        return degrees;
    }
    public double getSin(){
        return Math.sin(getRadians());
    }
    public double getCos(){
        return Math.cos(getRadians());
    }
    public double getTan(){
        return Math.tan(getRadians());
    }
    public void draw(Graphics g, int width, int height){
        double centerX=Math.round(width/2.0);
        double centerY=Math.round(height/2.0);
        double radius=Math.round(Math.min(height, width)/4.0);
        double cos=getCos();
        double sin=getSin();
        double tan=getTan();
        g.setColor(Color.white);
        g.fillRect(0, 0, width-1, height-1);
        //drawing horizontal & vertical line, and the circle
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, (int)centerY, width, (int)centerY);
        g.drawLine((int)centerX, 0, (int)centerX, height);
        g.drawOval((int)(centerX-radius), (int)(centerY-radius), (int)(2*radius), (int)(2*radius));
        //pC is the point on the circle
        Point pC=new Point((int)(centerX+cos*radius), (int)(centerY-sin*radius));
        g.drawLine((int)centerX, (int)(centerY-sin*radius), pC.x, pC.y);
        g.drawLine(pC.x, pC.y, pC.x, (int)centerY);
        //sign is used to determine if the angle is positive or negative
        int sign=(int)(Math.signum(cos));
        //pT is the point on the tangent line
        Point pT=new Point((int)(centerX+radius*sign),(int)(centerY-tan*radius*sign));
        g.drawLine((int)centerX, (int)centerY, pT.x, pT.y);
        //drawing the colored lines
        g.setColor(Color.red);
        g.drawLine((int)centerX, (int)centerY, pC.x, pC.y);
        g.setColor(Color.green);
        g.drawLine((int)centerX, (int)(centerY-sin*radius), (int)centerX, (int)centerY);
        g.setColor(Color.blue);
        g.drawLine((int)centerX, (int)centerY, pC.x, (int) centerY);
        g.setColor(Color.MAGENTA);
        g.drawLine((int)(centerX+radius*sign), (int)centerY, pT.x, pT.y);
        //drawing the text on the panel
        g.setFont(new Font("Courier New", Font.BOLD, 14));
        g.setColor(Color.red);
        g.drawString("Angle (degrees) :"+degrees, 10, 20);
        g.drawString("Angle (radians) :"+getRadians(), 10, 40);
        g.setColor(Color.green);
        g.drawString("Sinus           :"+getSin(), 10, 60);
        g.setColor(Color.BLUE);
        g.drawString("Cosinus         :"+getCos(), 10, 80);
        g.setColor(Color.magenta);
        g.drawString("Tangens         :"+getTan(), 10, 100);
        
    }
    
    
}
