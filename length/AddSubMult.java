package length;

public class AddSubMult {
public static double addSubMult(double a,double b) {
	if(a > b) {
		return a-b;
	}
	if(b > a) {
		return b-a;
	}
	if(b == a) {
		return a*b;
	}
	else{
		return 0;
	}
}
}
