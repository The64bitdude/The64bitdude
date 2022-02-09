package length;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
	public static String out = "";
  public ReadFile(String nme) {
	  try {
	      File myObj = new File(nme);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        out = data;
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("there is no file with that name");
	      e.printStackTrace();
	    }
  }
  public String toString()
	{
		return out;
	}
}