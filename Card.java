public class Card {
    private final String face;
    private final String suit;
    
    // constructor
    public Card(String cardFace, String cardSuit) {
       this.face = cardFace; // initialize face of card
       this.suit = cardSuit; // initialize suit of card
    } // end of card constructor
    
    // full name of card
    public String cardName() {
       return face + " of " + suit;
    }
 }