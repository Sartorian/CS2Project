
public class Player
{
	private LinkedListForDeck hand;
	private String name;
	
	public Player(String n)
	{
		hand = new LinkedListForDeck();
		name = n;
	}
	public void drawCard(LinkedListForDeck d)
	{
		if(d.size() == 0)
		{
			d.replenish();//or whatever we call the method to refill the deck from the discard pile
		}
		else
		{
			
		}
	}
	
	public boolean playCard(LinkedListForDeck d, int i)
	{
		NodeForDeck curr = hand.getFront();
		int j = 0;
		
		if(hand.size() == 0)
			return false;
		else
		{
			while(curr!=null && j < i)
			{
				curr = curr.getNext();
				j++;
			}
			if(curr == null)//if you went too far
			{
				System.out.println("ERROR CODE 2");//index out of bounds error
			}
			else if(curr.getData().canPlay(d.getFront().getData()))//if you can play on the discard pile
			{
				d.addToFront(curr.getData());//place a copy of the card on top of the discard pile
				hand.remove(i);//delete copy from hand
				return true;//success. A winner is you.
			}
		}
		return false;
	}
	public LinkedListForDeck getHand()
	{
		return hand;
	}
	public String getName()
	{
		return name;
	}
}
