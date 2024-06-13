//Msimamisi Mwandla
//Country class
//28-02-2022

public class Country implements Comparable<Country>
{	
	/**
	 * Fields containing the country name, date and number of vaccinations
	 */
	String name, date, vaccNum;
	

	/**
	 * Constructor of Country object - passes user instance values to the fields
	 */
	public Country(String name, String date, String vaccNum)
	{
		this.name = name;
		this.date = date;
		this.vaccNum = vaccNum;
	}
	
	
	/**
	 * This method compares two objects, of type Country, for equality
	 * @param other
	 * 	  other Country object
	 * @return 0 if equal, non-zero integer otherwise
	 */
	public int compareTo(Country other)
	{
		int Sum = (this.name + this.date).compareTo(other.name + other.date);
		return Sum;
	}
	
	/**
	 * Method returns string representations of Country object fields
	 * @return Country name, date and number of vaccinations in String format
	 */
	public String toString()
	{
		return name +" "+ date +" "+ vaccNum;
	}
}
