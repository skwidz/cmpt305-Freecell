/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 * Data class for things associated with cards
 * @author Christian Elliger
 */
public class Card {
    private Value value; 
    private Suit suit; 
    
   /**
    * Constructor for Card class
    * @param Suit the suit object for the card
    * @param Value the value object for the card
    */
   Card(Suit suit, Value value){
       this.value = value; 
       this.suit = suit;
   }
   
   /**
    * Getter for the value object tied to the card
    * @return Value: the value of the card
    */
   public Value getValue(){
       return value;
   }
   
   /**
    * Getter for the suit object of the card
    * @return Suit: the card's suit object
    */
   public Suit getSuit(){
       return suit;
   }
}
