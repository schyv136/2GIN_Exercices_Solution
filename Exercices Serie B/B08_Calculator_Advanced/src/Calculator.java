/**
 Une calculatrice assez simpliste
 Tous les calculs se font avec la valeur actuelle (currentValue)
 Les résultats des calculs sont sauvegardés dans currentValue.
 => Tous les calculs changent directement currentValue
 @author		Fred Faber
 @version		17.11.2011
*/

public class Calculator
{
    /** la valeur actuelle de la calculatrice */
    private double currentValue = 0;
    private String operator="";
    private boolean errorNote=false; 
    

    /**
     * Constructeur
     * @param valeur initiale
     */
    public Calculator(double val)
    {
        currentValue = val;
    }

   /**
    * Retourne la valeur actuelle
    * @return        la valeur actuelle
    */

    public double getCurrentValue() 
    {
        return currentValue;
    }
    
     public String getOperator() 
    {
        return operator;
    }
    public boolean getErrorNote() 
    {
        return errorNote;
    }
     

    /** 
    * Modifie la valeur actuelle 
    * @param pValue  la nouvelle valeur actuelle
    */
    public void setCurrentValue(double pValue)
    {
        currentValue = pValue;
    }
    
    public void setOperator(String pOperator) 
    {
        operator=pOperator;
    }
    public void setErrorNote(boolean pError) 
    {
        errorNote=pError;
    }

    /**
	 * Ré-/Initialise la calculatrice/la valeur actuelle à zéro.
	 */
    public void clear()
    {
        currentValue = 0;
    }

    /**
	 * Ajoute un nombre à la valeur actuelle
	 * @param pNumber  le nombre à ajouter
	 */
    public void add(double pNumber) 
    {
        currentValue = currentValue + pNumber;
        //ou bien: currentValue += pNumber;
    }

    /**
	 * Soustrait un nombre de la valeur actuelle
	 * @param pNumber  le nombre à soustraire
	 */
    public void subtract(double pNumber) 
    {
        currentValue = currentValue - pNumber;
        //ou bien: currentValue -= pNumber;
    }

    /**
	 * Multiplie la valeur actuelle par un nombre
	 * @param pNumber  le nombre par lequel il faut multiplier
	 */
    public void multiplyBy(double pNumber) 
    {
        currentValue = currentValue * pNumber;
        //currentValue *= pNumber;
    }

    /**
	 * Divise la valeur actuelle par un nombre
	 * @param pNumber  le nombre par lequel il faut diviser
	 */
    public void divideBy(double pNumber) 
    {
        if(pNumber!=0)
        {
        currentValue = currentValue / pNumber;
        }
        else
        {
            errorNote=true;
        }
        //ou bien: currentValue /= pNumber;
    }

    /** Calcule le carré de la valeur actuelle */
    public void sqr()
    {
        currentValue = Math.pow(currentValue,2);
    }

    /** Calcule la racine carrée de la valeur actuelle */
    public void sqrt()
    {
        currentValue = Math.sqrt(currentValue);
    }

    /** Arrondit la valeur actuelle */
    public void round()
    {
        currentValue = Math.round(currentValue);
    }

    /** Calcule le sinus de la valeur actuelle*/
    public void sin()
    {
        currentValue = Math.sin(currentValue);
    }

    /** Calcule le cosinus de la valeur actuelle */
    public void cos()
    {
        currentValue = Math.cos(currentValue);
    }

    /** Calcule la tangente de la valeur actuelle */
    public void tan()
    {
        currentValue = Math.tan(currentValue);
    }

    /** Calcule la factorielle ( currentValue! ) 
     *  de la valeur actuelle après l'avoir arrondie
     *  maximum pour le type double :  170!
     */
    public void factorial()
    {
        int n = (int)Math.abs(Math.floor(currentValue));
        currentValue = 1;
        for (int i=1 ; i<=n ; i++)
	{
                currentValue = currentValue *i;
	}
    }

 
}
