import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author robertfisch
 */
public class Turtle
{
    /**
     * sauvegarde la position de la tortue
     */
    private Point position;

    /**
     * crée une nouvelle tortue à la position données
     * @param pPosition la position initiale de la tortue
     */
    public Turtle(Point pPosition)
    {
        position=pPosition;
    }

    /**
     * retourne la position de la tortue. Nécessaire au dessin.
     * @return la position de la tortue
     */
    public Point getPosition() {
        return position;
    }

    
    
    /**
     * deplace la tortue de quelques pixel à droite
     * @param dist  le nombre de pixel à déplacer
     */
    public void goRight(int dist)
    {
        position.x+=dist;
    }

    /**
     * deplace la tortue de quelques pixel à gauche
     * @param dist  le nombre de pixel à déplacer
     */
    public void goLeft(int dist)
    {
        position.x-=dist;
    }

    /**
     * deplace la tortue de quelques pixel vers le haut
     * @param dist  le nombre de pixel à déplacer
     */
    public void goUp(int dist)
    {
        position.y-=dist;
    }

    /**
     * deplace la tortue de quelques pixel vers le bas
     * @param dist  le nombre de pixel à déplacer
     */
    public void goDown(int dist)
    {
        position.y+=dist;
    }
    
    public void draw(Graphics g)
    {
        // choose color
        g.setColor(Color.BLACK);

        // draw body
        g.fillOval(position.x-8,position.y-8,16,16);
        // draw head
        g.fillOval(position.x-3,position.y-13,6,6);
        // draw legs
        g.drawLine(position.x-10,position.y-7,position.x+10,position.y+10);
        g.drawLine(position.x+10,position.y-7,position.x-10,position.y+10);
            
        // show the center of the turtle
        /**/
        g.setColor(Color.RED);
        g.fillRect(position.x-1,position.y-1,3,3);
        /**/
    }

}