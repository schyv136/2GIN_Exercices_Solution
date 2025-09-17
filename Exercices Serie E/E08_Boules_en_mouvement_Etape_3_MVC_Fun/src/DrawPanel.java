
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


/*
 * DrawPanel.java
 * @author fred faber
 */
public class DrawPanel extends javax.swing.JPanel
{
    private MovingBalls balls;

    /** Creates new form DrawPanel */
    public DrawPanel()
    {
        initComponents();
    }

    public void setBalls(MovingBalls pBalls) {
        balls = pBalls;
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {       
//        // clean the background
//        g.setColor(new Color(0,255,0,0));
//        g.fillRect(0,0,getWidth(),getHeight());    
        
        //TOO SLOW!
        Graphics2D g2d = (Graphics2D)g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
//                        RenderingHints.VALUE_ANTIALIAS_ON);;
        
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
        
        // draw the balls
        if (balls != null)
            balls.draw(g2d);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}