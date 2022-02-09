package length;

public class WordMixer {

	public static String wordMixer(String in,int in2) {
		if(in2 < in.length()) {
		String ot = in.substring(in2);
		ot = ot + in.substring(0,in2);
		return ot;
		}
		else {return "no can do";}
	}
}
