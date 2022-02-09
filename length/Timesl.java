package length;

import java.util.*;

public class Timesl {

	public static void main( String[] args ) {
		Scanner te = new Scanner(System.in);
		System.out.println(" we are going to find the perimiter of yo rectange");
		System.out.print("also whats the length man ::");
		int length = te.nextInt();
		System.out.print("also whats the width dude ::");
		int width = te.nextInt();
		double perim = (double)(2*width)+(2*length);
		System.out.println("Your perimiter is "+ perim+ " dude");
		System.out.println("");
		
		System.out.println(" now we are going to find the area of yo trapezoid");
		System.out.print("so whats the first base man ::");
		double basew = te.nextDouble();
		System.out.print("so whats the second base man ::");
		double baset = te.nextDouble();
		System.out.print("also whats the hight dude ::");
		double hightp = te.nextDouble();
		double areap = ((basew + baset) / 2)*hightp;
		System.out.println("Your area is "+ areap+ " dude");
		System.out.println("");
		
		System.out.println(" now we are going to find the volume of yo cone");
		System.out.print("so whats the radius man ::");
		double radi = te.nextDouble();
		System.out.print("also whats the hight dude ::");
		double height = te.nextDouble();
		double volume = (3.14)*(radi * radi)*(height/3);
		System.out.println("Your volume is " + volume + " dude");
		System.out.println("");
		
		System.out.println(" now we are going to find the surface area of yo cube");
		System.out.print("so whats the length man ::");
		double s = te.nextDouble();
		double sa = 6*(s*s);
		System.out.println("Your surface area is " + sa + " dude");
		System.out.println("");
		
		System.out.println(" now we are going to convirt Fahrenheit to Celsius");
		System.out.print("so whats the temp in Fahrenheit man ::");
		double tempf = te.nextDouble();
		double tempc = ((tempf - 32) * 5) / 9.00;
		System.out.println("Your temp in celsius is " + tempc + " dude");
	}
	
}
