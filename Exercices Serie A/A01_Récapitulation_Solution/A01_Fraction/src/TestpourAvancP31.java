/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SchYv136
 */
public class TestpourAvancP31 {
        /**
     * The main entry point for executing this program.
     */
    public static void main(String[] args) {
        //Pour avancés: Tests du constructeur avec des réels
        Fraction fraction3 = new Fraction(75.32);
        System.out.println("Fraction 3 = " + fraction3);
        
        for (int i = 0; i < 1000; i++) {
            double d = Math.random()*100-50;
            System.out.print(d);
            Fraction fraction = new Fraction(d);
            System.out.println(" \t -> " + fraction +
                               " \t -> "+fraction.getDecimal() + 
                               " \t diff: " + (d-fraction.getDecimal()));            
        }
    }
}
