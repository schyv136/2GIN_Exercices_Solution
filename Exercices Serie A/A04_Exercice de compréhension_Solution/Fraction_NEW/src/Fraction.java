
/**
 * La classe Fraction sert à effectuer des opérations
 * standard entre fractions
 *
 * @author	Fred Faber, Georges Kugener
 * @version	30/07/2012
 */
public class Fraction {

    /**
     * Les attributs de la fraction: numérateur et dénominateur de la fraction
     */
    private int numerator;
    private int denominator;

    /**
     * Constructeur de la classe Fraction
     *
     * @param pNumerator	le numérateur de la nouvelle fraction
     * @param pDenominator	le dénominateur de la nouvelle fraction
     */
    public Fraction(int pNumerator, int pDenominator) {
        numerator = pNumerator;
        denominator = pDenominator;
    }

    /**
     * Pour avancés: Constructeur de la classe Fraction à partir d'un nombre décimal
     *
     * Première approche: 
     * Multiplier le réel et le diviseur par 10 jusqu'à obtenir un nombre entier au lieu du réel.
     * Idée en principe correcte mathématiquement, mais...
     * Danger: dépassement et boucle infinie pour différentes fractions, du à l'imprécision 
     * de la représentation de double dans la mémoire.
     * Le problème apparaît pour certains nombres lors de la multiplication du réel.
     * p.ex. pour 7.532 :  75.32 * 10  ->  753.1999999999999
     * Solution: ajouter des conditions qui évitent le dépassement
     * 
     * @param pDecimal le nombre décimal
     */
    public Fraction(double pDecimal) {
        long d = 1;                            //conditions pour éviter le dépassement
        while (pDecimal - (int) pDecimal != 0  && d * 10                  < Integer.MAX_VALUE  
                                               && Math.abs(pDecimal * 10) < Integer.MAX_VALUE ) {
            pDecimal = pDecimal * 10;
            d = d * 10;
//            System.out.println(pDecimal + " / " + d);
        }
        numerator = (int) pDecimal;
        denominator = (int) d;
        reduce();
    }
    
    /**
     * Pour avancés: Constructeur de la classe Fraction à partir d'un nombre décimal
     * Alternative:
     * Il faut éviter de dépasser le domaine de int ET
     * il faut éviter de comparer des valeurs double qui ont été modifiées (ici: multipliées)
     *  
     * @param pDecimal le nombre décimal
     */
//    public Fraction(double pDecimal) {
//        long d = 1; //type long, pour pouvoir détecter le dépassement de integer
//        while (Math.abs((long)(pDecimal * d)) < Integer.MAX_VALUE  && d<Integer.MAX_VALUE) {            
//            d = d * 10;
//        }
//        d = d/10; //car l'arrêt de la boucle se fait après le dépassement
//        numerator   = (int) (pDecimal * d);
//        denominator = (int) d;
//        reduce();
//    }


    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    /**
     * Retourner une représentation textuelle de la fraction.
     *
     * @return	le texte représentant la fraction
     */
    public String toString() {
        if (denominator != 1) {
            return numerator + " / " + denominator;
        } else {
            return numerator + ""; //forcer le type string
        }
    }

    /**
     * Retourner la valeur de la fraction comme nombre décimal attention à la
     * conversion forcée en double!
     *
     * @return le nombre décimal correspondant à la fraction
     */
    public double getDecimal() {
        if (denominator != 0) {
            return (double) numerator / denominator;
        } else {
            return Double.NaN;
        }
    }

    /**
     * Verifier si la fraction représente un nombre négatif ou non.
     *
     */
    public boolean isNegative() {
        return getDecimal() < 0;
    }

    /**
     * Calcul du PGCD (plus grand commun diviseur) du numérateur et dénominateur
     *
     * @return le PGCD
     */
    public int gcd() {
        /*
    	   	// Version 0

    	   	int a = numerator;
    	   	int b = denominator;
    	   	int result = 1;
    	   	for (int d = 1; d <= a; d++)
    	   	  	if ((a % d == 0) && (b % d == 0))
    	   		 	result = d;
    	   	return result;
         */

        // Version 1
        // Adaptation pour que la méthode fonctionne
        // avec des nombres négatifs
        int a = Math.abs(numerator);
        int b = denominator;
        int result = 1;
        for (int d = 1; d <= a; d++) {
            if ((a % d == 0) && (b % d == 0)) {
                result = d;
            }
        }
        return result;

        /*       
        	// Version 2
        	
		// Amélioration pour diminuer le nombre d'itérations 
        
         	int a = Math.abs(numerator);
    	   	int b = Math.abs(denominator);
   
         	// Déterminer le minimum de a et b pour éviter des
    		// itérations inutiles dans la boucle while
         	int min = a;
         	if (b<a) 
            	min=b;

          // En utilisant une boucle while descendante
    		// on peut s'arrêter dès qu'on a trouvé un diviseur commun  	
         	while ((a % min != 0) || (b % min != 0))
             	min--;
         	return min;
         */
        // Version 3 
/*
        	// Division euclidienne
        	int a = Math.abs(numerator);
    	   	int b = Math.abs(denominator);
        	int help;
        	while (a%b != 0)
        	{
        		help = a % b;
        		a = b;
        		b = help;
        	}
        	return b;
         */
    }

    /**
     * Calcul du PPCM (plus petit commun multiple) de deux nombres entiers
     *
     * @return le PPCM
     */
    public int lcm() {
        return Math.abs(numerator * denominator) / gcd();
    }

    /**
     * Simplifier la fraction
     */
    public void reduce() {
        if (denominator != 0) {
            int g = gcd();
            numerator = numerator / g;
            denominator = denominator / g;
        }
    }

    /**
     * Inverser la fraction.
     */
    public void reciprocal() {
        /* On doit utiliser une variable temporaire pour
		 *  permuter le numérateur et le dénominateur
         */

        int temp = numerator;
        numerator = denominator;
        denominator = temp;
    }

    /**
     * Additionner une fraction donnée à la fraction actuelle
     *
     * @param pFract	la fraction à ajouter
     */
    public void add(Fraction pFract) {
        numerator = numerator * pFract.denominator + denominator * pFract.numerator;
        denominator = denominator * pFract.denominator;
        reduce();
    }

    /**
     * Soustraire une fraction donnée de la fraction actuelle
     *
     * @param pFract	la fraction à soustraire
     */
    public void subtract(Fraction pFract) {
        numerator = numerator * pFract.denominator - denominator * pFract.numerator;
        denominator = denominator * pFract.denominator;
        reduce();
    }

    /**
     * Multiplier la fraction actuelle par une fraction donnée
     *
     * @param pFract	la fraction à multiplier
     */
    public void multiply(Fraction pFract) {
        numerator = numerator * pFract.numerator;
        denominator = denominator * pFract.denominator;
        reduce();
    }

    /**
     * Diviser la fraction actuelle par une fraction donnée
     *
     * @param pFract	la fraction par laquelle il faut diviser
     */
    public void divide(Fraction pFract) {
        numerator = numerator * pFract.denominator;
        denominator = denominator * pFract.numerator;
        reduce();
    }

}
