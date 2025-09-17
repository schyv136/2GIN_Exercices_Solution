
import java.util.ArrayList;

/**
 * @author fred faber
 */
public class Fibonacci {
    
    /**
     * Les nombres de Fibonacci croissent si rapidement, que les types 
     * numériques sont vite dépassés.
     * Limite pour Integer : val maximale: 47 (>47 -> wrong numbers)
     * Limite pour Long    : val maximale: 93 (>93 -> wrong numbers)
     * Limite pour Double  : val maximale: 1478 (-> Infinity)
     */
    private ArrayList<Long>   alFibo = new ArrayList<>();
    private ArrayList<Double> alGold = new ArrayList<>();

    public Fibonacci(int n) {
        n = Math.abs(n);
        alFibo.add((long) 0);
        alFibo.add((long) 1);
        for (int i = 2; i < n; i++) {
            alFibo.add(alFibo.get(i - 2) + alFibo.get(i - 1));
            alGold.add((double) alFibo.get(i) / alFibo.get(i - 1));
        }
    }

    public void clear() {
        alFibo.clear();
        alGold.clear();
    }

    public Object[] fiboToArray() {
        return alFibo.toArray();
    }

    public Object[] goldToArray() {
        return alGold.toArray();
    }

}
