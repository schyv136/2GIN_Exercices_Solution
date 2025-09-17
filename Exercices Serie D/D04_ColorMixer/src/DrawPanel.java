
import java.awt.Color;
import java.awt.Graphics;
/**
 * Class name:   DrawPanel
 * @version May 18, 2016
 * @author  fabfr
 */
public class DrawPanel extends javax.swing.JPanel {       

    public DrawPanel() {
        initComponents();
    }
    
    private int red=200, green=200, blue=200, alpha=200;              

    public void setRed(int red)     { this.red = red;        } 
    public void setGreen(int green) { this.green = green;    }
    public void setBlue(int blue)   { this.blue = blue;      }
    public void setAlpha(int alpha) { this.alpha = alpha;    }    
    
    @Override
    protected void paintComponent(Graphics g) {     
        //effacer le fond                                                 
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //tracer les diagonales                                        
        g.setColor(Color.BLACK);        
        double xStep = getWidth() /20.0;
        double yStep = getHeight()/20.0;
        for (int i=0 ; i<20 ; i++) {    
            //diagonales haut-droite --> bas-gauche     
            g.drawLine((int)(i*xStep), 0,             0,            (int)(i*yStep)); 
            g.drawLine((int)(i*xStep), getHeight()-1, getWidth()-1, (int)(i*yStep));
            //diagonales haut-gauche --> bas-droite    
            g.drawLine((int)(i*xStep), 0,           getWidth()-1,                getHeight()-1-(int)(i*yStep));
            g.drawLine(0          , (int)(i*yStep), getWidth()-1-(int)(i*xStep), getHeight()-1 );
        }
        
        //solution alternative
//        g.setColor(Color.BLACK);
//        int cellWidth  =  getWidth()/20;
//        int cellHeight = getHeight()/20;
//        for(int i = 0; i <= 40; i++)
//        {
//            g.drawLine(i*cellWidth, getHeight(), -20*cellWidth+cellWidth*i, 0);
//            g.drawLine(0, i*cellHeight, getWidth(), -20*cellHeight+cellHeight*i);
//        }
        
        
        //Tracer les carrés coloriés                                 
        int vertSide = getHeight()/3;                        
        int horSide  = getWidth()/3;
        
        g.setColor(new Color(red, 0, 0, alpha));                
        g.fillRect(0,           0,          horSide,    vertSide);
        g.setColor(new Color(red, green, 0, alpha));
        g.fillRect(horSide,     0,          horSide,    vertSide);
        g.setColor(new Color(0, green, 0, alpha));
        g.fillRect(2*horSide,   0,          horSide,    vertSide);
        
        g.setColor(new Color(red, 0, blue, alpha));            
        g.fillRect(horSide/2,   vertSide,   horSide/2,  vertSide); 
//        g.fillRect(horSide/2,   vertSide,   (int)Math.round(horSide/2.0),  vertSide); //for perfection :-)
        g.setColor(new Color(red, green, blue, alpha));
        g.fillRect(horSide,     vertSide,   horSide,    vertSide);
        g.setColor(new Color(0, green, blue, alpha));
        g.fillRect(2*horSide,   vertSide,   horSide/2,  vertSide);
        
        g.setColor(new Color(0, 0, blue, alpha));                
        g.fillRect(horSide,     2*vertSide, horSide,    vertSide);   
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
