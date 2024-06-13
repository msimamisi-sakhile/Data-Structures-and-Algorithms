//Msimamisi Mwandla
//Vaccine Array Class
//28/03/2022

import java.util.*;
import java.io.*;

public class VaccineArrayApp
{
	static int insertOpCount = 0, searchOpCount = 0; //instrumentation

	public static void main(String[] args) throws Exception
	{	
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter data file [Enter the filename and extention only e.g. example.csv]");
		String filename = keyboard.nextLine();
		
		
		File fileObject = new File("/home/msimamisi/Assignment1/data/"+filename);
		Scanner scanFile = new Scanner(fileObject);
		VaccineArray countryStats = new VaccineArray();

		populate(scanFile, countryStats); //fills up array with countries and vaccine information  
		
		Scanner dateEntry = new Scanner(System.in);
		Scanner countryNames = new Scanner(System.in);
		
		System.out.println("\nEnter the date:");
		String date = dateEntry.nextLine();
		
		Country[] searchList = createSearchList(countryNames, date); //list of countries queried
		
		System.out.println("Results:");
		showVaccineData(countryStats, searchList);

		System.out.println(Integer.toString(VaccineArray.insertOpCount) + " insert operations");	
	}


	/**
	 * This method processes user input for addition into the array data structure - checks that input has the correct number fields
	 * @param f
	 * 	  Scanner object that accepts the data file input
	 * @param v
	 * 	  Vaccine object to be populated
	 */
	public static void populate(Scanner f, VaccineArray v)
	{
		while(f.hasNext())
		{
			String line = f.nextLine();
			String[] splitLine = line.split(",");
			
			if(splitLine.length == 3)
			{	
				Country country = new Country(splitLine[0], splitLine[1], splitLine[2]);
				v.addItem(country);
			}
			else
			{
				Country country = new Country(splitLine[0], splitLine[1], "");
				v.addItem(country);
			}
		}
	}


	/**
	 * This method generates a list of all object to be searched in array
	 * @param k
	 * 	  Scanner object that accepts user input - names of countries
	 * @param date
	 * 	  String object that accepts user input - date of vaccination
	 * @return List of country names
	 */
	public static Country[] createSearchList(Scanner k, String date)
	{	
		Country[] searchArray = new Country[100];
		int c = 0;
		System.out.println("Enter the list of countries (end with an empty line):");
		while(true)
		{
			String name = k.nextLine();
			
			if(name.trim().length() != 0)
			{
				searchArray[c] = new Country(name, date, "");
				c++;
			}
			else
			{
				break;
			}
		}

		return searchArray;
	}


	/**
	 * This method displays the details of the Country object that has been found
	 * @param v
	 * 	  Array Data Structure object - that stores Country objects
	 * @param c
	 * 	  Country object to be found
	 */
	public static void showVaccineData(VaccineArray v, Country[] c)
	{
		for(int i=0; i<c.length; i++)
		{
			v.findItem(c[i]);
		}
	}
}

