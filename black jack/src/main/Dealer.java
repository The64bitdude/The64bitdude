package main;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class Dealer extends Player
{
	Deck deck;
	
	public Dealer() {
		deck = new Deck();
	}

	public void  shuffle()
	{
	  deck.shuffle();
	}

	public Card  deal(){
	   return deck.nextCard();
	}
	
	public int numCardsLeftInDeck()
	{
		return 0;
	}

	public boolean hit()
	{
		if(getHandValue() < 17) {
			return true;
		}
	   return false;
    }
}








