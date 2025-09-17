/**
 * Classe représentant des jeux
 * 
 * @author     fred
 * @version    27/12/2011 14:21:44
 */
public class Game
{
	/** le titre du jeu */
	private String title;

	/** la catégorie du jeu */
	private String category;

	/** le système cible (console) */
	private String system;

	/** la catégorie d'âge du jeu */
	private int usk;

	/** le prix du jeu en € */
	private double price;

	/**
	 * Constructeur initialisant tous les attributs
	 * @param pTitle       le titre du jeu
	 * @param pCategory    la catégorie du jeu
	 * @param pSystem      le système cible (console)
	 * @param pUsk         la catégorie d'âge du jeu 
	 * @param pPrice       le prix du jeu en €
	 */
	public Game(String pTitle, String pCategory, String pSystem, int pUsk, double pPrice)
	{
		title 	= pTitle;
		category	= pCategory;
		system	= pSystem;
		usk		= pUsk;
		price	= pPrice;
	}

	/**
	 * Accesseur pour le titre du jeu
	 * @return               le titre du jeu
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Accesseur pour la catégorie du jeu
	 * @return                la catégorie du jeu
	 */
	public String getCategory()
	{
		return category;
	}

	/**
	 * Accesseur pour le système cible (le type console)
	 * @return                le système cible (console)
	 */
	public String getSystem()
	{
		return system;
	}

	/**
	 * Accesseur pour la catégorie d'âge du jeu
	 * @return                la catégorie d'âge du jeu
	 */
	public int getUsk()
	{
		return usk;
	}

	/**
	 * Accesseur pour le prix du jeu en € 
	 * @return                le prix du jeu en € 
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * Retourne une description textuelle du jeu
	 * @return                un texte décrivant le jeu
	 */
	public String toString()
	{
		return title + " ("+category+", "+system+", USK"+usk+", "+price+"€)";
	}


	
}