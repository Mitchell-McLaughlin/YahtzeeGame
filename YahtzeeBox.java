
public class YahtzeeBox extends DiceRollBox
{
	public YahtzeeBox()
	{
		super("Yahtzee");
	}
	@Override
	protected int calculateScore(DiceCup Roll) 
	{
		int score = 0;
		if(Roll.count(1)==5 || Roll.count(2)==5 || Roll.count(3)==5 || Roll.count(4)==5 || Roll.count(5)==5)
		{
			score = 50;
		}
		return score;
		
	}
}
