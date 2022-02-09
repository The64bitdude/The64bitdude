package ggameww;



import java.awt.event.ActionEvent;
import java.util.Scanner;

public class geussp {

	public static int[] num(boolean tof,int awns,int min,int max) {
		int[] e = new int[3];
		if(tof) {
			min = awns;
		}
		if(tof == false) {
			max = awns;
		}
		e[0] = ((max+min)/2);
		e[1] = min;
		e[2] = max;
		return e;
	}
	public boolean Awnser;
	public void setAwns(boolean in) {
		Awnser = in;
		
	}
	public boolean testAwns() {
		return Awnser;
		
	}
	public geussp() {
		
		Scanner in = new Scanner(System.in);
		int max = 0;
		int min = 0;
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
		int num = max;
		int t = 0;
		while(awns != true) {
			t++;
			System.out.println(t+" is this your number(true or false) : " + num);
			if(testAwns()) {
				awns = true;
			}
			else {
				
			}
			if(awns != true) {
			System.out.println("is your number greater or less than(true or false) : " + num);
			if(testAwns()) {
	int[] ae =num(true,num,min,max);
	num = ae[0];
	min =ae[1];
	max = ae[2];
}else {
	int[] ae =num(false,num,min,max);
	num = ae[0];
	min =ae[1];
	max = ae[2];
}
			}
		}
		System.out.println("your number is : " + num);
	}
}
