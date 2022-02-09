package length;
import java.util.*;
public class binarytoword {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print(" 1 binary to text or 2 text to binary ");
		int awns = in.nextInt();
		while (awns == 1) {
		System.out.print(ToLine.bToString(in.next()));
		}
		while (awns == 2) {
			System.out.println(ToLine.sToBinary2(in.nextLine()));
			}
	}
}
