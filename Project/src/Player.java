
public class Player
{
	private LinkedListForDeck hand;
	private String name;
	public static String eightSuit = "";//will help with the eight card being played and selecting a suit
	private boolean ifAI;
	private boolean canDraw = true;

	public Player(String n, boolean AI)
	{
		hand = new LinkedListForDeck();
		name = n;
		ifAI = AI;//allows to check for the player being AI or not

	}
	public void drawCard(GameSetup d)
	{
		if(canDraw == false)
		{
			return;
		}
		if(d.getDeck().size() == 0)
		{
			Play.pile.replenish();
			drawCard(d);
		}
		else
		{
			hand.addToFront(d.getDeck().getFrontData());
			d.getDeck().removeFront();
			canDraw = false;
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
					if (ifAI){
						eightSuit = hand.getFront().getData().getSuit();//an ai will pick the suit from their first card.
					}
					else {   
						eightSuit = curr.getData().getSuit(); //add a way for player to input their desired suit here <--- ///******
					}
				}
				else if (curr.getData().getValue().equals("J")){
				}
				d.getCards().addToFront(curr.getData());//place a copy of the card on top of the discard pile
				hand.remove(i);//delete copy from hand
				canDraw = true;
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
	public boolean canDraw()
	{
		return canDraw;
	}
	public void canDraw(boolean b)
	{
		canDraw = b;
	}
}
