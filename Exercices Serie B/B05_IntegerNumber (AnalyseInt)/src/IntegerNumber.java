/**
 * Cette classe représente un nombre entier.
 * La classe possède un nombre entier sur lequel s'effectuent tous les tests
 * 
 * @author     fabfr
 * @version    18/05/2011 
 */
public class IntegerNumber
{

    /** The target number for all operations */
    private int number;

    /**
    * constructeur
    * @param pNum    le nombre à analyser, supposé positif
    */
    public IntegerNumber(int pNum)
    {
    	number = pNum;
    }
	
    /**
    * Accesseur pour le nombre à analyser
    * @return      le nombre à analyser
    */
    public int getNumber()
    {
    	return number;
    }

    /**
    * Retourne true ssi le nombre n est divisible par deux
    * @return     la parité
    */
    public boolean isEven() 
    {
        //version 1 :
        int n = Math.abs(number);
        if (n % 2==0)
        {
            return true;
        }
        else
        {
            return false;
        }

        //version 2 : - la plus élégante -
        // return Math.abs(number) % 2 == 0;
     }

    /**
    * Retourne true si le nombre n possède exactement deux diviseurs
    * @return   true ssi le nombre est premier
    */
    public boolean isPrime() 
    {
    //Version 1 -la plus lente-
    /*
        int n = Math.abs(number);
        int nDivi=0;
	   for (int i=1 ; i<=n ; i++)
	   {
            if (n % i == 0)
            {
                nDivi++;
            }
	   }
	   return nDivi == 2;
	*/		

          int n = Math.abs(number);
          int count = 0; 
		for (int i=2; i<n; i++) 
			if (n % i ==0) count++;
		//return  count==0; //résultat incorrect pour n=0 et n=1
		return n>1 && count==0;
		
		
		/* Version 2: -très rapide-
		   Idée: Tester s'il existe un diviseur >1 et <n
		   Dans ce cas on peut s'arrêter de tester à sqrt(n), car
		   s'il n'existe pas de diviseur <= sqrt(n), alors
		   il ne peut pas exister de diviseur >sqrt(n) et <n ...
		 */
		 
	/* 
          int n = Math.abs(number);
		int i=2;
		while (i<=Math.sqrt(n)  &&  n%i != 0) i++;
		return  n==2 || n%i!=0 && n>1;
		//Les conditions n==2 et n>1 sont nécessaires pour 
		//que la méthode retourne aussi un résultat correct 
		//pour n=1(false) et n=2 (true)
	 */
    }

    /**
    * Retourne la somme des diviseurs du nombre
    * @return   la somme des diviseurs de n
    */
    public int sumOfDividers() 
    {
        int n = Math.abs(number);
        int sumDiv=0;
	for (int i=1 ; i<=n ; i++)
	{
            if (n % i == 0)
            {
               sumDiv = sumDiv + i;
            }
        }
	return sumDiv;
    }

    /**
    * Retourne true ssi la somme des diviseurs du nombre
    * est égale au double du nombre
    * @return   true ssi n est parfait
    */
    public boolean isPerfect() 
    {
        return sumOfDividers() == 2*Math.abs(number);
    }

    /**
    * Retourne true ssi la somme des diviseurs du nombre
    * est strictement inférieure au double du nombre
    * @return   true ssi le nombre est déficient
    */
    public boolean isDeficient() 
    {
        return sumOfDividers() < 2*Math.abs(number);
    }

    /**
    * Retourne true ssi la somme des diviseurs du nombre
    * est strictement supérieure au double du nombre
    * @return   true ssi le nombre est abondant
    */
    public boolean isAbundant() 
    {
        return sumOfDividers() > 2*Math.abs(number);
    }

    /**
    * Retourne true ssi la somme des diviseurs de deux nombres
    * donnés est identique
    * @param pNumM  le nombre à comparer avec n
    * @return   true ssi les nombres pM et n sont amicaux
	 */
    public boolean isFriendlyTo(int pNumM)
    {
    	//comme on ne peut pas appliquer sumOfDividers à pM, 
    	//la méthode la plus simple est de calculer
    	//la somme des diviseurs de M par une boucle.
    	int sumDivM=0;
	for (int i=1 ; i<=pNumM ; i++)
        {
	   if (pNumM % i == 0)
           {
              sumDivM = sumDivM + i;
           }
        }
     	return sumOfDividers() == sumDivM;	//true ssi les nombres sont amicuax
    }

    /**
     * Renverse l'ordre des chiffres dans number
     * @return le nombre renversé
     */
    public int reverse()
    {
        int n = Math.abs(number);
    	int res = 0;
    	while (n != 0)
        {
    	    res = n % 10 + res * 10;
    	    n = n / 10;
    	}
    	return res;
    }

    /**
     * Retourne true ssi le nombre donné est un palindrome 
     */
    public boolean isPalindrome()
    {
        int n = Math.abs(number);
    	return n == reverse(); //true ssi la version renversée est égale au nombre
    }
}