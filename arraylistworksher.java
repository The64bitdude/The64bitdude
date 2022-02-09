package length;

import java.util.ArrayList;

public class arraylistworksher {
	public static void main(String[] args) {
		ArrayList<String> sam;
		sam = new ArrayList<String>();
		sam.add( "ben" );
		sam.add( 0, "wil" );
		sam.set( 1, "cat" );
		sam.add( 1, "dog" );
		sam.add( "pig" );
		sam.remove(2);

		System.out.println( sam.get(0) ); // LINE 1
		System.out.println( sam.get(2) ); // LINE 2
		System.out.println( sam.set(1, "up") );     // LINE 3
		System.out.println( sam.indexOf("ben")); // LINE 4
		System.out.println( sam.contains("sam")); // LINE 5
		System.out.println( sam ); // LINE 6
		sam.remove(1);
		System.out.println( sam ); // LINE 7
		sam.add("one");
		System.out.println( sam ); // LINE 8
		sam.add(0,"five");
		System.out.println( sam ); // LINE 9
		sam.remove( 1 );
		System.out.println( sam ); // LINE 10
		sam.add( 0, "chair" );
		System.out.println( sam ); // LINE 11
		for( int i = 0; i < sam.size(); i++ )
		  System.out.print( sam.get( i ) + " " ); // LINE 12
		System.out.println();
		sam.remove( sam.size()-1 );
		System.out.println( sam ); // LINE 13
		for( int i = 0; i < 4; i+=2 ) 
		  sam.add( i, "fun" );
		System.out.println( sam ); 
	}
}
