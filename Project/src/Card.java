public class Card
{
	private String value;
	private String suit;
	private int valueNum; //<-- necessary to preserve the constructor parameters passed, to find a card image in GUI class 2D array.
	private char suitChar;
	
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
		valueNum = i;
		suitChar = c;
	}
	public String getSuit()
	{
		return suit;
	}
	public String getValue()
	{
		return value;
	}
	public int getValueNum()
	{
		return valueNum;
	}
	public char getSuitChar()
	{
		return suitChar;
	}
	public boolean canPlay(Card c, String eightSuit)
	{
      if (c.value.equals("8")){
         if (this.suit.equals(eightSuit) || this.value.equals("8")){
            return true;
            }
         else {
            return false;
            }
         }     
		else if(this.suit.equals(c.getSuit()))//suits are same
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
	
	public String toString()//Prints full card name
	{
		return value + " " + suit;
	}
	//END CARD CLASS
}

