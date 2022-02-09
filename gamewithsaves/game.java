package gamewithsaves;
import java.util.*;
public class game {

	public static void main(String[] args) {
		Scanner ad = new Scanner(System.in);
		graphics ab = new graphics();
		int p = ad.nextInt();
		String[] gb = new String[p];
		for(int i = 0; i < p;i ++) {
			gb[i] = ad.next();
		}
		for(int i = 0; i < p;i ++) {
			ab.graphics(gb[i]);
		}
	}
}
