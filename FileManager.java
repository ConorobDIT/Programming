/**************************************************
 * 
 * 
 *  This class provides file reading and writing functionality
 *  Author: Susan McKeeve
 *  2016
 *  
 *  
 ************************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager 
{
	String fileName;
	File fileExample;
	Scanner myScanner;
    PrintWriter pwInput;
	
	// Constructor
	FileManager (String fileName)
	{
		this.fileName = fileName;
	}
	
	// get a connection to the file
	void connectToFile()
	{
		fileExample = new File(fileName);
	}

	// Read the file, returning a string of lines
    ArrayList<String> readFile()
    {
    	ArrayList<String> values = new ArrayList<String>();
	    try
		{
	    	myScanner = new Scanner(fileExample); 
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

    void closeWriteFile()
    {
		 pwInput.close();
    }

}
