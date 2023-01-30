// Dansie Howard
// CS145
// Lab 4: Card Game
//

import java.util.*;

public class Deck {
      private ArrayList <String> cards = new ArrayList <String> (); // create arraylist
      private Stack <String> deck = new Stack <String> (); // creates new stack
      private Random rand = new Random(); // creates random numbers

   public Deck() {
      String [] faces = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
      String [] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
      
      // this creates 52 card deck in order
      for(int i=0; i<suits.length; i++) {
         for(int j=0; j<faces.length; j++) {
         Card cardName = new Card(faces[j], suits[i]);
         cards.add(cardName.cardName()); // adds unique card
         }
      } // end of for loop
      
      for(int i=0; i<52; i++) {
         int shuffler = rand.nextInt(cards.size()); // size equates to the size of the arraylist
         String rcard = cards.get(shuffler); // pulls a random card
         deck.push(rcard); // add to stack
         cards.remove(shuffler); // remove the card that was added to stack
      } // end for loop
     // System.out.println(deck.toString());
      // System.out.println(deck.peek()); // peek = look, pop = remove
   } // end of deck method
   public String draw() {
      return deck.pop();
   } // end of draw
} // end of Deck class