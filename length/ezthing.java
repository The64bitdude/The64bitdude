package length;

public class ezthing {
	public static String out(String in) {
		String out = "";
		for(int i = in.length(); i > 0; i --) {
			out = out +in.substring(0,i) + "\n";
		}
		return out;
	}

	public static void main(String[] args) {
		System.out.println(out("message encoder"));
	}
}
