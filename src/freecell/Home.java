/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 *  Class for the home cell 
 * @author Christian
 */
public class Home extends Deck{
    
    /**
     * Check if moving the provided card to the home cell is legal
     * @param c the input card
     * @return boolean: evaluation of the test
     */
    @Override
    public Boolean isLegal(Card c){ 
        if(c != null && (stack.isEmpty() && c.getValue().getVal() == 1
            ||  !stack.isEmpty() && //there are cards on the home deck
            super.topCard().getValue().isNextHome(c.getValue().getVal()) && 
            super.topCard().getSuit().isSameSuit(c.getSuit().getString())) 
            ){
            return true;
        }else{
            return false; 
        }
    }
    
    /**
     * check to see if the home cell is finished
     * @return boolean: evaluation of the check
     */
    public Boolean isFinished(){
        if (!super.isEmpty() && super.topCard().getValue().getVal() == 13){
            return true;
        }
        return false; 
    }
}
