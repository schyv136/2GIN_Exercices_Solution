
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
public class EmoTongue extends EmoBigSmile {

    public void drawTongue(Graphics g, int x, int y, int size) {
        drawBigSmile(g, x, y, size);

        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.PINK);
        g.fillRect((int) (x - (0.25*size)/2), (int) (y - (0.25*size)+size/2), size/4, size/8);
        g2.fill(new Arc2D.Double(x - (0.25*size)/2, y - (0.125*size)+size/3, size/4, size/4, 0, -180, Arc2D.OPEN));
    }

}
