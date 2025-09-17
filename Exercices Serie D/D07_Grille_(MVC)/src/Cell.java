
import java.awt.Color;

/**
 * Cette classe représente une cellule non vide de la grille
 *
 * @author robertfisch
 */
public class Cell {

    /**
     * coordonnée X
     */
    private int x;
    /**
     * coordonnée Y
     */
    private int y;
    /**
     * couleur
     */
    private Color color;

    /**
     * crée une nouvelle cellule à une position et avec une couleur donnée
     *
     * @param pX la coordonnée X
     * @param pY la coordonnée Y
     * @param pColor la couleur
     */
    public Cell(int pX, int pY, Color pColor) {
        x = pX;
        y = pY;
        color = pColor;
    }

    /**
     * retourne la coordonnée X de la cellule
     *
     * @return la coordonnée X
     */
    public int getX() {
        return x;
    }

    /**
     * pose la coordonnée X de la cellule
     *
     * @param x la nouvelle valeur de X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * retourne la coordonnée Y de la cellule
     *
     * @return la coordonnée Y
     */
    public int getY() {
        return y;
    }

    /**
     * pose la coordonnée Y de la cellule
     *
     * @param la coordonnée Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * retourne la couleur de la cellule
     *
     * @return la couleur de la cellule
     */
    public Color getColor() {
        return color;
    }

    /**
     * pose la couleur de la cellule
     *
     * @param color la couleur de la cellule
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
