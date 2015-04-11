//import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//import java.io.*;
//import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener{



	private JPanel panel1, panel2, panel3;
	private JLabel statement, discardPile, controls;
	//private JLabel pan2element, pan3element;

	//private JTextField input;
	private JButton deck;
	private ImageIcon cardIcon;

	JButton[] userCards;						//<-- the card images array for the user's hand.

	boolean flag = false;
	public int inputAnswer;

	public GUI ()
	{
		panel1 = new JPanel();          
		statement = new JLabel("Last played card: ");
		panel1.add(statement);

		cardIcon = new ImageIcon(cardImageFileName(Play.pile.getCards().getFrontData())); 
		discardPile = new JLabel(cardIcon);
		panel1.add(discardPile);
		if(Play.currUser == Play.playerOrder.front)
		{
			deck = new JButton(new ImageIcon("src/b1fv.png"));//click to draw

			panel1.add(deck);

			panel2 = new JPanel(new GridLayout(1, Play.currUser.getPlayerData().getHand().size() + 1));// <-- the hand of the player 
			panel2.add(new JLabel(Play.currUser.getPlayerData().getName()+"'s turn"));
			userCards = new JButton[Play.currUser.getPlayerData().getHand().size()];
			for (int i=0; i < Play.currUser.getPlayerData().getHand().size(); i++)
			{
				String filename = cardImageFileName(Play.currUser.getPlayerData().getHand().get(i));//<-- the card's equivalent images' file name is used (i.e."1.png")	
				userCards[i] = new JButton(new ImageIcon(filename));
				userCards[i].addActionListener(this);
				panel2.add(userCards[i]);
			}
			panel3 = new JPanel();
			controls = new JLabel("Click a card to play it or click the deck to draw a card.");
			panel3.add(controls);
			add(panel1, BorderLayout.NORTH);
			add(panel2, BorderLayout.CENTER);
			add(panel3, BorderLayout.SOUTH);
			setTitle("Crazy Eights");
			setSize(800, 450);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		else
		{
			panel3 = new JPanel();
			controls = new JLabel("Opponent's turn. Please wait.");
			panel3.add(controls);
			add(panel1, BorderLayout.NORTH);
			add(panel3, BorderLayout.SOUTH);
			setTitle("Crazy Eights");
			setSize(800, 450);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			Play.AITurn();
		}
		

		
	}


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(deck))//if they clicked the deck
		{
			if(Play.currUser.getPlayerData().canDraw())//if they did not yet draw
			{
				Play.currUser.getPlayerData().drawCard(Play.gs);//draw a card
				update();
			}
			else return;
		}
		else
		{
			int i;
			for(i = 0; i < userCards.length; i++)//loops through userCards to find what triggered the event
			{
				if(userCards[i]==e.getSource())//when found
				{
					break;//end loop
				}
			}
			if(Play.currUser.getPlayerData().playCard(Play.pile, i))//plays the chosen card if possible
			{
				update();
				Play.currUser = Play.currUser.getNext();
				update();
				new GUI();
			}
			else
			{
				return;
			}
		}
	}
	public void update()//updates the GUI using code from constructor to keep display up-to-date with game
	{
		statement.setText("Last card played:");//gets rid of first turn text
		panel1.remove(discardPile);
		panel1.remove(deck);
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

