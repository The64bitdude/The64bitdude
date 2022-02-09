package length;
import java.util.Scanner;
import static java.lang.System.*;
public class PasswordCheck {
	private String password = "mchammergohammer";

	public PasswordCheck()
	{
	}

	public void check()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the password :: ");
		String in = keyboard.next();
		if(!(in.equals(password))){
			System.out.println("INVALID");	
		}
        while(!(in.equals(password))) {
        	System.out.print("Enter the password :: ");
    		in = keyboard.next();
    		if(!(in.equals(password))){
    			System.out.println("INVALID");	
    		}
			
		}
        System.out.println("VALID");	
	}
}
