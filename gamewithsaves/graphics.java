package gamewithsaves;
import java.util.*;
public class graphics {

	public void graphics(String gr) {
		int p = 0;
		int[] sd = new int[gr.length()];
		char[] po = {'0','1','D','O','H','X'};
		for(int i = 0;i < gr.length();i++) {
			char t = gr.charAt(i);
			p = ((int)t) - 48;
			System.out.print(po[p]);
		}
		System.out.println("");
	}
}
