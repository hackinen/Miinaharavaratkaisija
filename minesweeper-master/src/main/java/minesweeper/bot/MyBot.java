
package minesweeper.bot;

import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import minesweeper.model.*;
import minesweeper.structures.*;

/**
 * MyBot class contains the functionality of the bot
 * This class is done by me
 * @author hiira
 */
public class MyBot implements Bot {

    private Random rng = new Random();
    private GameStats gameStats;
    private BotLogic bl;
    private Move simulatedMove; 
    private Pair<Integer> firstCell;

    /**
     * Makes a single decision based on the given Board state
     * @param board The current board state
     * @return Move to be made onto the board
     */
    @Override
    public Move makeMove(Board board) {
        
        //The first move
        if (board.firstMove) {
            return new Move(MoveType.OPEN, board.width/2, board.height/2);
        }
        
        this.bl = new BotLogic(board);
        
        for (int i = 0; i < board.width; i++) {
            for (int j = 0; j < board.height; j++) {
                //Find an unopened square (i,j)
                if (!board.getSquareAt(i, j).isOpened()) {
                    
                    //Find out if there is an opened square (x,y) in the surrounding squares 
                    Square[][] squares = bl.getSurroundingSquares(i, j);
                    
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            
                            if (squares[x][y] == null || (x == 1 && y == 1)) {
                                continue;
                            }
                            
                            //Find out if we can deduce something about this opened square
                            if (squares[x][y].isOpened()) {
                                
                                // (number_X,number_Y) is the opened squares's location on the board
                                int number_X = i + x - 1;
                                int number_Y = j + y - 1;
                                
                                //the number on the opened square
                                int number = squares[x][y].surroundingMines();
                                
                                //the surrounding squares around square (number_X,number_Y)
                                Square[][] squares2 = bl.getSurroundingSquares(number_X, number_Y);
                                
                                
                                //Check if surrounding flags match the number on the square
                                if (number > 0) {
                                    int flags = bl.countFlaggedSurroundingSquares(squares2);
                                    
                                    if (flags == number) {
                                        //If flags matched the number on the square, we can open all the surrounding unopened squares
                                        for (int n = 0; n < 3; n++) {
                                            for (int k = 0; k < 3; k++) {
                                                if (squares2[n][k] == null) {
                                                    continue;
                                                }
                                                if (!squares2[n][k].isOpened() && !squares2[n][k].isFlagged()) {
                                                    return new Move(MoveType.OPEN, number_X + n - 1, number_Y + k - 1);
                                                }
                                            }
                                        }
                                    }
                                }
                                
                                //Check if surrounding unopened squares match the number on the square
                                if (number > 0) {
                                    int unopenedSquares = bl.countUnopenedSurroundingSquares(squares2);
                                  
                                    if (unopenedSquares == number) {
                                        
                                        //If unopened squares matched the number on the square, we can flag them all
                                        for (int n = 0; n < 3; n++) {
                                            for (int k = 0; k < 3; k++) {
                                                if (squares2[n][k] == null) {
                                                    continue;
                                                }
                                                if (!squares2[n][k].isOpened() && !squares2[n][k].isFlagged()) {
                                                    return new Move(MoveType.FLAG, number_X + n - 1, number_Y + k - 1);
                                                }
                                            }
                                        }
                                    }
                                }
                                
                                
                            }
                        }
                    }
                }
            }
        
        }
        
        //Try to deduce if can place a flag or not
        
        //A copy of the gameboard:
        //  0-8 - opened, number of surrounding mines
        //  9 - flagged
        //  10- unopened
        int[][] grid = bl.getCopyOfBoard(board);
        
        //System.out.println("simuloidaan");
        
        //backtrack a possible move
        return findPossibleMove(grid);
       

        
    }
    
    /**
     * A method for going through all of the border cells for finding out if one
     * of them can be opened/flagged with certainty - uses the recusive method
     * simulateMove
     * @param grid the current state of the board in a grid-structure
     * @return Move
     */
    public Move findPossibleMove(int[][] grid) {
        //get a list of unopened cells that have at least one opened cell as its
        //neighbour
        ListOfPairs borderCells = bl.getListOfBorderCells(grid);
        
        for (int i = 0; i<borderCells.size(); i++) {
//            System.out.println("");
//            System.out.println(i+1 + ". yritys");
            
            firstCell = borderCells.get(0);
            
            if (simulateMove(grid, (ListOfPairs) borderCells.clone())) {
                break;
            } else {
                borderCells.add(borderCells.remove(0));
            }
        }
        
        
        return simulatedMove;
    }
    
    /**
     * Backtracking algorithm for finding out if it is possible to be certain to
     * flag/open a cell
     * @param grid the current state of the board in a grid-structure
     * @param borderCells list of the interesting cells
     * @return true if can be certain, false if not
     */
    public boolean simulateMove(int[][] grid, ListOfPairs borderCells) {
        if (borderCells.isEmpty()) {
            return true;
        }
        Pair<Integer> coordinates = borderCells.remove(0);
        int x = coordinates.first;
        int y = coordinates.second;
        
        // 1. Check if we can flag the cell in given coordinates
        grid[x][y] = 9;
        boolean isFlagLegal = true;
        
        //get neighbours of the cell
        int[][] neighbours = bl.getSurroundingCells(grid, x, y);
        
        //check if the flag was illegal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //neighbour is a numbered cell
                if (neighbours[i][j] > 0 && neighbours[i][j] <= 8) {
                    int[][] neighboursNeighbours = bl.getSurroundingCells(grid, x + i - 1, y + j - 1);
                    
                    //check if there are too many flags
                    if (bl.countFlagsSurroundingCell(neighboursNeighbours) > neighbours[i][j]) {
                        isFlagLegal = false;
                    }
                }
                
            }
        }
        
        if (isFlagLegal) {
            isFlagLegal = simulateMove(grid, borderCells);        
        }
        
        
        // 2. Check if we can open the cell in given coordinates
        grid[x][y] = 11;    // number 11 represents "opening" the cell
        boolean isEmptyLegal = true;
        
        //get neighbours of the cell
        neighbours = bl.getSurroundingCells(grid, x, y);
        
        //check if the opening of the cell was illegal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //neighbour is a numbered cell
                if (neighbours[i][j] > 0 && neighbours[i][j] <= 8) {
                    int[][] neighboursNeighbours = bl.getSurroundingCells(grid, x + i - 1, y + j - 1);
                    
                    //check if there are too little flags or unopened cells
                    int flags = bl.countFlagsSurroundingCell(neighboursNeighbours);
                    int unopenedCells = bl.countUnopenedCellsSurroundingCell(neighboursNeighbours);
                    int flagsNeeded = neighbours[i][j] - flags;
                    
                    if (flagsNeeded > unopenedCells) {
                        isEmptyLegal = false;
                    } 
                }
                
            }
        }
        
        if (isEmptyLegal) {
            isEmptyLegal = simulateMove(grid, borderCells);
        }
        
        //Return original values
        borderCells.add(coordinates);
        grid[x][y] = 10;
        
        if (isFlagLegal && !isEmptyLegal) {
            //System.out.println("ruutu "+x+","+y+" liputettiin");
            simulatedMove = new Move(MoveType.FLAG, x, y);
            return true;
        } else if (!isFlagLegal && isEmptyLegal) {
            //System.out.println("ruutu "+x+","+y+" avattiin");
            simulatedMove = new Move(MoveType.OPEN, x, y);
            return true;
        } else if (isFlagLegal && isEmptyLegal) {
            //if both moves could be correct, guess and open the cell
            //System.out.println("ruutu "+x+","+y+" arvattiin ja avattiin");
            simulatedMove = new Move(MoveType.OPEN, x, y);
            return !firstCell.equals(coordinates);
        } else {
            //System.out.println("mentiin elseen");
            return false;
        }
        
    }
    
    /**
     * Returns a possible move depending on the current board state.
     * Used for a "helper" bot to provide a highlight.
     * @param board The current board state.
     * @return List of moves for current board (List contains only one move).
     */
    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> movesToMake = new ArrayList<>();
        
        Move move = this.makeMove(board);
        
        if (move.type == MoveType.OPEN) {
            move.type = MoveType.HIGHLIGHT;
            move.highlight = Highlight.GREEN;
        }
        
        if (move.type == MoveType.FLAG) {
            move.type = MoveType.HIGHLIGHT;
            move.highlight = Highlight.RED;
        }
        
        movesToMake.add(move);
        
        return movesToMake;
    }

    /**
     * Used to pass the bot the gameStats object, useful for tracking previous moves
     */
    @Override
    public void setGameStats(GameStats gameStats) {
        this.gameStats = gameStats;
    }
    
    
    
    
}

