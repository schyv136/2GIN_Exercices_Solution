


public class Lignes {

    private int fX;
    private int fY;
    private int tX;
    private int tY;

    public Lignes(int pfx, int pfy, int ptx, int pty) {
        fX = pfx;
        fY = pfy;
        tX = ptx;
        tY = pty;
    }

    public int getSX() {
        return fX;
    }

    public int getSY() {
        return fY;
    }

    public int getEX() {
        return tX;
    }

    public int getEY() {
        return tY;
    }

    @Override
    public String toString() {
        return "Start x:" + fX + " y:" + fY + "End x:" + tX + " y:" + tY;
    }

}
