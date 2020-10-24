/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.bot;

import minesweeper.model.*;
import minesweeper.structures.ListOfPairs;

/**
 * This class is completely done by me and contains helping methods for the MyBot
 * class
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
    
    /**
     * A method for finding the surrounding squares of (x,y)
     * @param x x-coordinate
     * @param y y-coordinate
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
                    squares[i - x + 1][j - y + 1] = null;
                    continue;
                }
                squares[i - x + 1][j - y + 1] = board.getSquareAt(i, j);
            }
        }
        
        return squares;
        
    }
    
    /**
     * A method for counting the unopened squares around this square
     * 
     * @param squares a 3x3 grid of squares
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
    
    
    /**
     * A method for copying the current state of the game into a simple int[][] grid:
     * numbers 0-8 equal the openeded squares' numbers, number 9 equals a flag
     * and number 10 equals a square that has not yet been opened or flagged
     * @param board - the gameboard at its current state
     * @return grid - int[][]
     */
    public int[][] getCopyOfBoard(Board board) {
        int[][] grid = new int[board.width][board.height];
        
        for (int i = 0; i < board.width; i++) {
            for (int j = 0; j < board.height; j++) {
                
                Square square = board.getSquareAt(i, j);
                
                if (square.isOpened()) {
                    grid[i][j] = square.surroundingMines();
                } else if (square.isFlagged()) {
                    grid[i][j] = 9;
                } else {
                    grid[i][j] = 10;
                }
                
            }
        }
        
        return grid;
    }
    
    /**
     * A method for getting a list of those unopened cells that have at least one 
     * opened cell as its neighbour
     * @param grid - int[][]-grid that has the gameboard's current state copied in it
     * @return list of Pairs (x,y-coordinates of the border cells)
     */
    public ListOfPairs getListOfBorderCells(int[][] grid) {
        
        //This ArrayList will be changed to a self-made data structure
        ListOfPairs borderCells = new ListOfPairs();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                boolean isABorderCell = false;
                
                //find an unopened cell
                if (grid[i][j] == 10) {
                    //Get that cell's neighbours
                    int[][] surroundingCells = getSurroundingCells(grid, i, j);
                    
                    //Find out if there are opened cells in the neighbouring cells
                    for (int ii = 0; ii < 3; ii++) {
                        for (int jj = 0; jj < 3; jj++) {
                            
                            if (surroundingCells[ii][jj] > -1 && surroundingCells[ii][jj] < 9) {
                                isABorderCell = true;
                            }
                        }
                    }
                    
                    if (isABorderCell) {
                        borderCells.add(new Pair(i, j));
                    }
                }
            }
        }
        
        return borderCells;
    }
    
    /**
     * Returns the values in the cells surrounding (x,y)
     * @param grid - int[][] grid that has been copied from the current board
     * @param x - x-coordinate of the cell
     * @param y - y-coordinate of the cell
     * @return int[][] surroundingCells - 3x3-grid, (x,y) in (1,1)
     */
    public int[][] getSurroundingCells(int[][] grid, int x, int y) {
        if (grid == null || x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return null;
        }
        
        int[][] surroundingCells = new int[3][3];
        
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                
                if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                    surroundingCells[i - x + 1][j - y + 1] = -1;
                    continue;
                }
                
                surroundingCells[i - x + 1][j - y + 1] = grid[i][j];
            }
        }
        
        return surroundingCells;
    }
    
    /**
     * Method for counting how many flags surround this cell
     * @param cells - 3x3 int[][]-grid
     * @return int - number of flags
     */
    public int countFlagsSurroundingCell(int[][] cells) {
        int flags = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                if (i == 1 && j == 1) {
                    continue;
                }
                if (cells[i][j] == 9) {
                    flags++;
                }
            }
        }
        
        return flags;
    }
    
    /**
     * Method for counting how many unopened cells surround this cell
     * @param cells - 3x3 int[][]-grid
     * @return int - number of unopened cells
     */
    public int countUnopenedCellsSurroundingCell(int[][] cells) {
        int unopened = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (cells[i][j] == 10) {
                    unopened++;
                }
            }
        }
        
        return unopened;
    }
    

}
