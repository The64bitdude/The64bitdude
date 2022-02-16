package main;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.*;

public class Player
{
   private ArrayList<Card> hand;
   private int winCount;

   public Player ()
   {
	   winCount = 0;
	   hand = new ArrayList<Card>(); 
   }

   public Player (int score)
   {
   }

   public void addCardToHand( Card temp )
   {
	   hand.add(temp);
   }

   public void resetHand( )
   {
	   hand.clear();
   }

   public  void setWinCount( int numwins )
   {
	   winCount = numwins;
   }

   public int getWinCount() { return winCount; }

   public int getHandSize() { return hand.size(); }

   public int getHandValue()
   {
	   int value = 0;
	   for(Card e:hand) {
		   value += e.getValue();
	   }
      return value;
   }

   public  boolean  hit( )
   {
      return false;
   }

   public String toString()
   {
      return "hand = " + hand + " - " +getHandValue();
   }
}