public class UsedPile
{
	private LinkedListForDeck cards;
	private LinkedListForDeck sourceDeck;
	
	public UsedPile(LinkedListForDeck d)
	{
		cards = new LinkedListForDeck();
		sourceDeck = d;
	}
	
	public LinkedListForDeck getCards()
	{
		return cards;
	}
	
	public void replenish()
    {
    	Card temp = cards.getFrontData();
    	cards.removeFront();
    	NodeForDeck curr = cards.getFront();
    	while(curr != null)
    	{
    		sourceDeck.addToFront(curr.getData());
    		curr = curr.getNext();
    		cards.removeFront();
    	}
    	sourceDeck.shuffleDeck();
    	cards.addToFront(temp);
    }
	public void revealTop()
	{
		cards.addToFront(sourceDeck.getFrontData());
		sourceDeck.removeFront();
	}
	
}
