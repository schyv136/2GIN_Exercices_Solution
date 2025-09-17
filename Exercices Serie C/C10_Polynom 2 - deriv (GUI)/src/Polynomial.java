
import java.util.ArrayList;

/**
 * @author Michel Mercatoris & Fred Faber
 * @version 12/12/2011 08:44:34
 */

public class Polynomial {

    private ArrayList<Double> alCoefficients = new ArrayList<>();

    public void add(double pCoeff) {
        alCoefficients.add(pCoeff);
    }

    public int size() {
        return alCoefficients.size();
    }

    public double getCoefficient(int i) {
        if (alCoefficients.size() > i) {
            return alCoefficients.get(i);
        } else {
            return 0;
        }
    }

    public double evaluateNaive(double pX) {
        double result = 0;
        for (int i = 0; i < alCoefficients.size(); i++) {
            result = result + alCoefficients.get(i) * Math.pow(pX, i);
        }
        return result;
    }

    public double evaluateHorner(double pX) {
        double result = 0;
        for (int i = alCoefficients.size() - 1; i >= 0; i--) {
            result = result * pX + alCoefficients.get(i);
        }
        return result;
    }

    @Override
    public String toString() {
        String s = " = ";
        if (alCoefficients.size() > 0) {
            for (int i = 0; i < alCoefficients.size(); i++) {
                s = " + " + alCoefficients.get(i) + "x^" + i + s;
            }
            return s;
        } else {
            return "";
        }

    }

    public Object[] toArray() {
        return alCoefficients.toArray();
    }

//**************************************************************************
    
    public Polynomial differentiate() {
        Polynomial deriv = new Polynomial();
        for (int i = 1; i < alCoefficients.size(); i++) {
            deriv.add(i * alCoefficients.get(i));
        }
        return deriv;
    }

}
