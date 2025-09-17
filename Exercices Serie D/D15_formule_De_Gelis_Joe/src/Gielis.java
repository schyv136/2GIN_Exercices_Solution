
import java.awt.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ennur
 */
public class Gielis {
    private double a,b,m,n1,n2,n3,maxPHI;
//    private int np;

    public Gielis(double m, double n1, double n2, double n3, double phi) {
        this.m = m;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.maxPHI = phi;
    }

    public void setM(double m) {
        this.m = m;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public void setN3(double n3) {
        this.n3 = n3;
    }

    public void setPhi(double phi) {
        this.maxPHI = phi;
    }

    public double getM() {
        return m;
    }

    public double getN1() {
        return n1;
    }

    public double getN2() {
        return n2;
    }

    public double getN3() {
        return n3;
    }

    public double getMaxPHI() {
        return (maxPHI/100)*100.0;
    }
    
    private double polar2CartX(double angle, double radius){
        return radius * Math.cos(angle);
    }
    
    private double polar2CartY(double angle, double radius){
        return radius * Math.sin(angle);
    }
    
    public double evaluate(double a, double b){
        return Math.pow(Math.pow(Math.abs(Math.cos((m*maxPHI/4.0)/a)),n2)+Math.pow(Math.abs(Math.sin((m*maxPHI/4.0)/b)),n3), -1.0/n1);
    }
    
    public double evaluate(double phi){
        return Math.pow(Math.pow(Math.abs(Math.cos(m*phi/4.0)/a),n2)+ Math.pow(Math.abs(Math.sin(m*phi/4.0)/b),n3), -1.0/n1);
    }
    
    public void draw(Graphics g, int w, int h){
        g.setColor(Color.white);
        g.fillRect(0, 0, w, h);
        
        g.setColor(Color.blue);
        g.translate(w/2, h/2);
        
        this.a = w/4;
        this.b = h/4;
        
        for (double phi = 0 ; phi < maxPHI; phi+= 0.1) {
            var r = evaluate(phi);
            double x = polar2CartX(phi, r);
            double y = polar2CartY(phi, r);
            Point p = new Point((int) x, (int) y);
//            g.drawLine(p.x, p.y, p.x, p.y);
//            System.out.println(p.x+" : " + p.y);
            g.drawLine(0, 0, p.x, p.y);
        }
    }
    
}
