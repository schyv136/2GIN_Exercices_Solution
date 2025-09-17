/**
 * Write a description of class "Personne" here.
 * 
 * @author     robertfisch
 * @version    27/08/2012 20:11:34
 */
public class Person
{
	/** 
	 *  matricule
	 *  
	 *  En fait, il faut que ce soit un String car les étrangers
	 *  en recoivent une qui contient une lettre!
	 */
	private String id;

	private String name;
	private String firstname;
	
	private String email;

	private Person mother;
	private Person father;
}