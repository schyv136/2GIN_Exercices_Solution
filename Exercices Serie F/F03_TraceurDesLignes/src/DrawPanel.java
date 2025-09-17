
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class DrawPanel extends javax.swing.JPanel {

    Lines lines = new Lines();
    private Point p1 = new Point(0,0);
    private Point p2 = new Point(0,0);
    
    
    public DrawPanel() {
        initComponents();
    }

    public void paintComponent(Graphics g) {
        
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth()-1, getHeight()-1);
        
        g.setColor(Color.red);
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
        
        g.setColor(Color.black);
        lines.draw(g);

    }
    
    public void setCoordsDraggedLine(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public void setLines(Lines lines){
        this.lines = lines;
    }
    
    @SuppressWarnings("unchecked")
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
