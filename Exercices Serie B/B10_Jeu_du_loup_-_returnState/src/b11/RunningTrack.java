package b11;

/**
 * @author HubTa386
 */
public class RunningTrack {

    private int minStep = 1;
    private int maxStep = 5;
    private int maxPos = 20;
    private int wolfPos;
    private int myPos =0;
    
    private boolean gameOver = false;

    public RunningTrack(int wolfPos) {
        this.wolfPos = wolfPos;
    }    

    public int getWolfPos() {
        return wolfPos;
    }

    public int getMyPos() {
        return myPos;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }

    public int move(int step) {
        if (step >= minStep && step <= maxStep) {
            myPos = myPos + step;
            wolfPos = wolfPos + (int) (Math.random() * 5) + 1;
        }
        if (myPos == wolfPos) {  //I won
            gameOver = true;
            return 1;
        } else if (wolfPos > maxPos || myPos > maxPos) { //wolf won
            gameOver = true;
            return -1;
        } else {
            gameOver = false;
            return 0; //play on
        }
    }


}
