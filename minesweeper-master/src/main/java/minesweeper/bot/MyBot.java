
package minesweeper.bot;

import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
import minesweeper.model.Board;
import minesweeper.model.GameStats;
import minesweeper.model.Move;
import minesweeper.model.MoveType;
import minesweeper.model.Highlight;
import minesweeper.model.Pair;
import minesweeper.model.Square;

/**
 * MyBot class contains the functionality of the bot
 * This class is partially done by me: by now I have started the makeMove-method,
 * but have not made changes to the other methods
 * @author hiira
 */
public class MyBot implements Bot {

    private Random rng = new Random();
    private GameStats gameStats;
    private BotLogic bl;

    /**
     * Make a single decision based on the given Board state
     * @param board The current board state
     * @return Move to be made onto the board
     */
    @Override
    public Move makeMove(Board board) {
        
        this.bl = new BotLogic(board);
        
        for (int i = 0; i < board.width; i++) {
            for (int j = 0; j < board.height; j++) {
                System.out.println("Taulukon indeksit ennen valintaa: ("+i+","+j+").");
                //Find an unopened square
                if (!board.getSquareAt(i, j).isOpened()) {
                    
                    //Find out if there is an opened square in the surrounding squares
                    Square[][] squares = bl.getSurroundingSquares(i, j);
                    System.out.println("Avaamattoman ruudun indeksit: ("+i+","+j+").");
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            
                            if (squares[x][y] == null || (x == 1 && y == 1)) {
                                continue;
                            }
                            
                            //Find out if we can deduce something about this opened square
                            if (squares[x][y].isOpened()) {
                                int number_X = i + x - 1;
                                int number_Y = j + y - 1;
                                
                                System.out.println("Avatun ruudun indeksit: ("+number_X+","+number_Y+").");
                                int number = squares[x][y].surroundingMines();
                                Square[][] squares2 = bl.getSurroundingSquares(number_X, number_Y);
                                
                                //Check if surrounding flags match the number on the square
                                if (number > 0) {
                                    int flags = bl.countFlaggedSurroundingSquares(squares2);
                                    System.out.println("Number: "+number);
                                    System.out.println("Flags: "+flags);
                                    if (flags == number) {
                                        System.out.println("LÖYTYI OIKEA MÄÄRÄ LIPPUJA!");
                                        //If flags matched the number on the square, we can open all the surrounding unopened squares
                                        for (int n = 0; n < 3; n++) {
                                            for (int k = 0; k < 3; k++) {
                                                if (squares2[n][k] == null) {
                                                    continue;
                                                }
                                                if (!squares2[n][k].isOpened() && !squares2[n][k].isFlagged()) {
                                                    return new Move (MoveType.OPEN,number_X+n-1,number_Y+k-1);
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
                                                    return new Move(MoveType.FLAG,number_X+n-1,number_Y+k-1);
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
        
        return new Move(MoveType.OPEN,0,0);

        
    }
    
    /**
     * Return multiple possible moves to make based on current board state.
     * Suggested to be used for a "helper" bot to provide multiple highlights at once.
     * @param board The current board state.
     * @return List of moves for current board.
     */
    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> movesToMake = new ArrayList<>();
        HashSet<Pair<Integer>> pairs = new HashSet();

        //Chooses a random amount of moves to make between 1 and total number of mines
        int movesToReturn = rng.nextInt(board.totalMines) + 1;

        for (int i = 0; i < movesToReturn; i++) {
            Boolean found = false;
            Pair<Integer> pair = new Pair(-1, -1);
            //Attempts to find a unique unopened square up to 5 times or until it is successfully found
            for (int attempt = 0; attempt < 6 && !found; attempt++) {
                pair = findUnopenedSquare(board);
                if (!pairs.contains(pair)) {
                    pairs.add(pair);
                    found = true;
                } 
            }
           
            if (found) {
                if (i < Math.floor(movesToReturn / 2)) {
                    movesToMake.add(new Move(pair.first, pair.second, Highlight.GREEN));
                } else {
                    movesToMake.add(new Move(pair.first, pair.second, Highlight.RED));
                }
            } else {
                //if a square is not found, skips the rest of the for loop
                i = movesToReturn;
            }
        }
        return movesToMake;
    }

    /**
     * Used to pass the bot the gameStats object, useful for tracking previous moves
     */
    @Override
    public void setGameStats(GameStats gameStats) {
        this.gameStats = gameStats;
    }
    
    
    
    /**
     * Find the (X, Y) coordinate pair of an unopened square
     * from the current board
     * @param board The current board state
     * @return An (X, Y) coordinate pair
     */
    public Pair<Integer> findUnopenedSquare(Board board) {
        Boolean unOpenedSquare = false;

        // board.getOpenSquares allows access to already opened squares
        HashSet<Square> opened = board.getOpenSquares();
        int x;
        int y;

        Pair<Integer> pair = new Pair<>(0, 0);

        // Randomly generate X,Y coordinate pairs that are not opened
        while (!unOpenedSquare) {
            x = rng.nextInt(board.width);
            y = rng.nextInt(board.height);
            if (!opened.contains(board.board[x][y])) {
                unOpenedSquare = true;
                pair = new Pair<Integer>(x, y);
            }
        }

        // This pair should point to an unopened square now
        return pair;
    } 
   
    
   
    
}

