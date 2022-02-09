package length;

public class picalc {

	public static void main(String[] args) {
		double pit = 0;
		int h = 0;

		for(double i = 1;i <1000000000;i += 2) {
			if( h == 0) {
				
		pit += (1/i);
		h = 1;
			}else if(h == 1) {
				pit -= (1/i);	
				h = 0;
			}
		}
		pit *= 4;
		System.out.println(pit);
	}
}
