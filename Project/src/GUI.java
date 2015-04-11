
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener{

	private JPanel panel1, panel2, panel3;
	private JLabel statementA, statementB, statementC, discardPile, controls, deckEdge1, deckEdge2;

	private JButton deck, pass;
	private ImageIcon cardIcon, passIcon;

	JButton[] userCards;						//<-- the card images array for the user's hand.
	
	public GUI (String sentence)
	{
		panel1 = new JPanel();  

		statementA = new JLabel(sentence);
        statementA.setFont(new Font("Cambria", Font.PLAIN, 72));

		panel1.add(statementA);

		cardIcon = new ImageIcon(cardImageFileName(Play.pile.getCards().getFrontData())); 
		discardPile = new JLabel(cardIcon);
		panel1.add(discardPile);
		if(Play.currUser == Play.playerOrder.front)
		{
			deck = new JButton(new ImageIcon("src/b1fv.png"));//click to draw
			deck.addActionListener(this);
			deckEdge1 = new JLabel(new ImageIcon("src/b1pr.png")); 
			deckEdge2 = new JLabel(new ImageIcon("src/b1pr.png")); 
			
			panel1.add(deck);		
			panel1.add(deckEdge1);
		    panel1.add(deckEdge2);

		    statementB = new JLabel(Play.currUser.getPlayerData().getName()+"'s turn");
		    statementB.setFont(new Font("Cambria", Font.PLAIN, 18));
			panel1.add(statementB);
			
			panel2 = new JPanel(new GridLayout(1, Play.currUser.getPlayerData().getHand().size()));// <-- the hand of the player 
			userCards = new JButton[Play.currUser.getPlayerData().getHand().size()];
			for (int i=0; i < Play.currUser.getPlayerData().getHand().size(); i++)
			{
				String filename = cardImageFileName(Play.currUser.getPlayerData().getHand().get(i));//<-- the card's equivalent images' file name is used (i.e."1.png")	
				userCards[i] = new JButton(new ImageIcon(filename));
				userCards[i].addActionListener(this);
				panel2.add(userCards[i]);
			}
			
			panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			if (sentence.equals("Sorry. Cant draw twice"))
			{
				panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
				passIcon = new ImageIcon("src/Pass.jpg");
				pass = new JButton(passIcon);
				pass.addActionListener(this);
				panel3.add(pass);
			}
			else
			{
				controls = new JLabel("Click a card to play it or click the deck to draw a card.");
				controls.setFont(new Font("Cambria", Font.PLAIN, 18));
				panel3.add(controls);
			}
			
			//A very mild clay tone for the information texts:	
		    panel1.setOpaque(true);
			panel1.setBackground(new Color(200,155,155));
			
			add(panel1, BorderLayout.NORTH);
			add(panel2, BorderLayout.CENTER);
			add(panel3, BorderLayout.SOUTH);
			setTitle("Crazy Eights");
			setSize(1100, 273);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		else
		{
			panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			controls = new JLabel("Opponent's turn. Please wait.");
			controls.setFont(new Font("Cambria", Font.PLAIN, 18));
			panel3.add(controls);
			
			add(panel1, BorderLayout.NORTH);
			add(panel3, BorderLayout.SOUTH);
			setTitle("Crazy Eights");
			setSize(1100, 273);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			Play.AITurn();
		}
	}
	public GUI(boolean b, String victory)//creates a new GUI at game end
	{
		panel1 = new JPanel();  

		statementA = new JLabel(victory);
        statementA.setFont(new Font("Cambria", Font.PLAIN, 72));

		panel1.add(statementA);

		/*cardIcon = new ImageIcon(cardImageFileName(Play.pile.getCards().getFrontData())); 
		discardPile = new JLabel(cardIcon);
		panel1.add(discardPile);*/

		add(panel1, BorderLayout.NORTH);
		//add(panel2, BorderLayout.CENTER);
		//add(panel3, BorderLayout.SOUTH);
		setTitle("Crazy Eights");
		setSize(1100, 273);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(deck))//if they clicked the deck
		{

			if (Play.currUser.getPlayerData().canDraw())
			{
				Play.currUser.getPlayerData().drawCard(Play.gs);//draw a card
				new GUI("Last played card: ");			
			}
			else
				new GUI("Sorry. Cant draw twice");
		}
		else if (e.getSource().equals(pass))
		{
			Play.currUser.getPlayerData().canDraw(true);
			Play.currUser = Play.currUser.getNext();
			new GUI("Last played card: ");
			Play.AITurn();
		}
		else
		{
			int i = 0;
			while (i < userCards.length && userCards[i]!=e.getSource())//loops through userCards to find what triggered the event
			{
				i++;
			}

			if(Play.currUser.getPlayerData().playCard(Play.pile, i))//plays the chosen card if possible
			{
				if(Play.currUser.getPlayerData().getHand().size() == 0)
				{
					new GUI(true, Play.currUser.getPlayerData().getName() + " Won!");
					return;
				}
				if (!(Play.skipTurn)){
					Play.currUser = Play.currUser.getNext();
					Play.AITurn();
					update();
					new GUI("Last played card: ");
				}
				else {
					Play.skipTurn = false;
					new GUI("Last played card: ");
				}            
			}
			else
			{
				new GUI("Last played card: ");
				return;

			}
		}
	}
	public void update()//updates the GUI using code from constructor to keep display up-to-date with game
	{
		//statementA.setText("Last card played:");//gets rid of first turn text
		panel1.remove(discardPile);
		panel1.remove(deck);
		panel1.remove(deckEdge1);
		panel1.remove(deckEdge2);
		panel1.remove(statementB);
		for(int i = 0; i < userCards.length; i++)//clear old hand display
		{
			panel2.remove(userCards[i]);
		}
		if(Play.currUser == Play.playerOrder.front)
		{
			cardIcon = new ImageIcon(cardImageFileName(Play.pile.getCards().getFrontData())); 
			discardPile = new JLabel(cardIcon);
			panel1.add(discardPile);
			panel1.add(deck);
			panel1.add(deckEdge1);
			panel1.add(deckEdge2);
			
			statementB = new JLabel(Play.currUser.getPlayerData().getName()+"'s turn");
		    statementB.setFont(new Font("Cambria", Font.PLAIN, 18));
			panel1.add(statementB);

			for (int i=0; i < Play.currUser.getPlayerData().getHand().size(); i++)//show new hand display
			{
				String filename = cardImageFileName(Play.currUser.getPlayerData().getHand().get(i));//<-- the card's equivalent images' file name is used (i.e."1.png")	
				userCards[i] = new JButton(new ImageIcon(filename));
				userCards[i].addActionListener(this);
				panel2.add(userCards[i]);
			}
			controls.setText("Click a card to play it or click the deck to draw a card.");
		}
		else
		{
			cardIcon = new ImageIcon(cardImageFileName(Play.pile.getCards().getFrontData())); 
			discardPile = new JLabel(cardIcon);
			panel1.add(discardPile);
			controls.setText("Opponent's turn. Please wait.");
		}

	}

	
	
	public String cardImageFileName(Card card)  //<-- returns the file name string.
	{	
		char suit = card.getSuitChar();
		int value = card.getValueNum();

		char[] suits = {'c','s','h','d'};

		int suitIndex = 0; 
		for (int i=0; i<suits.length;i++) 
			if (suit == suits[i]) 
				suitIndex = i;			//<-- i.e. clubs ('c') returns 0, therefore 8 of clubs = images[0][8]

		String[][] images = {{"Blank","1","49","45","41","37","33","29","25","21","17","13","9","5"},
				{"Blank","2","50","46","42","38","34","30","26","22","18","14","10","6"},
				{"Blank","3","51","47","43","39","35","31","27","23","19","15","11","7"},
				{"Blank","4","52","48","44","40","36","32","28","24","20","16","12","8"}};
		return "src/" + images[suitIndex][value] + ".png";
	}
}

