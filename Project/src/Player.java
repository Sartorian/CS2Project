public class Player
{
	private LinkedListForDeck hand;
	private String name;
    private static String eightSuit = "";//will help with the eight card being played and selecting a suit
	private boolean ifAI;
   
	public Player(String n, boolean AI)
	{
		hand = new LinkedListForDeck();
		name = n;
      ifAI = AI;//allows to check for the player being AI or not
      
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
			if(curr == null) //if you went too far
			{
				System.out.println("ERROR CODE 2"); //index out of bounds error
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
               //eightSuit =                               //add a way for player to input their desired suit here <--- ///******
               }
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

public class Player 
{
	private String name;
	private CircularLinkedList hand;
	
	public Player(String name, CircularLinkedList hand)
	{
		this.name = name;
		this.hand = hand;
	}
	
	public void setName(String name2)
	{
		this.name = name2;
	}

	public void setHand(CircularLinkedList hand2)
	{
		this.hand = hand2;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public CircularLinkedList getHand()
	{
		return this.hand;
	}
	
	public void drawCard(CircularLinkedList d)
	{
		if(d.size() == 0)
		{
			d.replenish();//or whatever we call the method to refill the deck from the discard pile
		}
		else
		{
			
		}
	}
	
	public boolean playCard(CircularLinkedList d, int i)
	{
		NodeForDeck curr = hand.getFront();
		int j = 0;
		
		if(hand.size() == 0)
		{	
			return false;
		}
		
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
} 
