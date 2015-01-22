
public class YahtzeeBonusBox extends BonusBox
{
	YahtzeeBox yahtzeeBox;
	DiceRollBox[] others;
	public YahtzeeBonusBox(YahtzeeBox yb, DiceRollBox[] drb)
	{
		super("Yahtzee Bonus");
		yahtzeeBox = yb;
		others = drb;
	}
	public int getScore() 
	{
		int counter=0; 
		int score = 0;
	for(int i=0;i<others.length;i++) 
	{
		if(others[i].isYahtzee()) 
		{
			counter++;
		}
			
	} 
	if(yahtzeeBox.getScore() == 50 && counter>0)
	{
		score = 100*counter;
	}
	return score;
	}
}
