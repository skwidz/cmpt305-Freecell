/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Scanner;

/**
 *  Controller for the main game
 *  handles moving cards around, spawning decks and the dealer, 
 *  and checking if the game has completed
 * @author Christian Ellinger
 */
public class GameController {

    /**
     * @param args the command line arguments
     */
    
    public static Tableu[] tabs = new Tableu[8]; 
    public static FreeCell[] free = new FreeCell[4];
    public static Home[] home = new Home[4];
    public static Dealer dealer; 
    public static Boolean isGameOver;
    
    public static LinkedList<MoveCommand> undoStack = new LinkedList<MoveCommand>();
    public static LinkedList<MoveCommand> redoStack = new LinkedList<MoveCommand>();
    
    /** 
     * Main game logic
     * @param args 
     */
    public static void main(String[] args) {
        
        buildDeck();
        initGame(); 
        dealCards(); 
        help();
        playGame();
        
    }
    
    /**
     * Spawns a new dealer, which will build a shuffled deck
     */
    public static void buildDeck(){
       dealer = new Dealer(); 
       //dealer.displayDeck();
    }
    /**
     * Creates the Freecell, Home, and Tableu decks
     */
    public static void initGame(){ 
        for (int i = 0; i <= 3; i++){
            free[i] = new FreeCell();
            home[i] = new Home(); 
        }
        for(int i = 0; i <= 7; i++){
            tabs[i] = new Tableu(); 
        }
        isGameOver = false; 
    }
    /**
     * deals cards out from the dealer deck
     */
    public static void dealCards(){
        for (int i = 0; i < 52; i++){
                tabs[i%8].addCard(dealer.removeCard());
        }    
        
    }
    
    /** 
     * Prints out all the decks and their cards
     */
    public static void displayGame(){
        for (int i = 0;i < 4; i++){
            System.out.print("FreeCell " + (i+1) + " ");
            free[i].displayDeck(); 
        }
        for(int i = 0; i< 4; i++){
            System.out.print("Home " + (i+1) + " ");
            home[i].displayDeck();
        }
        for(int i = 0; i < 8; i++){
            System.out.print("Tableu " + (i+1) + " ");
            tabs[i].displayDeck();
        }
    }
    
    /**
     * loop for playing the game, calls isGameDone after every move
     */
    public static void playGame(){
        while(!isGameOver){
           displayGame();
           move();
           isGameDone();
        }
    }
    
    /**
     * checks to see if all the home rows are finished
     * changes a global that stops the playgame loop if they are
     */
    public static void isGameDone(){
       
       for(int i = 0; i < 4; i++){
           if (!home[i].isFinished()){
               return;
           }
       }
       System.out.println("The game is over");
       isGameOver = true;
       return;
    }
    
    /**
     * Parses the players move input into elements
     * and hands them off to parse input for the logic
     */
    public static void move(){
        System.out.println("What is your move? ");
        Scanner scanner = new Scanner(System.in);
        String from = scanner.next(); 
        // look see if the string is a undo,redo,quit,etc function
        if(parseInput(from)) return; // exit if there was a command 
        String to = scanner.next();
        Deck toDeck = getDeck(to);
        Deck fromDeck = getDeck(from);
        if(toDeck == null || fromDeck == null){
            System.out.println("The input you entered was invalid:" + from + " " + to);
            help();
            return;
        }else{ 
            if(toDeck.isLegal(fromDeck.topCard())){
                undoStack.addFirst(new MoveCommand(to,from));
                redoStack.clear();
                toDeck.addCard(fromDeck.removeCard());
                
            }else{
                System.out.println("That is not a legal move");
                help(); 
            }
        }
        
        
    }
    
    /** 
     * Prints out a help message
     */
    public static void help(){
        System.out.println("Format:(Move from) (Move to) \nExample: t1 t2");
        System.out.println("Enter \"q q\" to quit\n");
        return; 
    }
    
    /**
     * parses the input string and checks if threre is a undo,redo,help, 
     * quit, or other command and calls the appropriate function
     * @param s the input string to be parsed
     * @return true if there is a undo/redo/etc command, false else
     */
    public static Boolean parseInput(String s){
        switch (s.charAt(0)){
            case 'q':
            case 'Q':
                System.out.println("Thanks for playing!");
                isGameOver = true;
                return true;
            case 'u':
            case 'U':
                undo();
                return true; 
            case 'r':
            case 'R':
                redo();
                return true;
            default:
                return false;
                
        }
    }
    
    /** 
     * parses the input elements given and returns the associated deck 
     * if there is one
     * If not, prints the help message
     * If q is entered, the program quits
     * @param s element to be parsed 
     * @return The deck associated with the input, if it exists
     */
    public static Deck getDeck(String s){ 
        switch (s.charAt(0)){
            case 'f':
            case 'F':
                try { 
                    //character being casted as an int that referrs to its ACII code
                    // subtract the offset for ascii and one for 0 index offset
                    //"embrace the duck-tape, and the duck-tape will embrace you"
                    return free[((int)s.charAt(1) - 49)];
                }catch (Exception e){
                    System.out.println("error:" + e);
                    return null;                    
                }
            case 't':
            case 'T': 
                try {
                    return tabs[((int) s.charAt(1) - 49)];
                }catch (Exception e){
                    System.out.println("error:" + e);
                    return null; 
                }
            case 'h':
            case 'H':
                try {
                    return home[( (int) s.charAt(1) - 49)];
                }catch (Exception e){
                    System.out.println("error:" + e);
                    return null;
                }
//            
            default:
                return null;                 
        }  
    }
    
    
    
    
    /**
     * undoes the user's last move, if there was one
     */
    public static void undo(){
//        check if there is a move on the undo stack
//                if so, do the move, reverse the command order and add it to the 
//                redo stack
//                        else return invalid move
        if(undoStack.size() > 0){
            MoveCommand move = undoStack.removeFirst();
            //I really hope this logic is right, this line is soooo long
            getDeck(move.getSecond()).addCard(getDeck(move.getFirst()).removeCard());
            move.reverseOrder();
            redoStack.addFirst(move);
//            toDeck.addCard(fromDeck.removeCard());          
        }else{
            System.out.println("No moves to undo");
        }
        return; 
        
    }
    
    /** 
     * re-does the users last undo, if there is on
     */
    public static void redo(){
//        check if there is a move on the redo stack
//                if there is, do it, reverse the command order and add it to 
//                        the undo stack
//                                else return invalid move and do nothing
        if (redoStack.size() > 0){
            MoveCommand move = redoStack.removeFirst();
            getDeck(move.getSecond()).addCard(getDeck(move.getFirst()).removeCard());
            move.reverseOrder();
            undoStack.addFirst(move);
            
        }else{
            System.out.println("No moves to redo");
        }
        return; 
    }
}   
        
    
    
        
   

