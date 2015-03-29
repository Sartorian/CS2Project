import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

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
	//im testing this
}

