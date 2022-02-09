package length;
import java.util.*;
public class classes {

	public static void firstMLast(String in) {
		
		System.out.println("has first last letters :: " + in.substring(0,1) + in.substring(in.length() - 1,in.length()));
		System.out.println("has middle letter :: " + in.substring(in.length()/2,(in.length()/2)+1));
		System.out.println("has same first and last letter :: " + (in.substring(0,1).equals(in.substring(in.length() - 1,in.length()))));
		
	}
	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		System.out.print("Enter a word :: ");
		String in = ent.next();
		firstMLast(in);
		
	}
}
