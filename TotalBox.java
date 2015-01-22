
public class TotalBox extends BonusBox
{
	private ScoringBox[] summands;
	public TotalBox( ScoringBox[] sb,String label)
	{
		super(label);
		summands = sb;
		
	}
	public int getScore()
	{
		int total = 0;
		for(int i = 0; i<summands.length;++i)
		{
			total = total + summands[i].getScore();
		}
		return total;
	}
}
