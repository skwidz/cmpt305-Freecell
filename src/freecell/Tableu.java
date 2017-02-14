/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 * Class for the Tableu rows
 * @author Christian
 */

import java.util.ArrayList; 

public class Tableu extends Deck {
    
    /**
     * constructor for the tableu object
     */
    Tableu(){
        stack = new ArrayList<Card>(); 
        
    }
    
    /** 
     * test if the move to the tableu is legal
     * @param c the input card
     * @return boolean evaluation 
     */
    @Override
    public Boolean isLegal(Card c){
        if (c != null && (stack.isEmpty() ||( super.topCard().getValue().isNextCard(c.getValue().getVal())  
            && super.topCard().getSuit().isDiffColor(c.getSuit().getString())))
            ){
            //System.out.println(" evaluation true" + c);
         return true;  
            
        } else {
            //System.out.println(" evaluation false" + c);
            return false;
        }
        
    }
}
