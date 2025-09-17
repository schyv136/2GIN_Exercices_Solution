import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *@author Fred Faber
 */
public class Checkers {
    /** liste des pièces sur le damier */
    private ArrayList<Piece> alPieces = new ArrayList<>();
    
     /**
     * Initialisation des pions des deux joueurs
     */
    public Checkers()
    {
        //placer les pions du joueur 1 (bleu)
        for (int r = 0 ; r<=2 ; r++)
            for (int c = 0 ; c<=7 ; c++)
                if ((r+c)%2 != 0)
                    alPieces.add(new Piece(Color.BLUE, c, r));
        //placer les pions du joueur 2 (rouge)
        for (int r = 5 ; r<=7 ; r++)
            for (int c = 0 ; c<=7 ; c++)
                if ((r+c)%2 != 0)
                    alPieces.add(new Piece(Color.RED, c, r));
    } 
    
    
    /**
     * retourne la pièce à la position (row,col) ou null si la case est vide
     * @param row   ligne de la position à tester
     * @param col   colonne de la position à tester
     * @return      la pièce ou null
     */
    public Piece getPieceAt(int col, int row) 
    {
        Piece result=null;
        for (int i=0 ; i<alPieces.size() ; i++)
             if (row==alPieces.get(i).getRow() && col==alPieces.get(i).getCol())
                    result = alPieces.get(i);
        return result;
    }
    
   /**
     * Déplace un pion d'une cellule à une autre tout en vérifiant si le
     * déplacement est possible.
     * 
     * @param startRow  ligne de départ
     * @param startCol  colonne de départ
     * @param destRow   ligne d'arrivée
     * @param destCol   colonne d'arrivée
     * @return          true si le déplacement est possible, false sinon
     */
    public boolean move(int startCol, int startRow, int destCol, int destRow) 
    {
        boolean result = true;
        Piece p = getPieceAt(startCol,startRow);
        if (p==null)    // pion n'existe pas, mouvement non valide
            result = false; 
        else         
            //pion n'existe pas
            if (destRow<0 || destRow>7 || destCol<0 || destCol>7) //suppression
            {
                //supprimer le pion:
                int i = alPieces.indexOf(p);
                alPieces.remove(i);
            }
            else if (getPieceAt(destCol,destRow) == null)   //déplacement
            {
                //déplacer le pion:
                p.moveTo(destCol,destRow);
            } 
            else result = false;  //mouvement non valide
        
        return result;
    }
    
    //Le damier se dessine soi-même sur le canevas avec les pions
    public void draw(Graphics g, int squareSide)
    {
        //dessiner l'échiquier
        for (int r = 0 ; r<=7 ; r++) {
            for (int c = 0 ; c<=7 ; c++) {
                //dessiner les champs en gris et en blanc
                if ((r+c)%2==0) g.setColor(Color.WHITE);
                else            g.setColor(Color.GRAY);
                g.fillRect(c*squareSide, r*squareSide, squareSide, squareSide);
                // Dessiner la bordure.
                g.setColor(Color.BLACK);
                g.drawRect(c*squareSide, r*squareSide, squareSide, squareSide);
            }
        }
        
        //dessiner les pions
        for (int i = 0; i < alPieces.size(); i++) {
            alPieces.get(i).draw(g, squareSide);
        }
    }

    
}