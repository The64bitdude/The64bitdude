package length;

import java.util.Scanner;

public class guessinggamep {

	
	public static void main(String[] args) {
		int max = 0;
		int min = 0;
		Scanner in = new Scanner(System.in);
		boolean awns = false;
		System.out.println("do you want the maximum max and minimum min");
		String e = in.next();
		e = e.toLowerCase();
		if((e.equals("true"))||(e.equals("t"))||(e.equals("yes"))||(e.equals("y"))||(e.equals("greater"))) {
			max = Integer.MAX_VALUE;
			min = Integer.MIN_VALUE;
		}else {
		System.out.println("Pick an max number from "+Integer.MIN_VALUE+" to " +Integer.MAX_VALUE);
		max = in.nextInt();
		System.out.println("Pick an min number from "+Integer.MIN_VALUE+" to " +max);
		min = in.nextInt();
	}
		System.out.println("Pick an number from "+min+" to " +max);
		double a1 = Math.random();
		long a2 = (max - min);
		long ynum = (long)((a1 * a2) + min);
		int num = max;
		int t = 0;
		awns =false;
		while(awns != true) {
			t++;
			System.out.println(t+" guess the number : ");
			num = in.nextInt();
			if(ynum == num) {
				System.out.println("t");
				awns = true;
			}
			else {
				System.out.println("f");
				
			}
			if(awns != true) {
			System.out.println("is your number greater or less than : " + num);
			if(ynum > num) {
				System.out.println("GREATER");
	
}else {
	System.out.println("LESS THAN");
}
			}
		}
		double percent = (t - 1);
		double percent2 = (percent / t)*100;
		System.out.println("you guessed wrong " + Math.round(percent2) + "% of the time");
		System.out.println("your number is : " + num);
	}
}
