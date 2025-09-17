/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LeyPh975
 */
public class Lignes {

    private int sX;
    private int sY;
    private int eX;
    private int eY;

    public Lignes(int sx, int sy, int ex, int ey) {
        sX = sx;
        sY = sy;
        eX = ex;
        eY = ey;
    }

    public int getSX() {
        return sX;
    }

    public int getSY() {
        return sY;
    }

    public int getEX() {
        return eX;
    }

    public int getEY() {
        return eY;
    }

    @Override
    public String toString() {
        return "Start x:" + sX + " y:" + sY + "End x:" + eX + " y:" + eY;
    }

}
