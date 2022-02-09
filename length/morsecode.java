package length;
import java.util.*;

public class morsecode {
	public static String[] wcodes = {"/",".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	public static String[] icodes = {"-----",".----","..---","...---","....-",".....","-....","--...","---..","----."};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("are you code or decoding");
			if((in.next()).equals("code")) {
				System.out.println("put a dubble period at the end with a space to finish");
				System.out.println("what want to code");
		String str = ToLine.tillenter(in);
		String[] codes = ToLine.arSum(wcodes,icodes);
		System.out.println(ToLine.sToMorse(str,codes));
			}else {
				System.out.println("put a dubble comma at the end with a space to finish");
		System.out.println("what want to decode");
		String str = ToLine.tillenter2(in);
		String[] codes = ToLine.arSum(wcodes,icodes);
		System.out.println(ToLine.mToString(str,codes));
			}
	}
}
