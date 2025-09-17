
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
    private int x = 0;
    private int y = 0;
    private int fieldX = 0;
    private int fieldY = 0;
    private int offsetTop = 0;
    private int offsetLeft = 0;
    private int squareSide = 0;
    private int click = 0;

    private DrawPanel drawpanel = new DrawPanel();
    private ArrayList<Piece> alPieces = new ArrayList<>();
    private ArrayList<Click> alClick = new ArrayList<>();

    /**
     * Initialisation des pions des deux joueurs
     */
    public void init() {
        //placer les pions du joueur 1 (bleu)
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 8; c++) {
                if ((r + c) % 2 != 0) {
                    alPieces.add(new Piece(Color.BLUE, c, r, false));
                }
            }
        }
        //placer les pions du joueur 1 (rouge)
        for (int r = 5; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if ((r + c) % 2 != 0) {
                    alPieces.add(new Piece(Color.RED, c, r, false));
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
    public boolean move() {
        int startRow = alClick.get(0).getX();
        int startCol = alClick.get(0).getY();
        int destRow = alClick.get(1).getX();
        int destCol = alClick.get(1).getY();

        boolean result = true;
        Piece p = getPieceAt(startRow, startCol);
        if (p == null) // pion n'existe pas, mouvement non valide
        {
            result = false;
        } else //pion existe
        if (destRow < 0 || destRow >= 8 || destCol < 0 || destCol >= 8) //suppression
        {
            //supprimer le pion:
            int i = alPieces.indexOf(p);
            alPieces.remove(i);
        } else if (getPieceAt(destRow, destCol) == null) //déplacement
        {
            //déplacer le pion:
            p.moveTo(destRow, destCol);
        } else {
            result = false;  //mouvement non valide
        }
        clearClick();
        return result;
    }

    public void draw(Graphics g, int width, int height) {
        // calculer le côté d'un carreau
        int side = Math.min(width, height);
        squareSide = side / 8;

        // (c) calcul des espaces des bords
        offsetLeft = (width - 8 * squareSide) / 2;
        offsetTop = (height - 8 * squareSide) / 2;

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

    public void drawSelected(Graphics g) {
        if (getPieceAt(fieldX, fieldY) != null) {
            g.setColor(Color.GREEN);
            g.drawOval(offsetLeft + fieldX * squareSide + 1, offsetTop + fieldY * squareSide + 1, squareSide - 2, squareSide - 2);
        }
    }

    public void setCord(int pX, int pY) {
        x = pX;
        y = pY;

        calculateFieldX();
        calculateFieldY();
        addClick();
    }

    public void calculateFieldX() {
        for (int i = 0; i < 9; i++) {
            if (x >= offsetLeft + squareSide * (i) && x < offsetLeft + squareSide * (i + 1)) {
                fieldX = i;
            }
        }
    }

    public void calculateFieldY() {
        for (int i = 0; i < 9; i++) {
            if (y >= offsetTop + squareSide * (i) && y < offsetTop + squareSide * (i + 1)) {
                fieldY = i;
            }
        }
    }

    public void clearClick() {
        alClick.removeAll(alClick);
    }

    public void addClick() {
        alClick.add(new Click(fieldX, fieldY));
        if (alClick.size() == 1 && getPieceAt(fieldX, fieldY) == null) {
            clearClick();
        } else if (alClick.size() == 2) {
            validateMove();
        } else if (alClick.size() > 2) {
            clearClick();
            addClick();
        }
    }

    public void validateMove() {
        int startRow = alClick.get(0).getY();
        int startCol = alClick.get(0).getX();
        int destRow = alClick.get(1).getY();
        int destCol = alClick.get(1).getX();

        Piece p = getPieceAt(alClick.get(0).getX(), alClick.get(0).getY());
        Color color = p.getColor();

        if (color == Color.RED) {
            if (startRow == destRow + 1) {
                if (startCol - 1 == destCol || startCol + 1 == destCol) {
                    if (getPieceAt(destCol, destRow) == null) {
                        kinged();
                        move();
                    }
                }
            } else if (startRow == destRow + 2) {
                if (startCol - 2 == destCol) {
                    Piece oppP = getPieceAt(destCol + 1, destRow + 1);
                    Color oppColor = oppP.getColor();
                    if (getPieceAt(destCol, destRow) == null && oppP != null && oppColor == Color.BLUE) {
                        kinged();
                        move();
                        int i = alPieces.indexOf(oppP);
                        alPieces.remove(i);
                    }
                } else if (startCol + 2 == destCol) {
                    Piece oppP = getPieceAt(destCol - 1, destRow + 1);
                    Color oppColor = oppP.getColor();
                    if (getPieceAt(destCol, destRow) == null && oppP != null && oppColor == Color.BLUE) {
                        kinged();
                        move();
                        int i = alPieces.indexOf(oppP);
                        alPieces.remove(i);
                    }
                }
            } else if (startRow == destRow - 1 && p.getKinged() == true) {
                if (startCol - 1 == destCol || startCol + 1 == destCol) {
                    if (getPieceAt(destCol, destRow) == null) {
                        move();
                    }
                }
            } else if (startRow == destRow - 2 && p.getKinged() == true) {
                if (startCol - 2 == destCol) {
                    Piece oppP = getPieceAt(destCol + 1, destRow - 1);
                    Color oppColor = oppP.getColor();
                    if (getPieceAt(destCol, destRow) == null && oppP != null && oppColor == Color.BLUE) {
                        move();
                        int i = alPieces.indexOf(oppP);
                        alPieces.remove(i);
                    }
                } else if (startCol + 2 == destCol) {
                    Piece oppP = getPieceAt(destCol - 1, destRow - 1);
                    Color oppColor = oppP.getColor();
                    if (getPieceAt(destCol, destRow) == null && oppP != null && oppColor == Color.BLUE) {
                        move();
                        int i = alPieces.indexOf(oppP);
                        alPieces.remove(i);
                    }
                }
            }
        
        } else if (color == Color.BLUE) {
            if (startRow == destRow - 1) {
                if (startCol - 1 == destCol || startCol + 1 == destCol) {
                    if (getPieceAt(destCol, destRow) == null) {
                        kinged();
                        move();
                    }
                }
            } else if (startRow == destRow - 2) {
                if (startCol - 2 == destCol) {
                    Piece oppP = getPieceAt(destCol + 1, destRow - 1);
                    Color oppColor = oppP.getColor();
                    if (getPieceAt(destCol, destRow) == null && oppP != null && oppColor == Color.RED) {
                        kinged();
                        move();
                        int i = alPieces.indexOf(oppP);
                        alPieces.remove(i);
                    }
                } else if (startCol + 2 == destCol) {
                    Piece oppP = getPieceAt(destCol - 1, destRow - 1);
                    Color oppColor = oppP.getColor();
                    if (getPieceAt(destCol, destRow) == null && oppP != null && oppColor == Color.RED) {
                        kinged();
                        move();
                        int i = alPieces.indexOf(oppP);
                        alPieces.remove(i);
                    }
                }

            } else if (startRow == destRow + 1 && p.getKinged() == true) {
                if (startCol - 1 == destCol || startCol + 1 == destCol) {
                    if (getPieceAt(destCol, destRow) == null) {
                        move();
                    }
                }
            } else if (startRow == destRow + 2 && p.getKinged() == true) {
                if (startCol - 2 == destCol) {
                    Piece oppP = getPieceAt(destCol + 1, destRow + 1);
                    Color oppColor = oppP.getColor();
                    if (getPieceAt(destCol, destRow) == null && oppP != null && oppColor == Color.RED) {
                        move();
                        int i = alPieces.indexOf(oppP);
                        alPieces.remove(i);
                    }
                } else if (startCol + 2 == destCol) {
                    Piece oppP = getPieceAt(destCol - 1, destRow + 1);
                    Color oppColor = oppP.getColor();
                    if (getPieceAt(destCol, destRow) == null && oppP != null && oppColor == Color.RED) {
                        move();
                        int i = alPieces.indexOf(oppP);
                        alPieces.remove(i);
                    }
                }
            }
        } else {
            clearClick();
        }
    }

    public void kinged() {
        int destRow = alClick.get(1).getY();

        Piece p = getPieceAt(alClick.get(0).getX(), alClick.get(0).getY());
        Color color = p.getColor();

        if (color == Color.RED) {
            if (destRow == 0) {
                p.kinged();
            }
        } else if (color == Color.BLUE) {
            if (destRow == 7) {
                p.kinged();
            }
        }
    }
}
