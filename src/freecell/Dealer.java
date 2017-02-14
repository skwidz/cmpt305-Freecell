/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;


import java.util.List;
import java.util.ArrayList;
/**
 *  Dealer class creates a shuffled list of cards 
 * @author Christian Ellinger
 * 
 */
public class Dealer extends Deck {
   
    /**
     * Constructor for the dealer class
     */
    Dealer(){
        stack = new ArrayList<Card>();
        for(Suit s : Suit.values()){
            for(Value v : Value.values()){
                super.addCard(new Card(s,v)); //comes from deck
            }
        }
        super.shuffle(); //comes from deck
        
    }
    
   
    /**
     * Implementation of the dealers class
     * requirement for the abstract method
     * does nothing but return true
     * @param c
     * @return 
     */
    public Boolean isLegal(Card c){
        return true;
    }
}