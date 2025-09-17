
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Fred Faber
 */
public class Piece {

    /**
     * couleur du pion
     */
    private Color color = null;

    /**
     * position du pion: colonne
     */
    private int col;

    /**
     * position du pion: ligne
     */
    private int row;

    private boolean kinged;

    /**
     * constructeur
     */
    public Piece(Color pColor, int pCol, int pRow, boolean pKinged) {
        color = pColor;
        row = pRow;
        col = pCol;
        kinged = pKinged;
    }

    /**
     * déplacer un pion à une nouvelle position
     *
     * @param pRow nouvelle ligne
     * @param pCol nouvelle colonne
     */
    public void moveTo(int pCol, int pRow) {
        col = pCol;
        row = pRow;
    }

    // getters / accesseurs 
    public int getCol() {
        return col;
    }

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public void kinged() {
        kinged = true;
    }

    public boolean getKinged() {
        return kinged;
    }

    public void draw(Graphics g, int offsetLeft, int offsetTop, int squareSide) {
        g.setColor(color);
        //dessiner les pions
        g.fillOval(offsetLeft + col * squareSide + 1,
                offsetTop + row * squareSide + 1,
                squareSide - 2, squareSide - 2);

        if (color == Color.RED) {
            g.setColor(Color.BLUE);
        } else if (color == Color.BLUE) {
            g.setColor(Color.RED);
        }
        if (kinged == true) {
            drawStar(g, offsetLeft + col * squareSide + 1 + squareSide / 2, 
                    offsetTop + row * squareSide + 1 + squareSide / 2, 
                    squareSide / 7, 5, 2);
        }
    }

    public void drawStar(Graphics g, int ctrX, int ctrY, int radius, int nPoints, double spikiness) {
        int xPoint[] = new int[2 * nPoints];
        int yPoint[] = new int[2 * nPoints];

        nPoints = (int) (nPoints * 2);
        
        for (int i = 0; i < nPoints; i++) {
            double iRadius = (i % 2 == 0) ? radius : (radius * spikiness);
            double angle = (270+36) + (i * 360.0) / (nPoints);

            xPoint[i] = (int) (ctrX + iRadius * Math.cos(Math.toRadians(angle)));
            yPoint[i] = (int) (ctrY + iRadius * Math.sin(Math.toRadians(angle)));
        }
        g.fillPolygon(xPoint, yPoint, nPoints);
    }

}
