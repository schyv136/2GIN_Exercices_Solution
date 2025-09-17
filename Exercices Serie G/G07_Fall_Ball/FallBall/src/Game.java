
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author robertfisch
 */
public class Game {

    private ArrayList<Block> alBlocks = new ArrayList<>();
    private Ball ball = null;

    private int points = 0;
    private int lives = 3;

    private int ballSpeed = 10;

    public Game(int width, int height) {
        int h = height / 10;
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * width) / 2;
            int w = (int) (Math.random() * (width - x) / 3 * 2);
            Block block = new Block(x, i * h, w, h / 3);
            alBlocks.add(block);
        }

        int x = width / 2;
        int y = height / 2;
        ball = new Ball(x, y, h / 4); //La balle doit être un peu plus petite que l'espace entre 2 barres
    }

    public void draw(Graphics g) {
        for (int i = 0; i < alBlocks.size(); i++) {
            alBlocks.get(i).draw(g);
        }
        if (ball != null) {
            ball.draw(g);
        }
    }

    public void move(int width, int height) {
        boolean touching = false;
        for (int i = 0; i < alBlocks.size(); i++) {
            Block block = alBlocks.get(i);
            block.move();
            if (block.getY() < 0) {
                block.setY(height);
                block.setX((int) (Math.random() * width / 2));
                block.setWidth((int) (Math.random() * (width - block.getStepX()) / 3 * 2));
                points++;
                if (points % 100 == 0) {
                    lives++;
                    for (int j = 0; j < alBlocks.size(); j++) {
                        alBlocks.get(j).setStepY(alBlocks.get(j).getStepY() - 1);
                    }
                    ballSpeed += 1;
                }
            }
            if (block.isTouching(ball)) {
                touching = true;
                ball.setStepY(block.getStepY());
                //Amélioration: placer la balle entièrement SUR la barre
                ball.setY(block.getY() - ball.getRadius() + 2); //Ne pas utiliser ensemble avec la version élaborée de isTouching
            }
        }
        if (touching == false) {
            ball.setStepY(5);
            ball.setStepX(0);  //Amélioration: pour éviter des déplacements horizontaux si la balle tombe
        }
        ball.move(width);
        if (ball.getY() < 0 || ball.getY() > height) {
            lives--;
            ball.setY(height / 2);
            ball.setX(width / 2);
        }
    }

    public void ballLeft() {
        ball.setStepX(-ballSpeed);
    }

    public void ballRight() {
        ball.setStepX(ballSpeed);
    }

    public int getPoints() {
        return points;
    }

    public int getLives() {
        return lives;
    }

    void ballStop() {
        ball.setStepX(0);
    }

}
