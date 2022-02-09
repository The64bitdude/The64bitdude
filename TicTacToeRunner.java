package length;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class TicTacToeRunner
{
	public static void main( String args[] ) 
	{
		TicTacToe t = new TicTacToe( "XXXOOOXOX" );
		System.out.println( t.getWinner() );
		System.out.println( t );
		
		t = new TicTacToe( "OXOXOXOXO" );
		System.out.println( t.getWinner() );
		System.out.println( t );
	}
}