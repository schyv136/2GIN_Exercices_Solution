
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leyph
 */
public class DrawPanel extends javax.swing.JPanel {

    private final EmoBigSmile emoBigSmile = new EmoBigSmile();
    private final EmoSmile emoSmile = new EmoSmile();
    private final EmoSad emoSad = new EmoSad();
    private final EmoSurprised emoSurprised = new EmoSurprised();
    private final EmoTongue emoTongue = new EmoTongue();

    ArrayList<Ball> alBalls = new ArrayList<>();

    public void add(int x, int y, int speedX, int speedY, int size, String emo) {
        alBalls.add(new Ball(x, y, speedX, speedY, size, emo));
    }

    public void move(int i, int x, int y) {
        alBalls.get(i).addX(x);
        alBalls.get(i).addY(y);
    }
    
    public void changeState(String state){
        for (int i = 0; i < alBalls.size(); i++) {
            if ("BigSmile".equals(alBalls.get(i).getEmo())){
                alBalls.get(i).changeState("Tongue");
            }else if ("Tongue".equals(alBalls.get(i).getEmo())){
                alBalls.get(i).changeState("BigSmile");
            }
        }
    }
    
    public void delete(){
        for (int i = 0; i < alBalls.size(); i++) {
            if ("Sad".equals(alBalls.get(i).getEmo())){
                alBalls.remove(i);
            }
        }
    }

    /**
     * Creates new form DrawPanel
     */
    public DrawPanel() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);

        for (int i = 0; i < alBalls.size(); i++) {
            if (alBalls.get(i).getX() < alBalls.get(i).getSize() / 2) {
                alBalls.get(i).setSpeedX(alBalls.get(i).getSpeedX() * -1);
            } else if (alBalls.get(i).getX() >= w - alBalls.get(i).getSize() / 2) {
                alBalls.get(i).setSpeedX(alBalls.get(i).getSpeedX() * -1);
            }

            if (alBalls.get(i).getY() >= h - alBalls.get(i).getSize() / 2) {
                alBalls.get(i).setSpeedY(alBalls.get(i).getSpeedY() * -1);
            } else if (alBalls.get(i).getY() <= alBalls.get(i).getSize() / 2) {
                alBalls.get(i).setSpeedY(alBalls.get(i).getSpeedY() * -1);
            }
            
//            for (int j = 0; j < alBalls.size(); j++){
//                if (i != j){
//                    int move = 0;
//                    int moveX = 0;
//                    int moveY = 0; 
//                    if (alBalls.get(i).getX()-(alBalls.get(i).getSize())/2 <= alBalls.get(j).getX()+(alBalls.get(j).getSize())/2){
//                        if (moveX != 1){
//                            move += 1;
//                            moveX = 1;
//                        }
//                        
//                    }else if (alBalls.get(i).getX()+(alBalls.get(i).getSize())/2 >= alBalls.get(j).getX()-(alBalls.get(j).getSize())/2){
//                        if (moveX != 1){
//                            move += 1;
//                            moveX = 1;
//                        }
//                    }
//                    if (alBalls.get(i).getY()-(alBalls.get(i).getSize())/2 <= alBalls.get(j).getY()+(alBalls.get(j).getSize())/2){
//                        if (moveY != 1){
//                            move += 1;
//                            moveY = 1;
//                        }
//                    }else if (alBalls.get(i).getY()+(alBalls.get(i).getSize())/2 >= alBalls.get(j).getY()-(alBalls.get(j).getSize())/2){
//                        if (moveY != 1){
//                            move += 1;
//                            moveY = 1;
//                        }
//                    }
//                    
//                    if (move == 2){
//                        alBalls.get(i).setSpeedX(alBalls.get(i).getSpeedX() * -1);
//                        //alBalls.get(i).addX(speedXi);
//                        alBalls.get(i).setSpeedY(alBalls.get(i).getSpeedY() * -1);
//                        //alBalls.get(i).addY(speedYi);
//                        
//                        int speedXj = alBalls.get(j).setSpeedX(alBalls.get(j).getSpeedX() * -1);
//                        alBalls.get(j).addX(speedXj);
//                        int speedYj = alBalls.get(j).setSpeedY(alBalls.get(j).getSpeedY() * -1);
//                        alBalls.get(j).addY(speedYj);
//                        System.out.println("Move " + alBalls.get(i));
//                        move = 0;
//                        move(i, alBalls.get(i).getSpeedX(), alBalls.get(i).getSpeedY());
//                        move(j, alBalls.get(j).getSpeedX(), alBalls.get(j).getSpeedY());
//                    }
//                }
//            }

            move(i, alBalls.get(i).getSpeedX(), alBalls.get(i).getSpeedY());

            int x = alBalls.get(i).getX();
            int y = alBalls.get(i).getY();
            int size = alBalls.get(i).getSize();

            if (null != alBalls.get(i).getEmo()) {
                switch (alBalls.get(i).getEmo()) {
                    case "BigSmile":
                        emoBigSmile.drawBigSmile(g, x, y, size);
                        break;
                    case "Smile":
                        emoSmile.drawSmile(g, x, y, size);
                        break;
                    case "Sad":
                        emoSad.drawSad(g, x, y, size);
                        break;
                    case "Surprised":
                        emoSurprised.drawSurprised(g, x, y, size);
                        break;
                    case "Tongue":
                        emoTongue.drawTongue(g, x, y, size);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
