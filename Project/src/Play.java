import java.util.Scanner;
//import java.util.Random;

public class Play
{
	public static UsedPile pile;
	public static void main(String[] args)
	{
		
		//
		GameSetup gs = new GameSetup();
		Scanner kb = new Scanner(System.in);
		//Random aiCard = new Random();
		String playerName = "Liam Neeson";
		
		boolean userWin = false;
		boolean aiWin = false;
		
		Player user = new Player(playerName, false);//not ai
		Player ai = new Player("Nicolas Cage", true);//ai
      circleLinkedList playerOrder = new circleLinkedList();
      playerOrder.addToEnd(user);
      playerOrder.addToEnd(ai);
		
		//Should create the pile of played cards
		LinkedListForDeck deck = gs.getDeck();
		pile = new UsedPile(deck);
		pile.revealTop();
		System.out.println("First Card: " + pile.getCards().getFrontData());

		//
		while(userWin == false || aiWin == false)
		{
			System.out.println(user.getName()+"'s turn");
			System.out.println(user.getHand());
			System.out.println("Please choose the position of your card");
			int i = kb.nextInt();
			if(!user.playCard(pile, i))
			{
				i = kb.nextInt();
				user.playCard(pile, i);
			}
			System.out.println(pile.getCards().getFront());//displays top card of discard pile

			System.out.println(ai.getName()+"'s turn");  
			int j = 0;
			while(!ai.playCard(pile, j) && j < ai.getHand().size())
			{
				j++;
			}
			if(j == ai.getHand().size())
			{
				ai.drawCard(gs);
				ai.playCard(pile, 0);
			}
			//System.out.println(pile.getCard());

			if(user.getHand().size() == 0)
				userWin = true;
			if(ai.getHand().size() == 0)
				aiWin = true;
		}
		kb.close();
		if(userWin)
			System.out.println(user.getName()+" wins!!!");
		else if(aiWin)
			System.out.println(ai.getName()+"wins!!!"); 
	}
}