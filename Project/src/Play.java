import java.util.Scanner;
import java.util.Random;

public class Play
{
	public static void main(String[] args)
	{
		
		//
		GameSetup gs = new GameSetup();
		Scanner kb = new Scanner(System.in);
		Random aiCard = new Random();
		String playerName = "Liam Neeson";
		
		boolean userWin = false;
		boolean aiWin = false;
		
		Player user = new Player(playerName);
		Player ai = new Player("Nicolas Cage");
		
		//Should create the pile of played cards
		UsedPile pile = new UsedPile();
		LinkedListForDeck deck = gs.getDeck();

		System.out.println(pile.revealTop(deck));

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
				ai.drawCard(deck);
				ai.playCard(pile, 0);
			}
			//System.out.println(pile.getCard());

			if(user.getHand().size() == 0)
				userWin = true;
			if(ai.getHand().size() == 0)
				aiWin = true;
		}
		if(userWin)
			System.out.println(user.getName()+" wins!!!");
		else if(aiWin)
			System.out.println(ai.getName()+"wins!!!"); 
	}
}