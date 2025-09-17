
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yvonschubert
 */
public class AnalogWatch {
    
    private int xCenter;
    private int yCenter;
    private Point center;
    private int radius;
    private final int numberOfTicks=60;
    private final int majorTick=5;

    
    public Point polar2cart(Point pCenter, double pRadius, double pAngle) {
        int x = (int) (pCenter.x + pRadius * Math.sin(pAngle));
        int y = (int) (pCenter.y - pRadius * Math.cos(pAngle));
        Point polar=new Point(x,y);
        return polar;
    }
    
    public void paintComponent(Graphics g, int w, int h) {
        LocalDateTime now = LocalDateTime.now();

        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        
        //set gray background
        Color backgroundGray = new Color(214, 217, 223);
        g.setColor(backgroundGray);
        g.fillRect(0, 0, w, h);
        
        //define radius and center coordinates
        //20% offset (1-0.2=0.8) from edge & radius=diameter*0.5
        // Calculs préliminaires  
        radius = (int) (Math.min(w, h) * 0.8 * 0.5);
        xCenter = w / 2;
        yCenter = h / 2;
        center=new Point(xCenter, yCenter);
        

        //********************draw oval and border of clock ********************
        Color brightYELLOW = new Color(255, 255, 153);
        g.setColor(brightYELLOW);
        g.fillOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
        g.setColor(Color.BLUE);
        g.drawOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
        
        //*************************draw ticks***********************************
        //
        // Variables utilisées par la suite        
        Point p1; //major ticks
        Point p2; //minor ticks
        double angle; //angle en radians
        // Dessine les graduations        
        int lengthTick = (int) (radius * 0.1);
        int lengthMajorTick = (int) (radius * 0.2);
        for (int i=0; i < numberOfTicks; i++)
        {
            //p1 et p2 commencent au centre du cadran
            //p1 sert à trouver le point de départ de la graduation
            //p2 sert à trouver le point d'arrivée de la graduation 
            //p2 se termine toujours sur la bordure du cadran
            angle = (i / (double)numberOfTicks) * 2*Math.PI;
            p2 = polar2cart(center, radius, angle); 
            if (i % majorTick == 0)
                p1 = polar2cart(center, radius-lengthMajorTick, angle);
            else
                p1 = polar2cart(center, radius-lengthTick, angle);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
        //***********************draw date**************************************
        g.setColor(Color.BLUE);
        g.setFont(new Font("Tahoma", Font.PLAIN, radius/10));
        g.drawString(day + "." + month + "." + year, xCenter - radius, yCenter + radius);
        
        //***************change the line with of the minute and hour hand*******
        Graphics2D g2d = (Graphics2D)g;
        int lineWidth = 8;
        g2d.setStroke(new BasicStroke(lineWidth));
        //***********************draw minute hand*******************************
        int mLength = (int) (radius * 0.25);
        angle=minute * ( Math.PI*2/ 60);
        Point mHand =polar2cart(center,radius-mLength,angle);
        g2d.setColor(Color.BLUE);
        g2d.drawLine(xCenter, yCenter, mHand.x, mHand.y);

        //***********************draw hour hand********************************* 
        int hLength = (int) (radius * 0.5);
        angle=(hour % 12 + minute / 60.0) * (2 * Math.PI / 12);
        Point hHand =polar2cart(center,radius-hLength,angle);
        g2d.setColor(Color.BLUE);
        g2d.drawLine(xCenter, yCenter, hHand.x, hHand.y);
        
        
        //***************change the line with of second hand*******
        //change line width back to normal width
        lineWidth = 2;
        g2d.setStroke(new BasicStroke(lineWidth));
        
        //***********************draw second hand*******************************
        int sLength = (int) (radius * 0.15);
        angle=second * (2 * Math.PI / 60);
        Point sHand =polar2cart(center,radius-sLength,angle);
        Color darkORANGE = new Color(255, 128, 0);
        g.setColor(darkORANGE);
        g.drawLine(xCenter, yCenter, sHand.x, sHand.y);
    }
    
}
