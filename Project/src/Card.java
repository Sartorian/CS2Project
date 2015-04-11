// Updated upstream
import java.util.Scanner; // importing the Scanner object
import java.util.ArrayList; // importing the ArrayList object
import java.util.Random; // importing the Random object

// Stashed changes
public class Card
{
	private String value;
	private String suit;
<<<<<<< Updated upstream
	private int valueNum; //<-- necessary to preserve the constructor parameters passed, to find a card image in GUI class 2D array.
	private char suitChar;
=======
	private Scanner scan;
>>>>>>> Stashed changes
	
	public Card(int i, char c)
	{
		scan = new Scanner(System.in);
		
		value = Reference.VALUE[i];
		
		if	(c == 'h')
			suit = Reference.HEART;
		else if(c == 'd')
			suit = Reference.DIAMOND;
		else if(c == 'c')
			suit = Reference.CLUB;
		else if(c == 's')
			suit = Reference.SPADE;
		else
<<<<<<< Updated upstream
			suit = "ERROR CODE 1";		
		valueNum = i;
		suitChar = c;
	}
=======
			suit = "ERROR CODE 1";
	}
	
>>>>>>> Stashed changes
	public String getSuit()
	{
		return suit;
	}
	
	public String getValue()
	{
		return value;
	}
<<<<<<< Updated upstream

=======
<<<<<<< Updated upstream
//<<<<<<< Updated upstream
	public boolean canPlay(Card c, String eightSuit)
=======
>>>>>>> Stashed changes
	public int getValueNum()
	{
		return valueNum;
	}
	public char getSuitChar()
	{
		return suitChar;
	}
<<<<<<< Updated upstream
	public boolean canPlay(Card c, String eightSuit)
=======
	public boolean canPlay(Card c)
>>>>>>> Stashed changes
=======
/*	public boolean canPlay(Card c, String eightSuit)
>>>>>>> Stashed changes
>>>>>>> Stashed changes
	{
      if (c.value.equals("8")){
         if (this.value.equals(eightSuit)){
            return true;
            }
         else {
            return false;
            }
         }    */ 
	//	else if(this.suit.equals(c.getSuit()))//suits are same
	// }
	
	public boolean canPlay(Card c)
	{
		if(this.suit.equals(c.getSuit())) //suits are same

		{
			return true;
		}
		else if(this.value.equals(c.getValue())) //values are same
		{
			return true;
		}
		else if(this.value.equals("8"))
		{
			return true;
		}
		else return false;
	}
	
	public String toString() //Prints full card name
	{
		return value + " " + suit;
	}
}
// Updated upstream
// Stashed changes

