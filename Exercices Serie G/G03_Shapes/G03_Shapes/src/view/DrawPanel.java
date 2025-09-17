package view;

import java.awt.Color;
import java.awt.Graphics;
import logic.Shapes;

public class DrawPanel extends javax.swing.JPanel {

    private Shapes alShapes;
    
    public DrawPanel() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g){
        
//        g.setColor(Color.white);
//        g.fillRect(0, 0, getWidth()-1, getHeight()-1);
        
        if(alShapes!=null)
            alShapes.draw(g);
        
    }

    public void setAlShapes(Shapes alShapes) {
        this.alShapes = alShapes;
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
