import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.ArrayList;

public class GUI extends JFrame {//implements ActionListener{
	
	
	
	private JPanel panel1, panel2, panel3, panel4;
	private JLabel statementA, img, statementB, statementC;
	private JLabel pan2element, pan3element;
	
	private JTextField input;
	private JButton go;
	private ImageIcon cardIcon;
	
	String[] userPngs;						//<-- the card images array for the user's hand.

	boolean flag = false;
	public static int inputAnswer;

	public GUI ()
   {}
   
   public void makeGUI3(String heresTheFirstCard, 
					 Card card, 
					 String whoseTurn, 
					 LinkedListForDeck hand, 
					 String question)
	{		
      panel1 = new JPanel();          
      JLabel statement = new JLabel(heresTheFirstCard);
      panel1.add(statement);
      
      cardIcon = new ImageIcon(cardImageFileName(card));  
	   panel1.add(new JLabel(cardIcon));
      
      panel2 = new JPanel(new GridLayout(1, hand.size() + 1));// <-- the hand of the player 
	   panel2.add(new JLabel(whoseTurn));
	    
	   userPngs = new String[hand.size()];
	   for (int i=0; i<hand.size(); i++)
		{
			String filename = cardImageFileName(hand.get(i)); 	//<-- the card's equivalent images' file name is used (i.e."1.png")	
			panel2.add(new JLabel(new ImageIcon(filename)));
		} 

      panel3 = new JPanel();
		panel3.add(new JLabel(question));              //<--  at the bottom of the GUI the question is asked
                              							   //     either which suit or which card number to play.
	        
	   input = new JTextField(2);
	   input.setEditable(true);
		panel3.add(input);

      go = new JButton("Ready");
      panel3.add(go);
      
      add(panel1, BorderLayout.NORTH);
      add(panel2, BorderLayout.CENTER);
      add(panel3, BorderLayout.SOUTH);
      
      setTitle("Crazy Eights");
      setSize(600, 400);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
	}

	public boolean answer()
	{
		flag = false;
		go.addActionListener(new ActionListener()//http://stackoverflow.com/questions/18903751/how-can-i-add-an-actionlistener-to-a-jbutton-in-a-static-instance
        {
           public void actionPerformed(ActionEvent e)
           {           
              String ans = input.getText();
              inputAnswer = Integer.parseInt(ans);
              flag = true;
           }
        });   
		return flag;
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

		String[][] images = {{"Blank","1","49","45","141","37","33","29","25","21","17","13","9","5"},
				{"Blank","2","50","46","42","38","34","30","26","22","18","14","10","6"},
				{"Blank","3","51","47","43","39","35","31","27","23","19","15","11","7"},
				{"Blank","4","52","48","44","40","36","32","28","24","20","16","12","8"}};
		return "" + images[suitIndex][value] + ".png";
	}
   
   
   
	/*public static void main (String[] args)
	{
		LinkedListForDeck test = new LinkedListForDeck();
		test.addToFront(new Card(3, 'h'));
		test.addToFront(new Card(3, 'h'));
		test.addToFront(new Card(3, 'h'));
		test.addToFront(new Card(3, 'h'));
		Card card = new Card(3, 'h');
      
		GUI3  gui = new GUI3();
      
      gui.makeGUI3("heresTheFirstCard", 
				               card, 
				               "  " + "it's Geoff's turn", 
				               test, 
				               "What's life all about?");
      while(!gui.answer()){}
      int i = inputAnswer;
      System.out.println(i);
	}*/
}
	
