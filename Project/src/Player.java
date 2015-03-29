
public class Player
{
	private LinkedListForDeck hand;
	private String name;
	
	public Player(String n)
	{
		hand = new LinkedListForDeck();
		name = n;
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
			if(curr == null)
			{
				System.out.println("ERROR CODE 2");
			}
			else if(curr.getData().canPlay(d.getFront().getData()))
			{
				d.addToFront(curr.getData());
				hand.remove(i);
				return true;
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
