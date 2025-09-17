
import java.awt.Graphics;

/**
 *
 * @author Georges Kugener
 */
public class AnalogChronometer extends Chronometer{

    /* 
    public AnalogChronometer() 
    {
        super();
    } 
    */


    @Override
    public void draw(Graphics g, int pWidth, int pHeight) {
        // super.draw(g, pWidth, pHeight);
        
        // Créer et afficher un cadran pour les secondes
        Dial secondsDial = new Dial(5+(pWidth-5)/8, 5, (pWidth-5)*3/4, (pHeight-5)*3/4, 60, 5);
        secondsDial.setCurrentTick(getSeconds());
        secondsDial.draw(g);
        
        // Créer et afficher un cadran pour les minutes
        int smallDialWidth = pWidth / 4;
        int smallDialHeight = pHeight / 4;
        
        Dial minutesDial = new Dial(5, pHeight-5-smallDialHeight, smallDialWidth, smallDialHeight, 60, 5);
        minutesDial.setCurrentTick(getMinutes());
        minutesDial.draw(g);
        
        // Créer et afficher un cadran pour les 10èmes de seondes
        Dial tenthSecondsDial = new Dial(pWidth-5-smallDialWidth, pHeight-5-smallDialHeight, smallDialWidth, smallDialHeight, 10, 1);
        tenthSecondsDial.setCurrentTick(getTenthsOfSeconds());        
        tenthSecondsDial.draw(g);
    }
}
