package allgamesinone;
import java.util.Scanner;
public class Binary {


		public void abs(String a) {
			String o ="";
			String jk ="";
			double f = 0;
			int wait = 0;
			int s = 0;
			long ij = 0;
	        double y = 1;
	        double p = 0;
	        double v = 0;
			int l = a.length();
			for(int i = 0; i < l;i++) {
			char t = a.charAt(i);
			if((t > 57)||(t <= 47)) {
				
			o = Integer.toBinaryString(t);
			}
			else if((t <= 57)&&(t > 47)) {
			 f = y * (((int)t) - 48);
			 y = y / 10;
			 if(p == 0){
				 p = p + 10;
			 }
			 else if(p != 0) {
			 p = p * 10;
			 }
			 s++;
			 v = v+f;
			 wait++;
			 
			}
		
			if((t > 57)||(t <= 47)&&(wait > 0)) {
				p = p / 10;
				ij = (int)Math.round((v * p));
				jk = Long.toBinaryString(ij);
				System.out.print(jk);
				wait = 0;
			}
			else if(i+1 >= l) {
				if(wait != 0) {
					p = p / 10;
				ij = (int)Math.round(v * p);
				jk = Long.toBinaryString(ij);
				System.out.print(jk);
				wait = 0;
				}
			}
			if( wait <= 0) {
			System.out.print(o + " ");
			}
			}

		}
		public void binaryc() {
			Scanner op = new Scanner(System.in);
			String a = op.next();
			while( a != "-1.01i") {
			abs(a);
			a = op.next();
			}
		}

}
