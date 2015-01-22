
public abstract class DiceRollBox extends ScoringBox
{
	private boolean used;
	private int score;
	private boolean yahtzee;
	

	public DiceRollBox(String label)
	{
		super(label);
	}
	public boolean isUsed()
	{
		return used;
	}
	public int getScore()
	{
		return score;
	}
	public final void score(DiceCup roll)
	{
		for(int i = 1; i<7; ++i)
		{
			if(roll.count(i) == 5)
			{
				this.yahtzee= true;
			}
		}
		this.score=calculateScore(roll);
		this.used=true;
	}
	public boolean isYahtzee()
	{
		return yahtzee;
	}
	protected abstract int calculateScore(DiceCup Roll);

}
