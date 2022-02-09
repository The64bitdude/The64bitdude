package allgamesinone;
import java.util.*;

import javax.swing.JFrame;

public class Mainmenu {
	public static void main(String[] args) {
	Scanner ag = new Scanner(System.in);
	String[] a = {"binaryc","blackjack","gamboling","physics","gpacalculator","yin yang and smile"};
	System.out.println(a[0]+" is 1 and "+a[1]+" is 2 and "+a[2]+" is 3 and "+a[3]+" is 4 and "+ a[4]+" and is 5 "+a[5]+" is 6");
	int b = ag.nextInt();
	if(b == 1) {
System.out.println(a[0]);
Binary bi = new Binary();
bi.binaryc();
	}
	else if(b == 2) {
	System.out.println(a[1]);
blackjack bj = new blackjack();
bj.blackjac();
	}
	else if(b == 3) {
		System.out.println(a[2]);
		gambol gb = new gambol();
		gb.gambolg();
	}
    else if(b == 4) {
    	System.out.println(a[3]);
    	physics py = new physics();
		py.physicsc();
	}
    else if(b == 5) {
    	System.out.println(a[4]);
    	gpacal gp = new gpacal();
		gp.gpacalc();
	}
    else if(b == 6) {
    	System.out.println(a[5]);
    	GraphicsRunner2 run = new GraphicsRunner2();
    	
	}
	}
}

