package length;

public class Monster
{
	private String name;
	private int howBig;	

	public Monster(String n, int size)
	{
	name = n;
	howBig = size;
	}

	public String getName()
	{
		return name;
	}
	
	public int getHowBig()
	{
		return howBig;
	}
	
	public boolean isBigger(Monster other)
	{
		if(other.getHowBig() < getHowBig()) {
			return true;
		}
		return false;
	}
	
	public boolean isSmaller(Monster other)
	{
		if(other.getHowBig() > getHowBig()) {
			return true;
		}
		return false;
	}

	public boolean namesTheSame(Monster other)
	{
		if(other.getName().equals(getName())) {
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return name + " " + howBig;
	}
}
