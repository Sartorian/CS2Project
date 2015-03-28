public class Card extends Cards
{
   
   public static String[] take()          //<--- takes a card off the top of the deck.
   {     
      String[] card = deck.get(0);
      deck.remove(0);
      return card;
   }
   
   public static void remit(String[] card)//<--- puts a card on the top of the outPile       
   {
      outPile.add(card);
   }
}
