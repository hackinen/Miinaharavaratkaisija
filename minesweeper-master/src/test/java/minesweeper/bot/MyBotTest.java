/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.bot;

import java.util.ArrayList;
import minesweeper.generator.MinefieldGenerator;
import minesweeper.model.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author hiira
 */
public class MyBotTest {
    private Bot bot;
    private MinefieldGenerator generator;
    private Board board;
    
    @Before
    public void setUp() {
        this.bot = BotSelect.getBot();
        this.generator = new MinefieldGenerator();
        this.board = new Board(generator, 10, 10, 1);
    }
    
    public MyBotTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testIfBotSimulatesCorrectMove() {
    }
    
    @Test
    public void testIfBotFlagsRightNumberOfSurroundingSquares() {
        this.board.makeMove(bot.makeMove(board));
        this.board.makeMove(bot.makeMove(board));
        
        int flagged = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board.getSquareAt(i, j).isFlagged()) {
                    flagged++;
                }
            }
        }
        
        assertEquals(1,flagged);
    }
    
    @Test
    public void checkIfAlgorithmWorks() {
        Board b = new Board(generator,4,3,0);
        b.firstMove = false;
        
        Square square = new Square(3, 0);
        Square square2 = new Square(0,2);
        square.setMine();
        square2.setMine();
        
        b.addSquare(square, 3, 0);
        b.addSquare(square2, 0, 2);
        b.incrementAdjacentSquares(3, 0);
        b.incrementAdjacentSquares(0, 2);
        
        b.makeMove(new Move(MoveType.OPEN, 0, 0));
        
        Move correctMove = new Move(MoveType.FLAG, 0, 2);
        
        assertEquals(correctMove, bot.makeMove(b));
    }
    
    @Test
    public void checkIfAlgorithmWorks2() {
        Board b = new Board(generator,4,4,0);
        b.firstMove = false;
        
        Square square = new Square(3, 0);
        Square square2 = new Square(1,3);
        square.setMine();
        square2.setMine();
        
        b.addSquare(square, 3, 0);
        b.addSquare(square2, 1, 3);
        b.incrementAdjacentSquares(3, 0);
        b.incrementAdjacentSquares(1, 3);
        
        b.makeMove(new Move(MoveType.OPEN, 0, 0));
        
        Move correctMove = new Move(MoveType.OPEN, 2, 3);
        assertEquals(correctMove, bot.makeMove(b));
    }
    
    
    @Test
    public void testIfBotFlagsSurroundingSquares() {
        Board b2 = new Board(generator,10,10,0);
        b2.firstMove = false;
        
        Square s1 = new Square(0, 1);
        s1.setMine();
        b2.addSquare(s1, 0, 1);
        b2.incrementAdjacentSquares(0, 1);
        
        Square s2 = new Square(1, 1);
        s2.setMine();
        b2.addSquare(s2, 1, 1);
        b2.incrementAdjacentSquares(1, 1);
        
        Square s3 = new Square(1, 0);
        s3.setMine();
        b2.addSquare(s3, 1, 0);
        b2.incrementAdjacentSquares(1, 0);
      
        b2.makeMove(new Move(MoveType.OPEN,0,0));
        
        b2.makeMove(bot.makeMove(b2));
        b2.makeMove(bot.makeMove(b2));
        b2.makeMove(bot.makeMove(b2));
        
        assertEquals(true, b2.getSquareAt(0, 1).isFlagged());
        assertEquals(true, b2.getSquareAt(1, 0).isFlagged());
        assertEquals(true, b2.getSquareAt(1,1).isFlagged());
    }
    
    
    @Test
    public void testIfBotSuggestsTheRightMove() {
        ArrayList<Move> suggestedMove = new ArrayList<>();
        Board b1 = new Board(generator,3,3,0);
        b1.firstMove = false;
        
        //set mine at (0,1)
        Square s1 = new Square(0, 1);
        s1.setMine();
        b1.addSquare(s1, 0, 1);
        b1.incrementAdjacentSquares(0, 1);
        
        //open these squares:
        b1.makeMove(new Move(MoveType.OPEN, 0, 0));
        b1.makeMove(new Move(MoveType.OPEN, 1, 0));
        b1.makeMove(new Move(MoveType.OPEN, 1, 1));
        
        //get the suggested move, should be flag (highlight red) square in (0,1)
        suggestedMove = bot.getPossibleMoves(b1);
        Move correctMove = new Move(MoveType.HIGHLIGHT, 0, 1);
        assertEquals(correctMove, suggestedMove.get(0));
    }
    
    @Test
    public void myBotCanMakeValidMoves() {
        Move move = this.bot.makeMove(this.board);
        assertTrue(move.x >= 0 && move.x < 10);
        assertTrue(move.y >= 0 && move.y < 10);
    }
}
