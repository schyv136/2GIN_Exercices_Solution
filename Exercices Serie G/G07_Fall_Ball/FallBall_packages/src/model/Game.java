package model;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author robertfisch, modif. Fred Faber
 */
public class Game {

    private ArrayList<Block> alBlocks = new ArrayList<>();
    private Ball ball = null;
    
    private int points = 0;
    private int lives = 3;

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
        //La balle est un peu plus petite que l'espace entre 2 barres
        ball = new Ball(x, y, h / 4); 
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
            //si le bloc sort en haut, il est replacé en bas 
            //avec une nouvelle largeur et position
            if (block.y < 0) {
                block.y = height;
                block.x = (int) (Math.random() * width / 2);
                block.width = (int) (Math.random() * (width - block.stepX) / 3 * 2);
                //les points sont augmentés
                points++;
                //Amélioration: Augmentation de la vitesse après chaque 100 points
                if (points % 100 == 0) {
                    lives++;
                    ball.speedUp();
                    for (int j = 0; j < alBlocks.size(); j++) {
                        alBlocks.get(j).speedUp();
                    }
                }
            }
            if (block.isTouching(ball)) {
                touching = true;
                ball.stepY = block.stepY;
                //Amélioration: placer la balle entièrement SUR la barre
                //Ne pas utiliser ensemble avec la version élaborée de isTouching
                ball.y = block.y - ball.getRadius() + 2; 
            }
        }
        if (touching == false) {
            ball.stepY = 5;
            //Amélioration: pour éviter des déplacements horizontaux si la balle tombe
            ball.stop(); 
        }
        ball.move(width);
        if (ball.y < 0 || ball.y > height) {
            lives--;
            ball.y = height / 2;
            ball.x = width / 2;
        }
    }

    public void ballLeft() {
        ball.left();
    }

    public void ballRight() {
        ball.right();
    }

    public int getPoints() {
        return points;
    }

    public int getLives() {
        return lives;
    }

    public void ballStop() {
        ball.stop();
    }
}
