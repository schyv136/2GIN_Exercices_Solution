/**
 * Classe décrivant une voiture de sport
 * 
 * @author     georges
 * @version    16/08/2019 19:13:15
 */
public class SportsCar
{
	private String brand;
	private String model;
	private Person driver;
	private Person passenger;

	public SportsCar(String pBrand, String pModel)
	{
		brand = pBrand;
		model = pModel;
	}

	public void setDriver(Person pDriver)
	{
		driver = pDriver;
	}

	public void setPassenger(Person pPassenger)
	{
		passenger = pPassenger;
	}

//	public String toString()
//	{
//		return brand + " " + model;
//	}
        
	public String toString() //avancé...
	{
            String result = brand + " " + model;
            if (driver!=null)    result = result +",   Driver : "+driver;            
            if (passenger!=null) result = result +",   Passenger : "+passenger;
            return result;
	}
}