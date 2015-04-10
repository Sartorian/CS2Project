
public class Player
{
	private LinkedListForDeck hand;
	private String name;
   private static String eightSuit = "";//will help with the eight card being played and selecting a suit
	
	public Player(String n)
	{
		hand = new LinkedListForDeck();
		name = n;
      
	}
	public void drawCard(GameSetup d)
	{
		if(d.getDeck().size() == 0)
		{
			Play.pile.replenish();
			drawCard(d);
		}
		else
		{
			hand.addToFront(d.getDeck().getFrontData());
			d.getDeck().removeFront();
		}
	}
	
	public boolean playCard(UsedPile d, int i)
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
			else if(curr.getData().canPlay(d.getCards().getFrontData(), eightSuit))//if you can play on the discard pile
			{
            if (curr.getData().getValue().equals("2")){
            }   
            else if (curr.getData().getValue().equals("8")){
               //eightSuit =                               //add a way for player to input their desired suit here <--- ///******
            }
            else if (curr.getData().getValue().equals("J")){
            }
				d.getCards().addToFront(curr.getData());//place a copy of the card on top of the discard pile
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
