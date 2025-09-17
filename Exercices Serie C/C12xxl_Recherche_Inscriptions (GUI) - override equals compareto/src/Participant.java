
/**
 * Cette classe représente un participant aux inscriptions
 *
 * @author     robertfisch
 * @version 01/02/2011 08:42:31
 */
public class Participant {

    private String firstname;
    private String name;
    private int birthYear;

    public Participant(String pFirstname, String pName, int pBirthYear) {
        firstname = pFirstname;
        name = pName;
        birthYear = pBirthYear;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getFullName() {
        return name + " " + firstname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public boolean equals(Participant pP) //la vérification de l'égalité se fait par le nom complet!
    {
        return getFullName().equals(pP.getFullName());
    }

    public int compareTo(Participant pP) {  //la comparaison se fait par le nom complet!
        return getFullName().compareTo(pP.getFullName());
    }

    public boolean isOlder(Participant pP) {
        return birthYear > pP.birthYear;
    }

    public boolean isYounger(Participant pP) {
        return birthYear < pP.birthYear;
    }

    @Override
    public String toString() {
        return getFullName() + " (*" + birthYear + ")";
    }
}
