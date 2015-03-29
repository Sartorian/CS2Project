import java.util.Collections;

public class GameSetup{ //This could have the makeDeck, Deal, and numberOfPlayer classes

   private Deck = new LinkedListForDeck();

   public GameSetup(int numberPlayers){
      int players = numberPlayers; //I know thats pretty tough to understand
      }
      
   public void makeDeck(){
      char suit;
      for (int i = 0; i < 4; i++){
         for (int j = 0; j < 12; j++){
            if (i == 0)
               suit = 'c';
            else if (i == 1)
               suit = 'd';
            else if (i == 2)
               suit = 's';
            else
               suit = 'h';
            Card addMe = new Card(j, suit);
            Deck.addToEnd(addMe);
            }
         }
      }
      
   public void Shuffle(){
	   Collections.shuffle(Deck);
   		}
   
      
   
  	}

            
      