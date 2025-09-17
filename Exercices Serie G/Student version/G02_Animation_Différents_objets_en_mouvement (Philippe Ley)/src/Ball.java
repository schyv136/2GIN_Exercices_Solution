/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LeyPh975
 */
public class Ball {

    private int x;
    private int y;
    private int speedX;
    private int speedY;
    private int size;
    private String emo;

    public Ball(int x, int y, int speedX, int speedY, int size, String emo) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.size = size;
        this.emo = emo;
    }

    public int addX(int pX) {
        x += pX;
        return x;
    }

    public int addY(int pY) {
        y += pY;
        return y;
    }
    
    public int setSpeedX(int speedX) {
        this.speedX = speedX;
        return this.speedX;
    }

    public int setSpeedY(int speedY) {
        this.speedY = speedY;
        return this.speedY;
    }
    
    public void changeState(String state){
        emo = state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public int getSize() {
        return size;
    }

    public String getEmo() {
        return emo;
    }
    
}
