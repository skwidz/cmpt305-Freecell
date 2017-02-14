/*
 * The MIT License
 *
 * Copyright 2017 Christian.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package freecell;

/**
 *  Class for holding commands 
 * @author Christian
 */
public class MoveCommand {
    
    
    
    private String firstElement;
    private String secondElement;
    
    /**
     * constructor for the MoveCommand class
     */
    protected MoveCommand (String first, String second){
        firstElement = first;
        secondElement = second;
    }
    
    /**
     * reverse the order of the commands
     */
    public void reverseOrder(){
        String temp = firstElement;
        this.firstElement = secondElement;
        this.secondElement = temp;
    }
    
    /**
     * gets the first element of the command
     * @return String first element
     */
    public String getFirst(){
        return firstElement;
    }
    
    /**
     * gets the second element of the command
     * @return String second element
     */
    public String getSecond(){
        return secondElement;
    }
}
