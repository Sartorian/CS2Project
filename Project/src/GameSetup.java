

public class GameSetup{ //This could have the makeDeck, Deal, and numberOfPlayer classes

	private LinkedListForDeck deck;
	int players;

	public GameSetup()
	{
		//players = numberPlayers; //I know thats pretty tough to understand
		deck = new LinkedListForDeck();
		makeDeck();
		Shuffle();
	}

	public void makeDeck(){
		char suit;
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 12; j++){
				if (i == 0)
					suit = 'c';
				else if (i == 1)
					suit = 'd';
				else if (i == 2)
					suit = 's';
				else
					suit = 'h';
				Card addMe = new Card(j, suit);
				deck.addToEnd(addMe);
			}
		}
	}

	public void Shuffle()
	{
		deck.shuffleDeck();
	}
	public LinkedListForDeck getDeck()
	{
		return deck;
	}



}


