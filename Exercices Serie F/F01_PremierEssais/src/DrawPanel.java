import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class DrawPanel extends javax.swing.JPanel {

    Graphics g;
    
    public DrawPanel() {
        initComponents();

        g = getGraphics();
        
    }
    
    
    public void drawPointEnfonce(Point point){
        g = getGraphics();
        g.setColor(Color.red);
        g.drawLine(point.x, point.y, point.x, point.y);
        g.drawOval(point.x-2, point.y-2, 4, 4);
    }

    public void drawPointRelache(Point point){
        g = getGraphics();
        g.setColor(Color.blue);
        g.drawLine(point.x, point.y, point.x, point.y);
        g.drawOval(point.x-2, point.y-2, 4, 4);
    }

    public void drawPointDragged(Point point){
        g = getGraphics();
        g.setColor(Color.black);
        g.drawLine(point.x, point.y, point.x, point.y);
    }

    public void drawPointMoved(Point point){
        g = getGraphics();
        g.setColor(Color.green);
        g.drawLine(point.x, point.y, point.x, point.y);
    }

    public void drawLine(Point point1, Point point2){
        g = getGraphics();
        g.setColor(Color.red);
        g.drawLine(point1.x, point1.y, point2.x, point2.y);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
