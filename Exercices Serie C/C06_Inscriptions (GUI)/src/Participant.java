
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

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return name + " " + firstname + " (*" + birthYear + ")";
    }
}
