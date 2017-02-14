/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 *  Super class for deck subclasses
 * @author Christian
 */

import java.util.ArrayList; 
import java.util.Collections;


public abstract class Deck {
    ArrayList<Card> stack; 
    
    /** 
     * constructor for class
     */
    Deck(){
        stack = new ArrayList<Card>();
    }
    
    /**
     * removes the bottom card from top of the deck
     * @return Card  the card that is removed
     */
    public Card removeCard(){
        if(!this.isEmpty()){
            return stack.remove(stack.size() - 1);
        }
        return null; 
    }
    /** 
     * adds a card to the top of the stack
     * @param Card the card to add
     */
    public void addCard(Card c){
        if( c == null){
            //System.out.println("YOU CANNOT ADD A NULL FUCK FACE\n");
            return;
        }
        stack.add(c);
    }
    
    /**
     * returns the top card on the stack 
     * @return Card the top card on the stack
     */
    public Card topCard(){
        if(!this.isEmpty()){
            return stack.get((stack.size() -1 ));
        } 
        return null;
    }
    
    /**
     * prints the stack
     */
    public void displayDeck(){
        System.out.print("[");
        for (Card c : stack){
            System.out.print(c.getValue().getString() + c.getSuit().getString() + " " );
            
        }
        System.out.print("]\n");
    }
    
    /**
     * abstract class, for islegal 
     * Implemented by subclasses
     * @param c card that is being moved
     * @return Boolean evaluation of the test
     */
    public abstract Boolean isLegal(Card c);
        
    /**
     * Checks if the stack is empty 
     * @return Boolean
     */
    public Boolean isEmpty(){
        if (stack.size() <= 0){
            return true;
        }else{
            return false;
        } 
    }
    
    /**
     * Shuffles the stack of cards
     */
    public void shuffle(){
       Collections.shuffle(stack);
    }
    
}
