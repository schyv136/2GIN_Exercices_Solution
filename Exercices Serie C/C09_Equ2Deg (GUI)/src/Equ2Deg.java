import java.util.ArrayList;

/**
 * Classe qui sert à résoudre des équations de la forme: 
 *   ax^2 + bx + c = 0   ( pour a,b,c ∈ IR )
 * Les solutions sont fournies dans une ArrayList
 * Quelques méthodes booléennes permettent de déterminer le 
 * type d'équation.
 * En principe, la méthode getDegree et isIndeterminiate
 * devraient suffire
 * 
 * @author     fabfr
 * @version    21/12/2011 
 */
public class Equ2Deg
{
	/**	coefficients de l'équation */
	private double a,b,c;
	
	/**	solutions de l'équation */
	private ArrayList<Double> alSolutions = new ArrayList<>();
	
	/**
	 * Constructeur: initialise les attributs	  
	 * @param pA   valeur pour le coefficient a
	 * @param pB   valeur pour le coefficient b
	 * @param pC   valeur pour le coefficient c
	 */
	public Equ2Deg(double pA, double pB, double pC)	{
		a=pA;
		b=pB;
		c=pC;
	}

        /**
         * Retourne le degré de l'équation
         * @return le degré effectif de l'équation
         */
        public int getDegree() {
            if (a!=0)      return 2;
            else if (b!=0) return 1;
            else           return 0;
        }

	/**
	 * Détermine s'il s'agit d'une équation du second degré
	 * @return true ssi il s'agit d'une équation du second degré
	 */
	public boolean isQuadratic()	{
		return getDegree()==2;
	}

	/**
	 * Détermine s'il s'agit d'une équation du premier degré
	 * @return true ssi il s'agit d'une équation du premier degré
	 */
	public boolean isLinear()	{
		return getDegree()==1;
	}

	/**
	 * Détermine s'il s'agit d'une équation constante
	 * @return true ssi il s'agit d'une équation constante
	 */
	public boolean isConstant()	{
		return getDegree()==0;
	}

	/**
	 * Détermine s'il s'agit d'une équation constante de la forme 0x=0
	 * @return true ssi il s'agit d'une équation constante de la forme 0x=0
	 */
	public boolean isIndeterminate()  {
		return (a==0 && b==0 && c==0);
	}

	/**
	 * retourne les solutions comme Array pour la représentation dans une JList 
         * @return les solutions comme Array
         */
	public Object[] solutionsToArray()	{
		solve(); //pas nécessaire, mais plus sûr...
		return alSolutions.toArray();
	}

        /**
         * retourne le nombre de solutions.
         * Type retour du type Double pour pouvoir retourner Double.POSITIVE_INFINITY
         * @return le nombre de solutions
         */
        public Double getNumberOfSolutions()	{
		solve(); //pas nécessaire, mais plus sûr...
                if (isIndeterminate()) 
                    return Double.POSITIVE_INFINITY;
                else 
                    return Double.valueOf(alSolutions.size());
	}

	/**
	 * Mémorise les solutions de l'équation dans la liste des solutions.
	 * mémorise plus que 2 solutions si l'équation admet une infinité de solutions
	 */
	public void solve()	{
		//réinitialiser la liste des solutions
		alSolutions.clear();
		if (a!=0) {  //équation du second degré
			double delta=b*b-4*a*c;
			if (delta==0) {
			   	alSolutions.add(-b/(2*a));
			}
			else if (delta>0) {
				alSolutions.add((-b+Math.sqrt(delta))/(2*a));
			   	alSolutions.add((-b-Math.sqrt(delta))/(2*a));
			}
			else  ; //pas de solutions
		}
                else { //a=0 -> équation du premier degré
			if (b==0 && c==0) { 
				alSolutions.add(Double.NEGATIVE_INFINITY); //0x=0  -> S=IR
				alSolutions.add(0.0);
				alSolutions.add(Double.POSITIVE_INFINITY);
			}
			else if (b==0)    ; //c=0:  0x!=0 -> S=vide
			else alSolutions.add(-c/b); 
		}		
	}



	/**
	 * retourne une description de l'équation sous forme de texte
	 * @return                la chaîne représentant l'équation
	 */
	public String toString()
	{
		 //return a+" * x^2 + "+b+" * x + "+c+" = 0";
		 //version améliorée:
		 String s="";
		 if (a!=0) { 
		     if (a!=1) s=s+a+"*";
		     s=s+"x^2";

		 }
		 if (b!=0) {
		     if (b>=0  && a!=0) s=s+" + ";
		     if (b!=1) s=s+b+"*";
		 	s=s+"x";

		 }
		 if (c!=0 || a==0 && b==0)  {
			if (c>=0 && (a!=0 || b!=0)) s=s+" + ";
			s=s+c;
		 }
		 s=s+" = 0";  
		 return s;   
	}

}
	