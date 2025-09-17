
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Cette classe représente la grille une cellule non vide est dessinée en blanc
 *
 * @author robertfisch
 */
public class Grid {

    /**
     * la liste des cellules non vides (chaque cellule connaît sa position)
     */
    private ArrayList<Cell> alCells = new ArrayList<>();

    /**
     * le nombre de colonnes
     */
    private int cols;
    /**
     * le nombre de lignes
     */
    private int rows;

    /**
     * mettre au point une nouvelle grille avec les dimensions données
     *
     * @param pCols le nombre de colonnes
     * @param pRows le nombre de lignes
     */
    public Grid(int pCols, int pRows) {
        cols = pCols;
        rows = pRows;
    }

    /**
     * dessine la grille
     *
     * @param g le canevas sur lequel doit être dessinée
     * @param width la largeur de la grille
     * @param height la hauteur de la grille
     */
    public void draw(Graphics g, int width, int height) {
        // calculer la taille d'une cellule
        double cellWidth = (width - 1) / (double) getCols();
        double cellHeight = (height - 1) / (double) getRows();

        // draw non empty cells
        // loop through the list of cells
        for (int i = 0; i < alCells.size(); i++) {
            // get the cells
            Cell cell = alCells.get(i);
            // set the draweing color
            g.setColor(cell.getColor());
            // fill the respective rectangle (= make the cell visible)
            g.fillRect((int) (cell.getX() * cellWidth), (int) (cell.getY() * cellHeight),
                       (int) cellWidth, (int) cellHeight);
        }

        // changer la couleur
        g.setColor(Color.BLACK);
        // dessiner les lignes horizontales (dessiner rows+1 lignes...)
        for (int i = 0; i <= getRows(); i++) {
            g.drawLine(0, (int) (i * cellHeight), (int) (getCols() * cellWidth), (int) (i * cellHeight));
        }
        // dessiner les lignes verticales (dessiner cols+1 lignes...)
        for (int i = 0; i <= getCols(); i++) {
            g.drawLine((int) (i * cellWidth), 0, (int) (i * cellWidth), (int) (getRows() * cellHeight));
        }
    }

    /**
     * ajouter une cellule d'une certaine couleur à un certain emplacement
     *
     * @param pX la coordonnée X
     * @param pY la coordonnée Y
     * @param pColor la couleur
     */
    public void addCell(int pX, int pY, Color pColor) {
        alCells.add(new Cell(pX, pY, pColor));
    }

    /**
     * @return the cols
     */
    public int getCols() {
        return cols;
    }

    /**
     * @param cols the cols to set
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

}
