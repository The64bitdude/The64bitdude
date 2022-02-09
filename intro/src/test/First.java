package test;
import java.util.*;

public class First {


	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	String intOne, intTwo;
	
	
	System.out.print("Enter your name here ");
	intOne = keyboard.next();
	
	System.out.print("Enter your age here ");
	intTwo = keyboard.next();

	System.out.println("hello "+ intOne);
	System.out.println("Your age is " + intTwo);
	}
}