package length;

import java.io.File;  // Import the File class

public class DeleteFile {
	public DeleteFile(String nme) {
    File myObj = new File(nme); 
    if (myObj.delete()) { 
      System.out.println("Deleted the file: " + myObj.getName());
    } else {
      System.out.println("Failed to delete the file.");
    } 
  } 
}