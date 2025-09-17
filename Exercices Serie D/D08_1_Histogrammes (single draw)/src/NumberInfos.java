
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author fred
 */
public class NumberInfos {
    /** la série des nombres avec leur description */
    private ArrayList<NumberInfo> alNumberInfos = new ArrayList<>();
    
    /** le titre de la série de nombres */
    private String title;

    /** 
     * constructeur de la série
     * @param le nouveau titre 
     */
    public NumberInfos(String title) {
        this.title = title;
    }

    /**
     * accesseur pour le titre
     * @return le titre de la série
     */
    public String getTitle() {
        return title;
    }

    /**
     * Ajout d'une nouvelle paire (valeur, libellé)
     * @param value la valeur numérique
     * @param label la description
     */
    public void add(double value, String label) {
        alNumberInfos.add(new NumberInfo(value, label));
    }
    
    /**
     * calcule le total des valeurs mémorisées
     * @return le total des valeurs mémorisées
     */
    public double getTotal() {
        double result=0;
        for(int i=0 ; i<alNumberInfos.size() ; i++) 
            result = result + alNumberInfos.get(i).getValue(); 
        return result;
    }
    
    /**
     * calcule le maximum des valeurs mémorisées
     * @return le maximum des valeurs mémorisées
     */
    public double getMaximum() {
        double result=0;
        for(int i=0 ; i<alNumberInfos.size() ; i++) 
            if(result < alNumberInfos.get(i).getValue())
                result = alNumberInfos.get(i).getValue(); 
        return result;
    }
    
    /**
     * retour du contenu de la liste sous forme de tableau
     */
    public Object[] toArray() {
        return alNumberInfos.toArray();
    }

    public int size()
    {
        return alNumberInfos.size();
    }

    public NumberInfo get(int i)
    {
        return alNumberInfos.get(i);
    }
    
    /**
     * dessine la ligne sur le canevas g
     * @param g  le canevas cible
     * @param pWidth  largeur du canevas
     * @param pHeight hauteur du canevas
     */
     public void draw(Graphics g, int pWidth, int pHeight) {
        int height = pHeight-1; //pour éviter de dépasser en bas du panneau
        int width  = pWidth -1; //pour éviter de dépasser à droite du panneau
        
        if (size()>0) {
            double barWidth = (double)width/size();
            for (int i=0 ; i<size() ; i++) {
                //choix de la couleur (alternativement orange et jaune)
                if(i%2==0) 
                    g.setColor(Color.YELLOW);
                else
                    g.setColor(Color.ORANGE);
                //hauteur d'un rectangle
                double barHeight = (double)get(i).getValue()/getMaximum()*height;     
                //affichage du fond des rectangles
                g.fillRect((int)(i*barWidth),  height-(int)barHeight, 
                           (int)barWidth,      (int)barHeight);
                //afficher la bordure en rouge
                g.setColor(Color.RED);
                g.drawRect((int)(i*barWidth), height-(int)barHeight,  
                           (int)barWidth, (int)barHeight);
                //afficher le libellé et la valeur
                g.setColor(Color.BLUE);
                g.drawString( get(i).getLabel(), (int)(i*barWidth+2), height-4);
                g.drawString( String.valueOf(get(i).getValue()),
                                                 (int)(i*barWidth+2), height-18);
            }
            //afficher le titre
            g.setColor(Color.DARK_GRAY);
            g.drawString( title, 3, 11);
            g.setColor(Color.BLACK);
            g.drawString( title, 2, 10);  
        }        
            
     }    
    
}