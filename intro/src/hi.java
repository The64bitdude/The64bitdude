import java.util.*;

public class hi {
	
	public static void main(String[] args) {
	     // Tell the user to enter a question
	     Scanner scan = new Scanner(System.in);
	     System.out.println("Welcome to the Magic 8 Ball!");
	     System.out.print("Enter your question and I will answer it: ");
	     String question = scan.nextLine();
	     
	     // Get a random number from 1 to 8
	     double test = (int)((Math.random()*8)+1);
	     // Use if statements to print out 1 of 8 responses
	     if(test == 1){
	     System.out.println("are you serious");
	     }
	     if(test == 2){
	     System.out.println("dont even think about it");
	     }
	     if(test == 3){
	     System.out.println("unlikely");
	     }
	     if(test == 4){
	     System.out.println("possible");
	     }
	     if(test == 5){
	     System.out.println("50-50");
	     }
	     if(test == 6){
	     System.out.println("mabye");
	     }
	     if(test == 7){
	     System.out.println("mostally");
	     }
	     if(test == 8){
	     System.out.println("Yes of course");
	     }



	     
	   }
	

	
}