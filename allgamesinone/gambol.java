package allgamesinone;
import java.util.Scanner;
public class gambol {


		public void gambolg() {
	    Scanner nem = new Scanner(System.in);
	    double winnings = 1000;
	    double bar;
	    int lose = 0;
	    boolean bain;
	    double bank = 0;
	    int jackpot = 0;
	    while(lose == 0) {
	    	System.out.println("set difficulty 1-20 scale ");
	        double setting = nem.nextDouble();
	        if(setting >= 20) {
	        	setting = 20;
	        }
	        System.out.println("set start money");
	    winnings = nem.nextDouble();
	    if(winnings == 69420) {
	    	System.out.println("ha ha very funny");
	    }
	    System.out.println("do you want to beat the bank true or false");
	    bain = nem.nextBoolean();
	    if(bain == true) {
	    	System.out.println("set bank start money");
	        bank = nem.nextDouble();
	    }
	    System.out.println("you have " + winnings);
	    double bob = nem.nextDouble();
	    if(bob <= 0) {
	    	bob = 0.01;
	    	System.out.println("trying to cheat are you... I THINK NOT");
	    	System.out.println("(ERROR BET CHANGED BY SYSTEM)");
	    	System.out.println("NEW BET = 0.01");
	    }
	    if(bob == 69420) {
	    	System.out.println("ha ha very funny");
	    }
	    while(winnings > 0) {
	    	if(bob == 69420) {
	        	System.out.println("ha ha very funny");
	        }
	    	winnings = winnings - bob;
	    	bar = (double)((Math.random() * (bob * (Math.random() * 5/setting))));
	    	jackpot = jackpot + 1;
	    	if(jackpot >= (Math.random() * 100)){
	    		bar = bar + (double)(Math.random() * bob * jackpot * 5 * (5 / setting));
	    		jackpot = 0;
	    	}
	    	winnings = winnings + bar;
	    	if( bank != 0) {
	        bank = bank + bob;
	    	bank = bank - bar;
	       	}
	    	System.out.println("you win " + (Math.round(bar * 100.0)/100.0) + " $");
	    	System.out.println("you have " + (Math.round(winnings * 100.0)/100.0) + " $");
	    	System.out.println("jackpot collected " + jackpot);
	    	if( bank < 0) {
	    		System.out.println("YOU BEAT THE BANK, THE BANK NOW OWES YOU " + (-1 * (Math.round(bank * 100.0)/100.0)) + " $");
	    	}
	    	if( bank != 0) {
	    		if( bank > 0) {
	         System.out.println("The bank has " + (Math.round(bank * 100.0)/100.0) + " $ left");
	    		}
	    	}
	    if( winnings > 0) {
	    	bob = nem.nextDouble();
	    }
	    if(bob <= 0) {
	    	bob = 0.01;
	    	System.out.println("trying to cheat are you... I THINK NOT");
	    	System.out.println("(ERROR BET CHANGED BY SYSTEM)");
	    	System.out.println("NEW BET = 0.01");
	    }
	    }
	    System.out.println("YOU LOSE");
	    System.out.println("press 0 to try again or 1 to end");
	    lose = nem.nextInt();
	    }
	        	
	    	
	}

}
