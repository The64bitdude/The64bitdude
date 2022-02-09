package allgamesinone;
import java.util.Scanner;
public class gpacal {

	  public void gpacalc() {
	    double number,year,ogpa,weight, sum = 0, count = 0, sum2 =0;
	    double average, average2;
	    Scanner scan = new Scanner(System.in);

	    // 1. initialize the loop variable (get the first number)

	    System.out.println("Please enter a grade and then weight \" 1 = acidemic 2 = preap 3 = ap\" to average in or -1 to stop: ");
	    System.out.print("grade :: ");
	    number = scan.nextDouble();
	    System.out.print("weight :: ");
	    weight = scan.nextDouble();
	    if(weight > 3) {
	      	weight = 3;
	      	System.out.println("error invalad weight new weight is 3");
	      }
	      else if(weight < 1) {
	    	  System.out.println("error invalad weight new weight is 1");
	      }
	    // 2. test the loop variable (against sentinel value)
	    while (number != -1) {
	    	if(number < 70) {
	    	      if(number != 1) {
	    	      weight = 1;
	    	      }
	    	      }
	    	if(number <= 70) {
	      	  if(number != 1) {
	      	  number = 60;
	      	  }
	        }
	      sum += ((number - 60)/10)+(weight-1);
	      sum2 += ((number - 60)/10);// add number to sum
	      count++; // count the number
	      // 3. Change the loop variable (get a new number)
	      System.out.println("amount of classes " + (int)count);
	      System.out.println("Please enter a grade and then weight \" 1 = acidemic 2 = preap 3 = ap\" to average in or -1 to stop: ");
	      System.out.print("grade :: ");
	      number = scan.nextDouble();
	      if(number != -1) {
	      System.out.print("weight :: ");
	      weight = scan.nextDouble();
	      if(weight > 3) {
	      	weight = 3;
	      	System.out.println("error invalad weight new weight is 3");
	      }
	      else if(weight < 1) {
	    	  System.out.println("error invalad weight new weight is 1");
	      }
	      }
	    }
	    System.out.println("Please enter your old gpa and what year of high school you are simulating(1(if its current or just for quorter) trough 4):");
	    System.out.print("old gpa :: ");
	    ogpa = scan.nextDouble();
	    System.out.print("year :: ");
	    year = scan.nextDouble();
	    if(year > 4) {
	    	year = 4;
	    	System.out.println("error invalad school year new school year 4");
	    }
	    // calculate average
	    average = (double) sum/count;
	    average2 = (double) sum2/count;
	   double newgpa = (average + (ogpa * (year - 1))) / year;
	   double newgpa2 = (average2 + (ogpa * (year - 1))) / year;
	    System.out.println("The gpa is " + (Math.round((newgpa * 1000.0))/1000.0));
	    System.out.println("The unweighted gpa is " + (Math.round((newgpa2 * 1000.0))/1000.0));
	    System.out.println("The total average is " + ((newgpa2 * 10)+60));
	    System.out.println("The total weighted average is " + ((newgpa * 10)+60));

	    scan.close();
	  }
	
}
