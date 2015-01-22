
public abstract class ScoringBox 
{
	private String label;
	
	public ScoringBox(String label)
	{
		this.label = label;
	}
	public ScoringBox()
	{
		
	}
	public abstract boolean isUsed();
	
	public abstract int getScore();

	public abstract void score(DiceCup roll);

	public final String toString()
	{
		String str = "";
		if(isUsed())
		{
			str += label+" : " + getScore();
		}
		else
		{
		str += label+" :___";
		}
		return str;
	}
}
