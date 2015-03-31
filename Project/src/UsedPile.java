import Card;
import LinkedListForDeck;
import NodeForDeck;


public class UsedPile
{
	private LinkedListForDeck cards;
	
	public UsedPile()
	{
		cards = new LinkedListForDeck();
	}
	
	public LinkedListForDeck getCards()
	{
		return cards;
	}
	
	public void replenish(LinkedListForDeck d)
    {
    	NodeForDeck curr = cards.getFront();
    	Card temp = null;
    	while(curr!=null)
    	{
    		temp = curr.getData();
    		cards.removeFront();
    		d.addToFront(temp);
    	}
    	d.shuffleDeck();	
    }
	
}
