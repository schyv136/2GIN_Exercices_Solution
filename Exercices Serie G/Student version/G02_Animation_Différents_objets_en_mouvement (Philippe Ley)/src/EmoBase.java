
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
public class EmoBase {
    
    public void drawBase(Graphics g, int x, int y , int size){
        g.setColor(Color.YELLOW);
        g.fillOval(x - size/2, y - size/2, size, size);
        
        g.setColor(Color.BLUE);
        g.fillOval((int) (x - (0.3*size)-1), y - size/4, size/4, size/4);
        g.fillOval(x + size/15, y - size/4, size/4, size/4);
        
        g.setColor(Color.WHITE);
        g.fillOval((int) (x - (0.3*size)), y - size/4 + 1, size/4 - 2, size/4 - 2);
        g.fillOval(x + size/15 + 1, y - size/4 + 1, size/4 - 2, size/4 - 2);
        
        g.setColor(Color.BLACK);
        g.fillOval((int) (x - (0.24*size)), (int) (y - (0.14*size)), size/8, size/8);
        g.fillOval((int) (x + (0.135*size)), (int) (y - (0.14*size)), size/8, size/8);
    }
    
}
