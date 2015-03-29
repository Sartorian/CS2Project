public class Card
{
	private String value;
	private String suit;
	
	public Card(int i, char c)
	{
		value = Reference.VALUE[i];
		if(c == 'h')
			suit = Reference.HEART;
		else if(c == 'd')
			suit = Reference.DIAMOND;
		else if(c == 'c')
			suit = Reference.CLUB;
		else if(c == 's')
			suit = Reference.SPADE;
		else
			suit = "ERROR CODE 1";
		
	}
	public String getSuit()
	{
		return suit;
	}
	public String getValue()
	{
		return value;
	}
	public boolean canPlay(Card c)
	{
		if(this.suit.equals(c.getSuit()))//suits are same
		{
			return true;
		}
		else if(this.value.equals(c.getValue()))//values are same
		{
			return true;
		}
		else if(this.value.equals("8"))
		{
			return true;
		}
		else return false;
	}
}

