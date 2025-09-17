/**
 * Classe décrivant une personne
 * 
 * @author     georges
 * @version    16/08/2019 19:08:18
 */
public class Person
{

	private String name;
	private int age;

	public Person(String pName, int pAge)
	{
		name = pName;
		age = pAge;
	}

	public String toString()
	{
		return name + " (" + age + " years)";
	}
}