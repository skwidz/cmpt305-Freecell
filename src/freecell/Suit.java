/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 * Class for the suit of the card
 * @author Christian Ellinger
 */
public enum Suit {
    SPADE ("\u2660", Color.BLACK),
    CLUB("\u2663", Color.BLACK),
    HEART("\u2665", Color.RED),
    DIAMOND("\u2666", Color.RED);
    
    
    private String syml; 
    private Color color; 
    
    public enum Color{
    RED, BLACK;
    }
    /**
     * Constructor for the suit class
     * @param string the unicode string for the suit symbol
     * @param color the color object of the card
     */
    Suit(String string, Color color){
        this.syml = string;
        this.color = color; 
    }
    
   /**
    * Getter for the Suit name for the card
    * @return String: name of the suit of the current card
    */
    public String getString() { return this.syml;}
    
    /**
     * Getter for the color object of the suit
     * @return Color: the color object for the suit of the card
     */
    public Color getColor() {return this.color;}
    
    
    /** 
     * Checks if the input card is the same suit as this card
     * @param String: the suit string for comparison
     * @return Boolean: evaluation of the comparison
     */
    public Boolean isSameSuit(String s){
        return (this.syml.equals(s)); 
        //TODO: check string comparitor funciton. .equals may be int comparitor
    }
    /**
     * Checks if the input card is different than the current card
     * @param String:card for comparison
     * @return Boolean: value of the evaluation
     */
    public Boolean isDiffColor(String s){
        return !(this.color.equals(s));
    }
}

