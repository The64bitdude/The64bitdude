package allgamesinone;
import java.util.*;
public class blackjack {



	public void blackjac() {
		
		Scanner in = new Scanner(System.in);
		boolean ab = true;
		while(ab == true) {
		System.out.println("would you like to play true or false");
		ab = in.nextBoolean();
		int aa = 1;
		int pls = 0;
		int nu = 0;
		int wins = 0;
		int dscore = 1;
		int iop = 0;	
		boolean bet = true;
		char scard;
		char[] card = {'1','2','3','4','5','6','7','8','9','t','J','Q','K','A'};
		int[] cscore ={1,2,3,4,5,6,7,8,9,10,10,10,10,11};
		
		int rand = 0;
		System.out.println("How many players 1- anything ");
		System.out.print(":: ");
		pls = in.nextInt();
		int[] win= new int[pls+1];
		int[] stay = new int[pls+1];
		int[] pscore = new int[pls+1];
		String[] crd = new String[pls+1];
		String[] out = new String[pls+1];
		String[] ort = new String[pls+1];
		int[] los = new int[pls+1];
		int[] ace = new int[pls + 1];
		for(int plw = 0;plw <= pls; plw++) {
		crd[plw] = "";
		}
		while( aa == 1) {
			for(int i = 0;i <= pls; i++) {
				if(aa == 1) {
				wins = 0;
				for(int wi = 1;wi < pls+1;wi++) {
					wins = wins + stay[wi];
				
				}
				if(wins == pls) {
for(int wi = 1;wi < pls+1;wi++) {
	if((pscore[wi] > pscore[0])||(pscore[0] > 21)) {
		if(pscore[wi] <= 21) {
		System.out.println("player "+wi+" you win against the casino");
		System.out.print("");
		}
	}
	else if(pscore[wi] < pscore[0]) {
		System.out.println("player "+wi+" you lost against the casino");
		System.out.print("");
		
	}
	
}
aa = 0;
				}
				}
				if(aa == 1) {
				if((stay[i] != 1)&&(i !=0)) {
		System.out.println("player "+ (i) +" do you bet true or false");
		System.out.println("you have an" + out[i]);
		System.out.print(":: ");
		if(stay[i] != 1){
		bet = in.nextBoolean();
		}
				}
				if(stay[i] == 1) {
					iop++;
					bet = false;
				}
				if(i == 0) {
					System.out.println("Dealer do you bet true or false");
					System.out.println("you have an" + out[i]);
						if(pscore[i] < 17) {
							bet = true;
							System.out.println(":: " + bet);
						}
						else {
							iop++;
							stay[i] = 1;
							bet = false;
							System.out.println(":: " + bet);
						}
					
				}
				if(bet==false) {
					stay[i] = 1;
					System.out.println("player " + (i) +" has desided to stay");
					System.out.println("");
					if(stay[i] == 1) {
					if(pscore[i] > pscore[0]) {
								if(i == 0) {
									System.out.println("dealer wins against you rip");
								}
								if(i != 0) {
									if(pscore[i] <=21) {
							System.out.println("player "+i+" you win against the casino");
							}
								}
							System.out.println("");
							win[i] = 1;
							}
					

					
					}
				}
			
		
		if(bet == true) {
		rand = (int)(Math.random()*14);
		dscore = cscore[rand];
		pscore[i] = pscore[i] + dscore;
		if(nu == 0) {
			crd[i] = "";
			nu++;
		}
		if( rand == 9) {
			crd[i] = crd[i] + " " + "10";
		}
		else {
		crd[i] = crd[i] + " " + card[rand];
		if(card[rand] == 'A') {
			ace[i]++;
		}
		}
		out[i] ="" + crd[i];
		if( pscore[i] > 21 ) {
			if((crd[i].indexOf("A") > 0)&&(ace[i] > 0)) {
				pscore[i] = pscore[i]-10;
				ace[i]--;
			}
			if(card[rand] == 'A') {
				pscore[i] = pscore[i]-10;
				
			}
			else if(pscore[i] > 21) {
				los[i] = 1;
				wins++;
				stay[i] = 1;
			}
		}
		if(los[i] == 1) {
			System.out.println("you lost stop trying to get anything");
		}
		if(pscore[i] == 21) {
			stay[i] = 1;
			win[i] = 1;
			System.out.println("you got a BLACK JACK");
			System.out.println("");
			
		}
		else{
			if(stay[i] != 1) {
	    System.out.println("you have an" + out[i]);
		System.out.println("you now have " + pscore[i] + " in total");
		System.out.println("");
			}
		}
			}
				}
				
			}
		     }
		
		
}
	}

}
