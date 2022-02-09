package length;

class Tweet
{
	private String message;
	private int retweets;
	private int likes;
	
	public Tweet( String m, int r, int lk )
	{
		message = m;
		retweets = r;
		likes = lk;
	}
	
	public void addLikes( int n )
	{
		likes += n;
	}
	
	public void addRetweets( int n )
	{
		retweets += n;
	}
	
	public boolean notLiked()
	{
		if(likes > 10) {
		return false;
		}
		else {return true;}
	}
	
	public boolean kindaLiked()
	{
		if(likes < retweets) {
		return false;
		}
		else {return true;}
	}
	
	public boolean isTrending()
	{
		if((likes + retweets) < 75) {
			return false;
			}
			else {return true;}
	}
	
	public String toString()
	{
		return message + " rt " + retweets + " lk " + likes ;
	}
}
