

public class GameSetup{ //This could have the makeDeck, Deal, and numberOfPlayer classes

	private LinkedListForDeck deck = new LinkedListForDeck();
	int players;

	public GameSetup(int numberPlayers)
	{
		players = numberPlayers; //I know thats pretty tough to understand
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

	public void Shuffle(){
		//do stuff here I guess
	}



}


