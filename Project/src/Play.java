import java.util.Scanner;
//import java.util.Random;

public class Play
{
	public static UsedPile pile;
	public static circleLinkedList playerOrder;
	public static NodeForPlayers currUser;
	public static GameSetup gs;
	public static GUI gui;
   public static boolean skipTurn; //used to tell if the next turn will be skipped or not

	public static void main(String[] args) throws Exception
	{
		gs = new GameSetup();
		Scanner kb = new Scanner(System.in);
		//Random aiCard = new Random();
		String playerName = "Player";
      skipTurn = false;

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
		//System.out.println("Last played card: " + pile.getCards().getFrontData());

		gui = new GUI("Here's the first card: "); //the first 
		
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
            if (!skipTurn){
				   currUser = playerOrder.front;
               }
            else {
               skipTurn = false;
               }
				gui = new GUI("Your computer played: ");
			}
		}
		kb.close();
		if(userWin)
		{
			System.out.println(user.getName()+" wins!!!");
			gui.wonOrLost(user.getName()+" wins!!!");
		}
		else if(aiWin)
		{
			System.out.println(ai.getName()+"wins!!!"); 
			gui.wonOrLost(ai.getName()+" wins!!!");
		}
	}
	public static void AITurn()
	{
		if (currUser == playerOrder.end)//if it is the AI's turn, we automate it.
		{
			int i = 0;
			while(!currUser.getPlayerData().playCard(pile, i) && i < currUser.getPlayerData().getHand().size())//runs through entire hand until it can play a card
			{
				i++;
			}
			if(i == currUser.getPlayerData().getHand().size())//if it could not play a card, it will draw
			{
				currUser.getPlayerData().drawCard(gs);
				currUser.getPlayerData().playCard(pile, 0);//when you draw, the card is always added to the first index of the hand
			}
         if (!skipTurn){
			   currUser = playerOrder.front;
            }
         else {
            skipTurn = false;
            }
			gui = new GUI("Your computer played: ");
		}
	}
}