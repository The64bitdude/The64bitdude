package length;

public class tester {
	public static int getNumDigits(int number) {
		String L = "" +number;
		return L.length();
	}
	public static boolean isOdd(int number) {
		if(number % 2 == 0) {
			return false;
		}
		return true;
	}
	public static int getOddDigitCount(int number) {
		int count = 0;
		while(number > 0) {
			int digit = number % 10;
			if(isOdd(digit)) {
				count++;
			}
			number /= 10;
		}
		return count;
	}
	public static int getEvenDigitCount(int number) {
		String L = "" + number;
		return(L.length() - getOddDigitCount(number));	
		}
	public static int getDigitDifference(int one, int two) {
		String L1 = "" + one;
		String L2 = "" + two;
		return Math.abs((L1.length() - L2.length()));
				
	}
	
	public static void main(String[] args){
		System.out.println(getEvenDigitCount(1356));
	}
}
