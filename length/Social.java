package length;

public class Social {

	public static String social(String in) {
		int dash = in.indexOf("-");
		if (dash != 3) {
			return "bad";
			
		}
		if (dash == 3) {
			in = in.substring(4);
		}
		dash = in.indexOf("-");
		if (dash != 2) {
			
			return "bad";
		}
		if (dash == 2) {
			
			in = in.substring(3);
		}
		dash = in.indexOf("-");
		if (dash != -1) {
			return "bad";
		}
		if (dash == -1) {
			return in;
		}
		else {return "bad";}
		
	}
	public static void main(String[] args) {
		String in = "463-99-8888";
		System.out.print(social(in));
	}
}
