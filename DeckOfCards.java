import java.util.Random;

public class CardGame
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    DeckOfCards deck = new DeckOfCards();
    deck.shuffle();
   
    Card c = deck.dealOneCard();
    while (c != null) {
      c.printIt();
      c = deck.dealOneCard();
    }
   
    System.out.println("All Cards were dealt");
  }
}

public class Card {
   private String face;
   private String suit;
 
   public Card(String _face, String _suit) {
      face = _face;
      suit = _suit;
   }
 
  public void printIt() {
    System.out.println(face + " " + suit);
  }
}
 
public class DeckOfCards
{
   private Card deck[]; // array of Card objects
   private int currentCard; // index of next Card to be dealt
   private final int NUMBER_OF_CARDS = 52; // constant number of Cards
   private Random randomNumbers; // random number generator
 
   // constructor fills deck of Cards
   public DeckOfCards()
   {
      String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
      String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
 
      deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
      currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
      randomNumbers = new Random(); // create random number generator
 
      // populate deck with Card objects
      for ( int count = 0; count < deck.length; count++ )
         deck[ count ] =
            new Card( faces[ count % 13 ], suits[ count / 13 ] );
   } // end DeckOfCards constructor
   
   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // after shuffling, dealing should start at deck[ 0 ] again
      currentCard = 0; // reinitialize currentCard
 
      // for each Card, pick another random Card and swap them
      for ( int first = 0; first < deck.length; first++ )
      {
         // select a random number between 0 and 51
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
         
         // swap current Card with randomly selected Card
         Card temp = deck[ first ];        
         deck[ first ] = deck[ second ];  
         deck[ second ] = temp;            
      } // end for
   } // end method shuffle
   
   // deal one Card
   public Card dealOneCard()
   {
      // determine whether Cards remain to be dealt
      if ( currentCard < deck.length )
         return deck[ currentCard++ ]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } // end method dealOneCard
   
  }
