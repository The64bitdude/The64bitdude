package main;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors


	// modifiers
	public Card() {
		
	}
  	public Card(int i, String string) {
		suit = string;
		face = i;
	}

	//accessors
	public String getSuit() {
		// TODO Auto-generated method stub
		return suit;
	}

  	public int getValue()
  	{
  		return face;
  	}

	public boolean equals(Object obj)
	{
		if((((Card) obj).getSuit() == getSuit())&&(((Card) obj).getValue()==getValue())) {
		return true;
		}
		return false;
	}

	public String toString()
	   {
	     return FACES[face] + " of " + getSuit() + " | value = " + getValue();
	   }

	

  	
 }