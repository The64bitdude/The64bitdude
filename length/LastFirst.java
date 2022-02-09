package length;

public class LastFirst {

	public static String go( String a ) {
		int a1 = a.substring(0,1).compareTo(a.substring(a.length()-1)); 
		if(a1 > 0) {
			return "aplus";
		}
if(a1 < 0) {
		return "compsci";	
		}
if(a.substring(0,1).equals(a.substring(a.length()-1))) {
	return "apluscompsci";
}
else {return "";}
	}
}
