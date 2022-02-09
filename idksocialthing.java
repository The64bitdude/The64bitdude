package length;
import java.util.*;
public class idksocialthing {

	public static void numfind(String ssn){
		int sum = 0;
		int ssl=ssn.length();
		String sse = ssn;
		for(int i = 0; i < ssl;i++) {
			int e = (sse.indexOf("-"))+i;
			if(e != i){
			int se = Integer.valueOf(ssn.substring(i,i+1));
			sum = sum + se;
					se=0;
			}
			sse = ssn.substring(i+1);
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		Scanner ssna = new Scanner(System.in);
		System.out.println("put the numbers and dashes only");
		System.out.println("");
		String ssn = ssna.nextLine();
		numfind(ssn);
	}
}
