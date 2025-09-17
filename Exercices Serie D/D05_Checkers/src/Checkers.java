
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Fred Faber
 */
public class Checkers {

    /**
     * liste des pièces sur le damier
     */
    private ArrayList<Piece> alPieces = new ArrayList<>();

    /**
     * Initialisation des pions des deux joueurs
     */
    public void init() {
        //placer les pions du joueur 1 (bleu)
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 8; c++) {
                if ((r + c) % 2 != 0) {
                    alPieces.add(new Piece(Color.BLUE, c, r));
                }
            }
        }
        //placer les pions du joueur 1 (rouge)
        for (int r = 5; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if ((r + c) % 2 != 0) {
                    alPieces.add(new Piece(Color.RED, c, r));
                }
            }
        }
    }

    /**
     * retourne la pièce à la position (row,col) ou null si la case est vide
     *
     * @param row ligne de la position à tester
     * @param col colonne de la position à tester
     * @return la pièce ou null
     */
    public Piece getPieceAt(int col, int row) {
        Piece result = null;
        for (int i = 0; i < alPieces.size(); i++) {
            if (row == alPieces.get(i).getRow() && col == alPieces.get(i).getCol()) {
                result = alPieces.get(i);
            }
        }
        return result;
    }

    /**
     * Déplace un pion d'une cellule à une autre tout en vérifiant si le
     * déplacement est possible.
     *
     * @param startRow ligne de départ
     * @param startCol colonne de départ
     * @param destRow ligne d'arrivée
     * @param destCol colonne d'arrivée
     * @return true si le déplacement est possible, false sinon
     */
    public boolean move(int startCol, int startRow, int destCol, int destRow) {
        boolean result = true;
        Piece p = getPieceAt(startCol, startRow);
        if (p == null) // pion n'existe pas, mouvement non valide
        {
            result = false;
        } else //pion existe
        if (destRow < 0 || destRow >= 8 || destCol < 0 || destCol >= 8) //suppression
        {
            //supprimer le pion:
            int i = alPieces.indexOf(p);
            alPieces.remove(i);
        } else if (getPieceAt(destCol, destRow) == null) //déplacement
        {
            //déplacer le pion:
            p.moveTo(destCol, destRow);
        } else {
            result = false;  //mouvement non valide
        }
        return result;
    }

    public void draw(Graphics g, int width, int height) {
        // calculer le côté d'un carreau
        int side = Math.min(width, height);
        int squareSide = side / 8;

        // (c) calcul des espaces des bords
        int offsetLeft = (width - 8 * squareSide) / 2;
        int offsetTop  = (height - 8 * squareSide) / 2;

        //dessiner l'échiquier
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if ((r + c) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(offsetLeft + c * squareSide,
                            offsetTop + r * squareSide, squareSide, squareSide);
                // (b) Dessiner la bordure.
                g.setColor(Color.BLACK);
                g.drawRect(offsetLeft + c * squareSide,
                        offsetTop + r * squareSide, squareSide, squareSide);
            }
        }

        // dessiner les pions
        for (int i = 0; i < alPieces.size(); i++) {
            alPieces.get(i).draw(g, offsetLeft, offsetTop, squareSide);
        }
    }

}
