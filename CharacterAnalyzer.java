package length;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class CharacterAnalyzer
{
	private char theChar;

	public CharacterAnalyzer()
	{
	}
	public CharacterAnalyzer(char c)
	{
		setChar(c);
	}

	public void setChar(char c)
	{
		theChar = c;
	}

	public char getChar()
	{
		
		return theChar;
	}

	public boolean isUpper( )
	{
		if((theChar > 64)&&(theChar < 91)) {
			return true;
		}
		return false;
	}

	public boolean isLower( )
	{
		if((theChar > 96)&&(theChar < 123)) {
			return true;
		}
		return false;
	}
	
	public boolean isNumber( )
	{
		if((theChar > 47)&&(theChar < 58)) {
			return true;
		}
		return false;
	}	

	public int getASCII( )
	{
		return theChar;
	}

	public String toString()
	{
		if(isLower()) {
		return ""+getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";	
		}
		else if(isNumber()) {
			return ""+getChar() + " is a number. ASCII == " + getASCII() + "\n";	
		}
		else {
			return ""+getChar() + " is a uppercase character. ASCII == " + getASCII() + "\n";		
		}
	}
}
