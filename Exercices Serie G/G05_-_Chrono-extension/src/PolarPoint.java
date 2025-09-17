
import java.awt.Point;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Georges Kugener
 */
public class PolarPoint extends Point
{
    public PolarPoint(double pRadius, double pAngle) 
    {
        super((int)(Math.sin(pAngle)*pRadius), (int)(Math.cos(pAngle)*pRadius));
    }
}
