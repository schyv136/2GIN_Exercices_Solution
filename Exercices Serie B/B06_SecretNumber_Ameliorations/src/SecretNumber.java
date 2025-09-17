/**
<b>Réalisation du jeu suivant :</b>
<ul>
    <li>L'ordinateur choisit un number au hasard entre 1 et 100.</li>
    <li>L'utilisateur doit trouver ce number par essais successifs en appelant la méthode « String guessNumber(int) ».</li>
    <li>A chaque fois que l'utilisateur a entré un number, l'ordinateur répond par l'une des trois réponses :
        <ul>
            <li>"number trop grand", </li>
            <li>"number trop petit" ou </li>
            <li>"bravo, trouvé".</li>
            </ul>
        L'ordinateur indique dans la même phrase le number total d'essais fait jusqu'à présent.
    </li>
</ul>
*/

public class SecretNumber
{
    /** le nombre maximal pour ce jeu     <<< nouveau */
    private int maximum  = 0;
    
    /** le nombre secret à trouver    */
    private int secret  = 0;
    
    /** le compteur de tentatives     */
    private int counter = 0;  
    
    /** nombre trouvé?                    <<< nouveau */
    private boolean found = false;

    /**
     * Constructeur pour initialiser le nombre secret par une valeur
     * aléatoire entre 1 et n.
     * Le compteur des essais est mis à zéro
     * @param pMaximum      Le nombre maximum pour le nombre secret
     */
    public SecretNumber(int pMaximum)
    {
        maximum = pMaximum;         //<<< nouveau
        secret = (int)(Math.random() * pMaximum) + 1;
        counter = 0;
    }

    //accesseurs / getters
    public int getMaximum() {       //<<< nouveau
        return maximum;
    }

    public int getCounter() {
        return counter;
    }

    public boolean isFound() {      //<<< nouveau
        return found;
    }

    /**
     * Méthode pour deviner le nombre que l'ordinateur a calculé.     
     * Retour d'un code numérique
     * @param   pGuessedNumber	Le nombre dont l'utilisateur croit qu'il s'agit du nombre à deviner.
     * @return                  Un code de retour
     *                              0  = nombre trouvé!
     *                              1  = nombre entré trop grand
     *                              -1 = nombre entré trop petit
     */
    public int compareTo(int pGuessedNumber) 
    {
        if(pGuessedNumber==secret)
        {
            counter=getCounter()+1;
            found = true;               //<<< nouveau
            return 0;
        }
        else if (pGuessedNumber>secret)
        { 
            counter=getCounter()+1;
            return 1;
        }
        else
        {
            counter=getCounter()+1;
            return -1;
        }
    }
        
    /**
     * Méthode pour deviner le nombre que l'ordinateur a calculé.     
     * Retour d'un message textuel explicite en anglais
     * @param   pGuessedNumber	Le nombre dont l'utilisateur croit qu'il s'agit du nombre à deviner.
     * @return          			Un message relatif au nombre entré par l'utilisateur.
     */
    public String guess(int pGuessedNumber) 
    {
        if(pGuessedNumber==secret)
        {
            found = true;               //<<< nouveau
            counter=getCounter()+1;
            
            //version simple :
//            return "Well done! You found the secret number at the "+counter+"th guess.";
            
            //version perfectionnée :
            String ending="th";  
            if (getCounter() % 100 != 11  &&     //...eleventh   ...11th
                getCounter() % 100 != 12  &&     //...twelfth    ...12th
                getCounter() % 100 != 13)        //...thirteenth ...13th
            {                               //but generally :
               if      (getCounter() % 10 == 1) ending = "st";   //...first  ...1st
               else if (getCounter() % 10 == 2) ending = "nd";   //...second ...2nd 
               else if (getCounter() % 10 == 3) ending = "rd";   //...third  ...3rd
            }
            return "Well done! You found the secret number at the " + getCounter() + ending + " guess.";
        }
        else if (pGuessedNumber>secret)
        { 
            counter=getCounter()+1;
            return "Your number is too big.";
        }
        else
        {
            counter=getCounter()+1;
            return "Your number is too small.";
        }
    }

}