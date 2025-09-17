
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LeyPh975
 */
public class EmoSmile extends EmoBase {

    public void drawSmile(Graphics g, int x, int y, int size) {
        drawBase(g, x, y, size);

        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g2.draw(new Arc2D.Double(x - (0.25*size), y - (0.125*size), size/2, size/2, 0, -180, Arc2D.OPEN));
    }

}
