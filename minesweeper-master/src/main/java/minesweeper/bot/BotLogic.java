/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.bot;

import minesweeper.model.*;

/**
 * This class is completely done by me
 * @author hiira
 */
public class BotLogic {
    public Board board;
    /**
     * Constructor for this class
     */
    public BotLogic(Board board) {
        this.board = board;
    }
    
    
    
    public Square[][] getBorderSquare() {
        Square[][] squares = new Square[2][2];
        
        for (int i = 0; i < board.width; i++) {
            for (int j = 0; j < board.height; j++) {
                squares = this.getSurroundingSquares(i, j);
                
                if (this.isABorderSquare(squares)) {
                    return squares;
                }
            }
        }
        
        return null;
    } 
        
    
    /**
     * A method for finding the surrounding squares of (x,y)
     * @param x
     * @param y
     * @param board
     * @return Square[][], a grid of the surrounding squares, (x,y) in the middle
     */
    public Square[][] getSurroundingSquares(int x, int y) {
        Square[][] squares = new Square[3][3];
        
        if (x < 0 || y < 0 || x >= board.width || y >= board.height) {
            return null;
        }
        
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i < 0 || j < 0 || i >= board.width || j >= board.height) {
                    squares[i-x+1][j-y+1] = null;
                    continue;
                }
                squares[i-x+1][j-y+1] = board.getSquareAt(i, j);
            }
        }
        
        return squares;
        
    }
    
    /**
     * Method for identifying the "border squares" - unopened square that
     * has opened squares surrounding them
     * @param squares
     * @return true - if square is a bordersquare
     *          false - if not
     */
    public boolean isABorderSquare(Square[][] squares) {
       
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (squares[i][j] == null) {
                    continue;
                }
                if (i != 1 && j != 1 && !squares[i][j].isOpened()) {
                    return true;
                }
            }
                
        }
        
        return false;
       
    }
    
    
    /**
     * A method for counting the unopened squares around this square
     * 
     * @param squares a grid of squares
     * @return the number of unopened squares surrounding this square
     */
    public int countUnopenedSurroundingSquares(Square[][] squares) {
        int unopened = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (squares[i][j] == null || (i == 1 && j == 1)) {
                    continue;
                }
                if (!squares[i][j].isOpened()) {
                    unopened++;
                }
                
            }
        }
        
        return unopened;
    }
    
    /**
     * A method for counting the flagged squares around this square
     * @param squares a qrid of the surrounding squares
     * @return the number of flagged squares around this square
     */
    public int countFlaggedSurroundingSquares(Square[][] squares) {
        int flagged = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (squares[i][j] == null || (i == 1 && j == 1)) {
                    continue;
                }
                if (squares[i][j].isFlagged()) {
                    flagged++;
                }
                
            }
        }
        
        return flagged;
    }
}
