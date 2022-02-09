package length;


	import java.io.FileWriter;   // Import the FileWriter class
	import java.io.IOException;  // Import the IOException class to handle errors

	public class saves {
		public saves(String nme,String in) {
	    try {
	      FileWriter myWriter = new FileWriter(nme);
	      myWriter.write(in);
	      myWriter.close();
	      //System.out.println("Successfully wrote to the file. " + nme);
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	}


