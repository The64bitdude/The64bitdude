package main;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class BlackJackCard extends Card
{
  	//constructors



  	public BlackJackCard(int i, String string) {
  			super(i,string);
	}

	public BlackJackCard() {
		// TODO Auto-generated constructor stub
	}

	public int getValue()
  	{
		return super.getValue();
  		//enables you to build the value for the game into the card
  		//this makes writing the whole program a little easier

  	}
  	
 }