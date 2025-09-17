/**
 * @author fabfr297
 */
public class TestSpeed {
        public static void main(String args[]) {
            Polynomial poly = new Polynomial();
            poly.add(-3009.8);
            poly.add(4293.2);
            poly.add(-938.65);
            poly.add(Math.PI);
            poly.add(232.5);
            poly.add(2.89);
            poly.add(0);
            poly.add(-874.6);
            poly.add(-5893);
            poly.add(-0.0009823);
            poly.add(1.278936);
            poly.add(-4.278936);
            poly.add(0.2890379);
            System.out.println(poly);
            
            long start = System.nanoTime();
//            System.out.println(poly.evaluateNaive(76));
            for (int i = 0; i < 200000; i++) {
                poly.evaluateNaive(Math.random()*200-100);                
            }
            long stop = System.nanoTime();
            System.out.println("Calculation time \"Naïve\" : "+(stop-start)/1000000.0+" ms");
            
            start = System.nanoTime();
//            System.out.println(poly.evaluateHorner(76));
            for (int i = 0; i < 200000; i++) {
                poly.evaluateHorner(Math.random()*200-100);                
            }
            stop = System.nanoTime();
            System.out.println("Calculation time \"Horner\" : "+(stop-start)/1000000.0+" ms");
            
        }

}
