//Msimamisi Mwandla
//28/02/2022
//Vaccine Array Class

public class VaccineArray
{	
	//Array data structure
	Country[] countries = new Country[9999];

	int nextEntry; //Keeps track of next empty array index

	public static int insertOpCount = 0, searchOpCount = 0; // Instrumentation


	/**
	 * Constructor of VaccineArray object - instantiates class and populates fields
	 */
	public VaccineArray()
	{
		nextEntry = 0;
	}
	

	/**
	 * This method adds a Country object into the array
	 * @param c 
	 * 	  Country object to be added
	 */
	public void addItem(Country c)
	{
		countries[nextEntry] = c;
		nextEntry++;
		insertOpCount++;
	}


	/**
	 * This method finds the specified Country object in the array
	 * @param c
	 * 	  Country object to be found
	 * @return combination of Country name and number of vaccinations in String format
	 */
	public void findItem(Country c)
	{	
		int found = 0, searchOpCount = 0;
		for(int i=0; i<countries.length; i++)
		{	
			try
			{	searchOpCount++;

				if(c.compareTo(countries[i]) == 0)
				{
					System.out.println(countries[i].name +" = "+ countries[i].vaccNum);
					found++;
					System.out.println(Integer.toString(searchOpCount) +" search operations.\n");
				}
				else if(i == trueSize()-1 && found == 0)
				{
					System.out.println(c.name + " = <Not Found>");
					System.out.println(Integer.toString(searchOpCount) +" search operations.\n");
				}
		
			}
			catch(Exception e){}

		}

	}


	/**
	 * This method checks the actual number of items in array
	 * @return number of items in integer format 
	 */
	public int trueSize()
	{
		int count = 0;

		for(int i=0; i<countries.length; i++)
		{
			if(countries[i] instanceof Country)
			{
				count++;
			}
		}

		return count;
	}
}
