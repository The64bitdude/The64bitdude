package length;

class StringRemover
{
   private String remove;
   private String sentence;

	public StringRemover( String sen, String rem )
	{
		sentence = sen;
		remove = rem;
	}

	public void removeStrings()
	{
		while(sentence.indexOf(remove) != -1) {
			if(sentence.indexOf(remove) -1 >= 0) {
			sentence = sentence.substring(0,sentence.indexOf(remove)-1) + sentence.substring(sentence.indexOf(remove)+ remove.length());
			}else {
				sentence = sentence.substring(0,sentence.indexOf(remove)) + sentence.substring(sentence.indexOf(remove)+ remove.length());
			}
		}
	}

	public String toString()
	{
		
		removeStrings();
		return sentence;
	}
}