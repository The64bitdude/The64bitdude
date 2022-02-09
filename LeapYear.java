package length;

public class LeapYear {
public static boolean leapYear(double in) {
	
	int te = (int)(in / 4);
	if(in / 4 == te ) {
	return true;	
	}
	else {
	return false;
	}
}
}
