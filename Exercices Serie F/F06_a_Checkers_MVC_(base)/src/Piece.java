
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author  Fred Faber
 */
public class Piece {
    /** couleur du pion */
    private Color color=null;
    
    /** position  du pion: colonne*/
    private int col;

    /** position  du pion: ligne*/
    private int row;    
    
    /** constructeur */ 
    public Piece(Color pColor, int pCol, int pRow) 
    {
        color = pColor;
        row   = pRow;
        col   = pCol;
    }

    /**
     * déplacer un pion à une nouvelle position 
     * @param pRow  nouvelle ligne
     * @param pCol  nouvelle colonne
     */
    public void moveTo(int pCol, int pRow) 
    {        
        col   = pCol;
        row   = pRow;
    }
    
    // getters / accesseurs 
    public int getCol() 
    {
        return col;
    }

    public Color getColor() 
    {
        return color;
    }

    public int getRow() {
        return row;
    }    
    
    //La cellule se dessine soi-même à la bonne position sur le canevas
    public void draw(Graphics g, int squareSide)
    {
        g.setColor(color);
        g.fillOval(col*squareSide+1, row*squareSide+1, 
                   squareSide-2, squareSide-2);
    }
    
}