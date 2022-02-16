package main;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack
{
	ArrayList<Player> players;

	public BlackJack()
	{
		players = new ArrayList<Player>();
		players.add(new Dealer());
		System.out.print("How many players? ");
		Scanner keyboard = new Scanner(System.in);
		int amount = keyboard.nextInt();
		for(int i = 0;i<amount+1;i++) {
			players.add(1,new Player());
		}
			
	}

	public void playGame()
	{
		for(int i =0;i<players.size();i++) {
			players.get(i).resetHand();
			}
		Scanner keyboard = new Scanner(System.in);
		char choice = 0;
      ((Dealer) players.get(0)).shuffle();
		for(int i =0;i<players.size();i++) {
		players.get(i).addCardToHand(((Dealer) players.get(0)).deal());
		}
		for(int i =0;i<players.size();i++) {
		players.get(i).addCardToHand(((Dealer) players.get(0)).deal());
		}
		for(int i =1;i<players.size();i++) {
		out.println("\nCards in Hand :: " + players.get(i).toString() );
		System.out.print("Do you want to hit? [Y/N] ");
		if(keyboard.next().toLowerCase().equals("n")) {
			
		}else if(players.get(i).getHandValue()<21){
			players.get(i).addCardToHand(((Dealer) players.get(0)).deal());
		}
		if(players.get(0).hit()) {
			players.get(0).addCardToHand(((Dealer) players.get(0)).deal());
		}
		int playerTotal = players.get(i).getHandValue();
		int dealerTotal = players.get(0).getHandValue();
		out.println("\nPLAYER "+i);
		out.println("Hand Value :: " + playerTotal );
		out.println("Hand Size :: " + players.get(i).getHandSize() );
		out.println("Cards in Hand :: " + players.get(i).toString() );
		out.println("\nDEALER ");
		out.println("Hand Value :: " + dealerTotal );
		out.println("Hand Size :: " + players.get(0).getHandSize() );
		out.println("Cards in Hand :: " + players.get(0).toString() );
		
		if(playerTotal>21&&dealerTotal<=21)
		{
		   out.println("\nDealer wins - Player "+i +" busted!");
		   players.get(0).setWinCount(players.get(0).getWinCount()+1);
		}
		else if(playerTotal<=21&&dealerTotal>21)
		{
		   out.println("\nPlayer "+i +" wins - Dealer busted!");
		   players.get(i).setWinCount(players.get(i).getWinCount()+1);
		}
		else if(playerTotal>21&&dealerTotal>21){
		   out.println("Both players bust!");
		}
		else if(playerTotal<dealerTotal){
		   out.println("\nDealer has bigger hand value!");
		   players.get(0).setWinCount(players.get(0).getWinCount()+1);
		}
		else{
		   out.println("\nPlayer "+i +" has bigger hand value!");
		   players.get(i).setWinCount(players.get(i).getWinCount()+1);
		}	
		
		out.println("\nDealer has won "+players.get(0).getWinCount() + " times.");
		out.println("Player "+i +" has won "+players.get(i).getWinCount() + " times.");
		}
		out.print("\nDo you want to play again? [Y,y,N,n] :: ");
		if(keyboard.next().toLowerCase().equals("y")) {
			playGame();
		}
		
		
	
	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}