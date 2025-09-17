import java.awt.Color;
import java.awt.Graphics;

/*
 * DrawPanel.java
 *
 * Created on Feb 28, 2012, 8:38:29 PM
 * @author Robert Fisch, Fred Faber
 */
public class DrawPanel extends javax.swing.JPanel
{
    /** une référence vers le modèle */
    private Checkers checkers = null;  
    //Données nécessaires au dessin et au calcul des coordonnées d'un pion
    private int squareSide = 0;
    private int offsetLeft = 0;
    private int offsetTop  = 0;
    
    
    /** Creates new form DrawPanel */
    public DrawPanel()
    {
        initComponents();
    }
    
    /** modificateur pour la référence au modèle */
    public void setCheckers(Checkers pCheckers)             
    {
        checkers=pCheckers;
    }
    
    //Retourne les données nécessaires pour calculer la position du pion
    public int getOffsetLeft() {
        return offsetLeft;
    }
    public int getOffsetTop() {
        return offsetTop;
    }
    public int getSquareSide() {
        return squareSide;
    }
    
    /** méthode dessinant le damier */
    @Override
    public void paintComponent(Graphics g)                  
    {
        // calculer le côté d'une cellule du damier
        int side = Math.min(getWidth(),getHeight());
        squareSide = side / 8;

        // calculer les espaces des bords
        offsetLeft = (getWidth()  - 8*squareSide) / 2;
        offsetTop  = (getHeight() - 8*squareSide) / 2;        
        
        //effacer le dessin actuel
        g.setColor(Color.WHITE);
        g.fillRect(0,0, getWidth(),getHeight());
        
        // dessiner le damier avec les pions
        if(checkers!=null)
            checkers.draw(g, squareSide, offsetLeft, offsetTop);
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