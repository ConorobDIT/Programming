/*  
 * This class is to allow reading of the file
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager 
{
	String fileName;
	File fileE;
	Scanner myScanner;
	
	// Constructor
	FileManager (String fileName)
	{
		this.fileName = fileName;
	}
	
	// get a connection to the file
	void connectToFile()
	{
		fileE = new File(fileName);
	}

	// Read the file, returning a string of lines
    ArrayList<String> readFile()
    {
    	ArrayList<String> values = new ArrayList<String>();
	    try
		{
	    	myScanner = new Scanner(fileE); 
	    	myScanner.useDelimiter(";");
			 while (myScanner.hasNextLine())
			    { 
				 values.add(myScanner.nextLine());
			    }
		}
		catch (FileNotFoundException e)
		{
			System.out.println("run time error " + e.getMessage());
		}
	    {
	        return values;
	    }
    }
   
    void closeReadFile()
    {
		 myScanner.close();
    }

}
