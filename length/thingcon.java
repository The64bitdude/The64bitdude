package length;
import java.util.*;
public class thingcon {
	public static String changeKey(String a, String b) {
		String e = b;
		String f = "";
		int l;
		for(int i = 0;i <= b.length();i++) {
			l = e.indexOf(a);
			if(l > 0) {
			f = f + e.substring(0,l);
			}
			e = e.substring(l+1);
			if( (i == b.length()-1) &&( l <=0)) {
				f=f+e.substring(l+1);
			}
			else if((i == 0) && (b.indexOf(a) == -1)) {
				f = a;
			}
			
		}
	System.out.println(f);
       return f;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("what do you want to take out :: ");
		String a = in.next();
		System.out.println("what are you taking out from :: ");
		String b = in.next();
		changeKey(a,b);
	}
}
