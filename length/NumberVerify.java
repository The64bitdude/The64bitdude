package length;

public class NumberVerify {
public static boolean numberVerify(int in) {
	if((in%2 > 0)||(in%2 < 0)) {
		return true;
		
	}
	else {
		return false;
	}
}
public static void main(String[] args) {
 int in = -850;
System.out.println("Enter a whole number :: " + in);
System.out.println(in+" is odd :: " + numberVerify(in));
System.out.print(in+" is even :: " + !(numberVerify(in)));
}
}
