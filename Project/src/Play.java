public class Play
{
   public static void main(String[] args)
   {
      
      //
      String playerName = "Liam Neeson";
      boolean userWin = false;
      boolean aiWin = false;
      Deck deck = new Deck();
      
      Player user = new Player(playerName);
      Player ai = new Player("Nicolas Cage");
      deck.makeDeck();
      deck.shuffle();
      deck.dealAll();
      System.out.println(deck.revealTop());
      
      //
      while(userWin == false || aiWin == false)
      {
         
         System.out.println(user.getHand());
         user.playCard();                           
         ai.playCard();         
         if(user.size() == 0)
         userWin == true;
         if(ai.size() == 0)
         aiWin == true;
      }
   

   
   
   }
}