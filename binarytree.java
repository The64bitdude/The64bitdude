package length;

public class binarytree {
public static int[] inv(int[] in) {
	int[] out = new int[in.length];
	int layers = (int) (Math.log(-1*(((in.length)/(1-2))-1))/Math.log(2));
	int pre = 0;
	int numas = 0;

	for(int i = 0;i<=(layers-1);i++) {

		for(int k = ((int) Math.pow(2,i)); k > 0;k--) {
			
		out[numas] = in[(pre+(k-1))];
		numas++;
		}
		pre += Math.pow(2,i);
	}
return out;
}
	public static void main(String[] args) {
		System.out.print(ToLine.arrayToString(inv(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15})));
	}
}
