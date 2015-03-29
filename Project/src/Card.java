import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Card
{
	public Card()
	{

	}
	public static void shuffle()//creates a shuffled deck, called "Cards.deck"
	{
		ArrayList<String[]> cardSource = new ArrayList<String[]>();
		/*first we put 52 little string arrays, each one being a card, into 
        the above cardSource set.
        The 1st index of the single card houses its value (e.g. A K Q J 1 2 3...)
        2nd index houses the suit (or 'color' in other languages)*/

		for (int i = 0; i < 4; i++)      //<--- card created suit by suit
		{  
			for (int j = 0; j < 13; j++)  //<--- and value by value
			{
				String[] card = {value[j], suits[i]};
				cardSource.add(card);
			}
		}

		/*we have stored the cards in perfect order, though.
        To shuffle them we fill the empty arraylist "deck" with random card selections 
        from the above source, eliminating from the source as we go */

		Random random = new Random();
		for (int i = 0; i < 52; i++)
		{
			int num = random.nextInt(52-i);
			deck.add(cardSource.get(num));
			cardSource.remove(num);
		}

		/*the resulting shuffled collection is the publically accessible 
      ArrayList "Cards.deck".*/
	}

	public static void deal(int numPlayers, int numCards)
	{ 
		ArrayList<String[]> hand = new ArrayList<String[]>();

		for (int i = 0; i < numPlayers; i++)
		{      
			hand.clear();
			for (int j = 0; j < numCards; j++)
			{
				hand.add(Card.take());//<--- a hand is built from cards in the "deck"
			}
			allHands.add(hand);      //<--- the hand is added to the allHands collection                                 
		}                           //     NOTE: the user's is the first in the collection,
		//     accessed via allHands.get(0) ( returns a String[] )
	}

	public static void exposeNext()//<--- first card on the deck is turned upwards on the
	{                              //     outPile and displayed.
		String[] card = deck.get(0);
		System.out.println("\nNext exposed card: \n" + card[0] + card[1]);
		deck.remove(0);
		outPile.add(card);  
	}

	public static void whatsMyHand()//<--- displays user's hand from the allHands collection.
	{                               //     (user hand is allHands(0))
		//     NOTE the result is not ordered (yet)
		System.out.println("Your hand: ");
		for (int i = 0; i < allHands.get(0).size(); i++)
		{   
			System.out.print(allHands.get(0).get(i)[0] + allHands.get(0).get(i)[1] + " ");
		}
	}
}

