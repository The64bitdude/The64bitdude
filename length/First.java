package length;

public class First {

	public static String first( String in) {
		int f = in.indexOf(in.substring(0,1));
		String l;
		if(f == 0) {
			l = in.substring(1);
			f = l.indexOf(in.substring(0,1));
			if(f > 0) {
				return "yes";
			}
			else {return "no";}
		}
		else{return "no";}
	}
}
