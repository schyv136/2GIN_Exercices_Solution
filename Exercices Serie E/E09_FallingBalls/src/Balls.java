
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author loegu
 */
public class Balls {

    private ArrayList<Ball> alBalls = new ArrayList<>();

    private int random(int pMin, int pMax) {
        return (int) (Math.random() * (pMax - pMin + 1)) + pMin;
    }

    public Balls(int pN, int pWidth, int pHeight) {
        for (int i = 0; i < pN; i++) {
            int radius = random(20, 50);
            double x = random(radius, pWidth - radius);
            double y = random(radius, pHeight - radius);
            Ball ball = new Ball(x, y, radius, new Color(128, 0, 0));
            alBalls.add(ball);
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < alBalls.size(); i++) {
            alBalls.get(i).draw(g);
        }
    }

    //fait tomber la 1ère balle de la liste qui ne tombe pas encore (while)
    public void dropBall() {
        int i = 0;
        while (i < alBalls.size() && alBalls.get(i).isFalling()) {
            i++;
        }
        if (i < alBalls.size()) {
            alBalls.get(i).drop();
        }
    }

    //fait tomber la 1ère balle de la liste qui ne tombe pas encore (while et var booléenne)
    public void dropBall1() {
        boolean found = false;
        int i = 0;
        while (i < alBalls.size() && !found) {
            if (!alBalls.get(i).isFalling()) {
                alBalls.get(i).drop();
                found = true;
            }
            i++;
        }
    }

    //fait tomber la 1ère balle de la liste qui ne tombe pas encore (while et variable)
    public void dropBall2() {
        Ball ballToDrop = null;
        int i = 0;
        while (i < alBalls.size() && ballToDrop == null) {
            if (!alBalls.get(i).isFalling()) {
                ballToDrop = alBalls.get(i);
            }
            i++;
        }
        if (ballToDrop != null) {
            ballToDrop.drop();
        }
    }

    //fait tomber la 1ère balle de la liste qui ne tombe pas encore (for et variable)
    public void dropBall3() {
        Ball ballToDrop = null;
        for (int i = 0; i < alBalls.size(); i++) {
            if (!alBalls.get(i).isFalling() && ballToDrop == null) {
                ballToDrop = alBalls.get(i);
            }
        }
        if (ballToDrop != null) {
            ballToDrop.drop();
        }
    }

    //fait tomber la DERNIERE balle de la liste qui ne tombe pas encore (for)
    public void dropBall4() {
        Ball ballToDrop = null;
        for (int i = 0; i < alBalls.size(); i++) {
            if (!alBalls.get(i).isFalling()) {
                ballToDrop = alBalls.get(i);
            }
        }
        if (ballToDrop != null) {
            ballToDrop.drop();
        }
    }

    //fait tomber la DERNIERE balle de la liste qui ne tombe pas encore (for)
    public void dropBall5() {
        for (int i = 0; i < alBalls.size(); i++) {
            if (!alBalls.get(i).isFalling()) {
                alBalls.get(i).drop();
                i = alBalls.size();
            }
        }
    }

    public void move(int pHeight) {
        for (int i = 0; i < alBalls.size(); i++) {
            alBalls.get(i).move(pHeight);
        }
    }

}
