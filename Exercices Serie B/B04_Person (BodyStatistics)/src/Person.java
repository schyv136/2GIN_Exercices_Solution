public class Person
{

    /** l'age en "années"   */
    private int    age;
    /** la taille en "cm"   */
    private double height;
    /** le poids en "kg"    */
    private double weight;
    /** le sexe ( 0 ou 1 )  */
    private int    gender; // 0 <=> masculin ; 1 <=> féminin

	/**
	 * constructeur
	 * @param pAge	l'age en années
	 * @param pHeight	la taille en cm
	 * @param pWeight	le poids en kg
	 */
	public Person(int pAge, double pHeight, double pWeight, int pGender)
	{
		age    = pAge;
		height = pHeight;
		weight = pWeight;
		gender = pGender;
	}

    /**
	 * Méthode pour calculer le poids normal suivant la
	 * formule de Broca
	 * @return         le poids normal en "kg"
	 */
    public double getNormalWeight()
    {
       // return 50 + (height-150) / 4.0 + (age-20) / 4.0;
       return height - 100;
    }

    /**
	 * Méthode pour calculer le poids idéal d'un homme suivant la
	 * formule de Broca
	 * @return         le poids idéal d'un homme en "kg"
	 */
    public double getIdealWeight()
    {
       if (gender==1)
       {
          return getNormalWeight() * 0.85;
       }
       else
       {
          return getNormalWeight() * 0.9;
       }
    }


   /**
	 * Méthode pour calculer le BMI
	 * @return         le BMI
	 */
    public double getBMI()
    {
        return weight / Math.pow(height/100, 2);
    }

    /**
	 * Méthode retournant un commentaire sur le BMI de la personne
	 * @return         le commentaire
	 */
    public String getComment()
    {
        if (age<19)
        {
            return "Under 19 years: no BMI defined.";
        }
        else
        {
            double bmi = getBMI();

            //adaptation du bmi selon l'âge
            if      (age>=65) bmi = bmi-3;
            else if (age>=55) bmi = bmi-2;
            else if (age>=45) bmi = bmi-1;
            else if (age>=35) bmi = bmi-0;
            else if (age>=25) bmi = bmi+1;
            else              bmi = bmi+2;

            //Commentaires
            if (gender==1)
            {
               //Femmes
               if      (bmi> 32.3) return "Obese";
               else if (bmi>=27.3) return "Overweight";
               else if (bmi>=25.8) return "Tendency overweight";
               else if (bmi>=19.1) return "Normal/ideal";
               else                return "Underweight";
            }
            else
            {
               //Hommes
               if      (bmi> 31.1) return "Obese";
               else if (bmi>=27.8) return "Overweight";
               else if (bmi>=26.4) return "Tendency overweight";
               else if (bmi>=20.7) return "Normal/ideal";
               else                return "Underweight";
            }
        }
    }

}