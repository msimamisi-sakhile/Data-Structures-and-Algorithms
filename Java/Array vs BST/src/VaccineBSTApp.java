//Msimamisi Mwandla
//Vaccine Binary Search Tree class
//05-03-2022

import java.io.*;
import java.util.*;

public class VaccineBSTApp
{
	public static void main(String[] args) throws Exception
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the data file [Enter the filename and extention only e.g. example.csv]");
		String filename = keyboard.nextLine();

		File fileObject = new File("/home/msimamisi/Assignment1/data/"+filename);
		Scanner scanFile = new Scanner(fileObject);

		BinarySearchTree<Country> vaccineTree = new BinarySearchTree<Country> ();

		populate(scanFile, vaccineTree);

		Scanner dateEntry = new Scanner(System.in);
		Scanner countryNames = new Scanner(System.in);

		System.out.println("\nEnter the date:");
		String date = dateEntry.nextLine();

		Country[] countries = createSearchList(countryNames, date);

		System.out.println("Results:");
		findCountry(vaccineTree, countries);

		System.out.println(Integer.toString(vaccineTree.insertOpCount) +" insertion operations.");
		vaccineTree.inOrder();
		

	}

	
	/**
	 * This method checks if user input is ready to be added to the Binary Search Tree - checks if input has correct number of fields
	 * @param s
	 * 	  Scanner object that accepts file user input
	 * @param bst
	 * 	  Binary Search Tree object data structure 
	 */
 	public static void populate(Scanner s, BinarySearchTree<Country> bst)
	{
		while(s.hasNext())
		{
			String line = s.nextLine();
			String[] splitLine = line.split(",");

			if(splitLine.length == 3)
			{
				Country c = new Country(splitLine[0], splitLine[1], splitLine[2]);
				bst.insert(c);
			}
			else
			{
				Country c = new Country(splitLine[0], splitLine[1], "");
				bst.insert(c);
			}
		}
	}
	

	/**
	 * This method creates a list of items to be searched
	 * @param k
	 * 	  Scanner object that accepts user input
	 * @param date
	 * 	  String object that accepts vaccination date
	 * @return list of country objects
	 */
	public static Country[] createSearchList(Scanner k, String date)
	{
		Country[] searchArray = new Country[100];
		int c = 0;
		System.out.println("Enter the list of countries(end with an empty line)");

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
	 * This method finds a specified item in the Binary Search Tree data structure
	 * @param bst
	 * 	  Binary Search Tree object that stores Country objects
	 * @param c
	 * 	  List of Country objects 
	 */
	public static void findCountry(BinarySearchTree<Country> bst, Country[] c)
	{		
		int trueLength = 0;
		for(int j=0; j<c.length; j++)
		{
			if(c[j] instanceof Country)
			{
				trueLength++;
			}
		}


			for(int i=0; i<trueLength; i++)
			{
				try
				{	
					BinaryTreeNode<Country> country = bst.find(c[i]);
					String vaccs = country.data.toString().substring(c[i].name.length()+c[i].date.length()+2);
					String countryName = country.data.toString().substring(0,c[i].name.length());

					System.out.println(countryName +" = "+ vaccs);

					System.out.println(Integer.toString(bst.searchOpCount) +" search operations.\n");
				}
				catch(Exception e)
				{
					System.out.println(c[i].name +" = <Not Found>");
					System.out.println(Integer.toString(bst.searchOpCount) +" search operations.\n");
				}
			}
	}


}
