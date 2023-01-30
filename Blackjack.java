// Dansie Howard
// CS145
// Lab 4: Card Game

import java.util.*;

public class Blackjack {
   private static Deck deck = new Deck();
   public static void main(String[] args) {
   int gameStart = 0; // begin game
   int cardValue = 0; // value spit out by converter
   int playerCount = 0; // total value of player cards
   int dealerCount = 0; // total value of dealer cards
   Scanner input = new Scanner(System.in);
   
   instructions();
   gameStart = input.nextInt;
      if(gameStart == 2) {
      System.out.println("Thanks for stopping by! Come play soon");
      } // end if gamestart
   
   String card;
   // step 1
   card = deck.draw();
   cardValue = hit(card); // counts cards total
   playerCount += cardValue;
   System.out.println("You drew " + card);
   System.out.println("Your current card value is " + playerCount);
   // step 2
   card = deck.draw();
   cardValue = hit(card); // counts cards total
   dealerCount += cardValue;
   System.out.println("Dealer drew " + card);
   System.out.println("The Dealer's current card value is " + dealerCount);

   // step 3
   card = deck.draw();
   cardValue = hit(card); // counts cards total
   playerCount += cardValue;
   System.out.println("You drew " + card);
   System.out.println("Your current card value is " + playerCount);
   
   // step 4
   card = deck.draw();
   String faceDown = card;
   cardValue = hit(card); // counts cards total
   dealerCount += cardValue;
   System.out.println("Dealer drew a facedown card");
   
   // step 5
   System.out.println("Would you like another card? Press 1 for hit, 2 for stay");
   int answer = input.nextInt();
   
   while(answer == 1) {
      card = deck.draw();
      cardValue = hit(card); // counts cards total
      playerCount += cardValue;
      if(playerCount > 21 && cardValue == 11) {
      playerCount = playerCount - 10;
      }
      System.out.println("You drew " + card);
      System.out.println("Your current card value is " + playerCount);
      
      if(playerCount > 21) {
         System.out.println("BUST! Try Again.");         
         playAgain();
         } // end if statement
         if(playerCount == 21) {
         System.out.println("Blackjack! You hit 21");
         playAgain();
         } // end if 21 statement
         
      System.out.println("Would you like another card? Press 1 for hit, 2 for stay");
      answer = input.nextInt();
      }
      System.out.println("Dealer reveals facedown card " + faceDown);
      System.out.println("Dealer count is " + dealerCount);
      if(dealerCount > 21 && cardValue == 11) {
      dealerCount = dealerCount - 10;
      }

    while(dealerCount < 17) {
      card = deck.draw();
      cardValue = hit(card); // counts cards total
      dealerCount += cardValue;
      System.out.println("Dealer drew " + card);
      System.out.println("The Dealer's current card value is " + dealerCount);      
        if(dealerCount > 21) {
         System.out.println("Dealer Busts! You Win.");
         playAgain();
         } // end if statement
         if(dealerCount == 21) {
         System.out.println("Dealer makes 21");
         playAgain();
         } // end if dealer 21
   } // end of while loop
   if(playerCount == dealerCount) {
      System.out.println("The game is a draw");
      } // end if tie
      else if(playerCount > dealerCount) {
         System.out.println("You win with a total of " + playerCount + " over Dealer's total of " + dealerCount);
         }
         else {
            System.out.println("Dealer beats you with " + dealerCount + " over your total of " + playerCount);
            } // end else
            
            playAgain();
} // main

   public static void playAgain() {
   Scanner input = new Scanner(System.in);
   System.out.println("Would you like to play Blackjack again? 1 for yes, 2 for no");
   int response = input.nextInt();
      if(response == 1) {
         main(null); // calls main
         }
      else { System.exit(0);} // ends program
   } // end play again
   public static void instructions() {
   System.out.println("Welcome to Blackjack. A game versus a dealer where the goal is to reach 21 without going over");
   System.out.println("Are you ready to play? 1 for yes, 2 for no");
   } // end of instructions method
   
   
   public static int hit(String newCard) { // method to convert card name to card value
      int cardValue = 0;
      Scanner cardChecker = new Scanner(newCard); // scanner to read newCard 
      switch(cardChecker.next()) { // switch case to determine value of card
      
         case "Ace":
         cardValue = 11; // ace can be converted to 1 later
         break;
         
         case "Two":
         cardValue = 2;
         break;
         
         case "Three":
         cardValue = 3;
         break;
         
         case "Four":
         cardValue = 4;
         break;
         
         case "Five":
         cardValue = 5;
         break;
         
         case "Six":
         cardValue = 6;
         break;
         
         case "Seven":
         cardValue = 7;
         break;
         
         case "Eight":
         cardValue = 8;
         break;
         
         case "Nine":
         cardValue = 9;
         break;
         
         case "Ten":
         cardValue = 10;
         break;
         
         case "Jack":
         case "Queen":
         case "King":
         cardValue = 10;
         break;
      }
      return cardValue; 
   } // end of hit
} // end of blackjack class   
