/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import static java.lang.Integer.compare;

/**
 * Data class for the value of the card
 * @author Christian Ellinger
 */
public enum Value {
    ACE(1,"A"), 
    TWO(2,"2"), 
    THREE(3,"3"), 
    FOUR(4,"4"), 
    FIVE(5,"5"),
    SIX(6,"6"),
    SEVEN(7,"7"),
    EIGHT(8,"8"),
    NINE(9,"9"),
    TEN(10,"10"), 
    JACK(11,"J"),
    QUEEN(12,"Q"),
    KING(13,"K");
    
    private int val;
    private String str;
    
    /**
     * Constructor for the value object, 
     * only used by the dealer class
     * @param i The value of the card
     * @param s The string corresponding with the value for cards with letter vales
     */
    Value (int i, String s){
        this.val = i;
        this.str = s; 
    }
    
    /**
     * Getter for the string of the card number, as this may differ from 
     * its integer value in the case of K, Q, A, etc. 
     * @return String: the String of the card name
     */
    public String getString(){
        return this.str;
    }
    
    /**
     * Getter for the integer value of the card
     * @return Int i: the value of the card
     */
    public int getVal(){
        return this.val; 
    }
    
    /**
     * Checks if the integer value of the input card is one less than the
     * current card
     * Used for the tableu decks
     * @param Int i: the value of the card
     * @return boolean: true/false value of the evaluation
     */
    public boolean isNextCard(int i){
        return (i == (this.val - 1));

    }
    
    /**
     * Checks if the integer is one greater than the previous
     * Used for the home decks
     * @param i integer value of the next card
     * @return boolean: value of comparison
     */
    public boolean isNextHome(int i){
        return (i == (this.val + 1));
    }
}   
