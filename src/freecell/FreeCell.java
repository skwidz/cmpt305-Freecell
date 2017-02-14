/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 *  Class for the freecell rows
 * @author Christian
 */
public class FreeCell extends Deck {
    
    /**
     * check if the move to the freecell is legal
     * just checks if its empty
     * @param c a card object
     * @return boolean: is the cell empty
     */
    @Override
    public Boolean isLegal(Card c){
        if(stack.isEmpty() && c != null){
            return true;
        }   
        return false;
    //return true;
    }
    
    
}
