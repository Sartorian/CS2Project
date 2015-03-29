import java.util.Scanner;

public class playCards//<--- just a test class to show common classes we all could use
{
	public static void main(String[] args)
	{  
		//from the Cards class:

		Card.shuffle();    //<--- made for a deck with no Jokers - add if you wish of course

		Card.deal(2,7);    //<--- = "2 players, 7 cards each."

		Card.whatsMyHand();//<--- this shows the first hand (the user's) in Cards.allHands                          //     NB the output is not sorted, unfortunately. Any helpers?

		Card.exposeNext(); //<--- shows the next card flipped up from the deck.


		//from the Card class:

		String[] card = Card.take();//<--- take from the deck. Deck reduces in size.

		if (card[0].equals(Card.outPile.get(0)[0]) || card[1].equals(Card.outPile.get(0)[1])) 
			// = "if "card" has the same value or suit as the card on top of the outPile", then
			Card.remit(card); //<--- card goes onto the outPile.(Crazy 8s rule) 
	}
}