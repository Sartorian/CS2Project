import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI2 extends JFrame{
    private JPanel panel1, panel2, panel3;
	private JLabel pan1Element1, pan1element2;
	private JLabel pan2element, pan3element;
	
	private JTextField textField;
    ImageIcon cardIcon;
   JLabel statement;
   
   public GUI2()
   {
      panel1 = new JPanel();          
      JLabel statement = new JLabel("one");
      panel1.add(statement);
      statement.setText("");
      
      cardIcon = new ImageIcon("10.png");   
      JLabel img = new JLabel(cardIcon);	
	  panel1.add(img);
      
      img.setIcon(new ImageIcon("9.png"));
      
      panel2 = new JPanel(new FlowLayout());
      panel2.add(new JLabel(cardIcon));
      panel2.add(new JLabel(cardIcon));
      
      add(panel1, BorderLayout.NORTH);
      add(panel2, BorderLayout.CENTER);
      
      setTitle("Crazy Eights");
      setSize(300, 200);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      //setResizable(false);
   }
   public void changeStuff(String stuff)
   {
      statement.setText("3");
   }
   
   public static void main(String[] args)
   {
      GUI2 newGUI = new GUI2();      
      newGUI.changeStuff("Test to change");
   }
}
