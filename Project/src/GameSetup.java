

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
			for (int j = 1; j <= 13; j++){
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
	public void deal()
	{
		int i = 0;
		NodeForPlayers p = Play.playerOrder.front;
		while(i<8)//deals 8 cards
		{
			boolean test = true;
			while(test == true)
			{
				p.getPlayerData().drawCard(this);
				p = p.getNext();
				if(p == Play.playerOrder.front)
				{
					test = false;
				}
			}
			i++;
		}
	}

}


