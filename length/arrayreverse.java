package length;

public class arrayreverse {

	public static int[] arrev(int[] in) {
		for(int i = 0;i < (int)(in.length/2);i++) {
			int old = in[((in.length-1) - i)];
			in[(in.length-1) - i] = in[i];
			in[i] = old;
		}
		return in;
	}
	public static void main(String[] args) {
		int[] in = {1,2,3,5,35,532,5};
		int[] out = arrev(in);
		System.out.print("{");
		for(int i = 0;i < out.length; i++) {
		System.out.print(out[i]);
		if(i != (out.length - 1)) {
		System.out.print(",");
		}
		}
		System.out.print("}");
	}
}
