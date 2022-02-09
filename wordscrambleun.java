package length;
import java.util.*;
public class wordscrambleun {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("do you want to code or decode");
		if(in.next().equals("code")) {
			System.out.println("pass");
		int code = ToLine.ToIntc(in.next());
		System.out.println("put a dubble period at the end with a space to finish");
		System.out.println("what want to code");
		String message = ToLine.tillenter(in);
		System.out.println(ToLine.sscambel(code,message));
		}else {
		System.out.println("pass");
		int code = ToLine.ToIntc(in.next());
		System.out.println("what want to uncode");
		String message = in.next();
		System.out.println(ToLine.dscambel(code,message));
		}
	}
}
