package main;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck ()
	{
		//initialize data - stackOfCards - topCardIndex
		topCardIndex = 51;
		stackOfCards = new ArrayList<Card>();
		for(int ns = 0;ns<NUMSUITS;ns++) {
			for(int nf = 1;nf<=NUMFACES;nf++) {
				stackOfCards.add(new Card(nf,SUITS[ns]));
			}
		}
		
		//loop through suits
			//loop through faces
				//add in a new card
		
	}

	//modifiers
   public void shuffle ()
	{
		topCardIndex = 51;
	   Collections.shuffle(stackOfCards);
	}

   //accessors
	public int  size ()
	{
		return stackOfCards.size();
	}

	public int numCardsLeft()
	{
		return (topCardIndex)+1;
	}

	public Card nextCard()
	{
		return stackOfCards.get(topCardIndex--);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}