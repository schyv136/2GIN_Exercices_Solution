
import java.awt.Graphics;

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
        return Math.sin(degrees);
    }
    public double getCos(){
        return Math.cos(degrees);
    }
    public double getTan(){
        return Math.tan(degrees);
    }
    public void draw(Graphics g, int width, int height){
        
    }
    
    
}
