
public class NumbersBonusBox extends BonusBox
{
	private NumberBox[] numberBoxes;
	public NumbersBonusBox(NumberBox[] boxes) 
	{
		super("Bonus Box");
		numberBoxes = boxes;
	}
	public int getScore()
	{
		int score = 0;
		for(int i = 0; i<numberBoxes.length; ++i)
		{
			score += numberBoxes[i].getScore();
		}
		if(score >= 63)
		{
			return 35;
		}
		else
		{
			return 0;
		}
	}

}
