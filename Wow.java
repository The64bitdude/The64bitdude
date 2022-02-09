package length;
import java.util.*;
public class Wow {
	public static Scanner we = new Scanner(System.in);
	public String Wow = we.next();
public static void firstTwo(String Wowe) {
	int w = Wowe.length();
	if( w <= 1 ) {
		System.out.println(Wowe);
	}
	else {
	System.out.println(Wowe.substring(0,2));
	}
}
public static void lastLetter(String Wowe) {
	int w = Wowe.length();
	System.out.println(Wowe.substring(w-1,w));
}
public static void lastHalf(String Wowe) {
	int w = Wowe.length();
	if( w <= 1 ) {
		System.out.println(Wowe);
	}
	else 
	{
	System.out.println(Wowe.substring(w/2,w));
	}
}
public static void main(String[] args) {
	String Wow = we.next();
	while(Wow != "1") {
	firstTwo(Wow);
	lastLetter(Wow);
	lastHalf(Wow);
	Wow = we.next();
	}
  }
}
