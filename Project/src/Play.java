import java.util.Scanner;
//import java.util.Random;

public class Play
{
	public static UsedPile pile;
	public static circleLinkedList playerOrder;
	public static NodeForPlayers currUser;

	public static void main(String[] args)
	{
		GameSetup gs = new GameSetup();
		Scanner kb = new Scanner(System.in);
		//Random aiCard = new Random();
		String playerName = "Player";

		boolean userWin = false;
		boolean aiWin = false;

		Player user = new Player(playerName, false);//not ai
		Player ai = new Player("AI", true);//ai
		playerOrder = new circleLinkedList();
		playerOrder.addToEnd(user);
		playerOrder.addToEnd(ai);
		currUser = playerOrder.front;
		//Should create the pile of played cards
		LinkedListForDeck deck = gs.getDeck();
		pile = new UsedPile(deck);
		pile.revealTop();
		gs.deal();
		System.out.println("First Card: " + pile.getCards().getFrontData());
		String comment = "First card: "; //<-- this once-only statement can become "" after the first turn.
		//GUI SUBSTITUTE:
		GUI gui = new GUI();
		gui.makeGUI(comment,
				pile.getCards().getFrontData(), 
				user.getName()+"'s turn", 
				user.getHand(),
				"Please choose the position of your card");
		while(!userWin && !aiWin)//if win conditions are not met
		{
			if (currUser.getPlayerData() == ai)//if it is the AI's turn, we automate it.
			{
				int i = 0;
				while(!ai.playCard(pile, i) && i < ai.getHand().size())//runs through entire hand until it can play a card
				{
					i++;
				}
				if(i == ai.getHand().size())//if it could not play a card, it will draw
				{
					ai.drawCard(gs);
					ai.playCard(pile, 0);//when you draw, the card is always added to the first index of the hand
				}
			}
			
		}
		kb.close();
		if(userWin)
			System.out.println(user.getName()+" wins!!!");
		//GUI SUBSTITUTE:
		//gui.wonOrLost(user.getName()+" wins!!!");
		else if(aiWin)
			System.out.println(ai.getName()+"wins!!!"); 
		//GUI SUBSTITUTE
		//gui.wonOrLost(ai.getName()+" wins!!!");
	}
}