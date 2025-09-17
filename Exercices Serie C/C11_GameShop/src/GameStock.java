/**
 * Le stock de jeux d'un magasin
 * 
 * @author     fred
 * @version    27/12/2011 14:36:53
 */
import java.util.ArrayList;

public class GameStock
{
	
	/** La liste des jeux du magasin */
	private ArrayList<Game> alGames = new ArrayList<>();

	/** retour de la liste sous forme de tableau -> JList
	 * @return le tableau des jeux
	 */
	public Object[] toArray()
	{
		return alGames.toArray();
	}

	/** retourne le nombre de jeux
	 * @return le nombre de jeux
	 */
	public int size()
	{
		return alGames.size();
	}

	/** Ajout d'un jeu à la liste 
	 * @param le jeu à ajouter
	 */
	public void add(Game g)
	{
		alGames.add(g);
	}

	/** retourne le jeu à la position i
	 * @return le jeu à la position i
	 * @param i	la position du jeu à retourner
	 */
	public Game get(int i)
	{
		return alGames.get(i);
	}
	
	/** suppression du jeu à la position i
	 * @param i	la position du jeu à retourner
	 */
	public Game remove(int i)
	{
		return alGames.remove(i);
	}

	
	/** retourne la valeur totale du stock
	 * @return la valeur totale du stock
	 */
	public double totalValue()
	{
		double result = 0;
		for(int i=0 ; i<size() ; i++)
			result = result + alGames.get(i).getPrice();
		return result;
	}
	
	
}