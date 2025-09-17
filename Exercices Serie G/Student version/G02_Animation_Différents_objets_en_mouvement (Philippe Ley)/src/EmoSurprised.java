
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LeyPh975
 */
public class EmoSurprised extends EmoBase {

    public void drawSurprised(Graphics g, int x, int y, int size) {
        drawBase(g, x, y, size);
        
        g.setColor(Color.BLACK);
        g.fillOval((int) (x - size/8), (int) (y + size/8), size/4, size/4);
    }

}
