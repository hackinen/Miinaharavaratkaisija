/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.bot;

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
    public void seeWhatBotDoes() {
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
        
        b.makeMove(bot.makeMove(b));
    }
    
    /*
    @Test
    public void testIfBotFlagsSurroundingSquares() {
        Board b2 = new Board(generator,10,10,0);
        b2.getSquareAt(0, 1).setMine();
        b2.getSquareAt(1, 0).setMine();
        b2.getSquareAt(1, 1).setMine();
        b2.makeMove(new Move(MoveType.OPEN,0,0));
        
        b2.makeMove(bot.makeMove(b2));
        b2.makeMove(bot.makeMove(b2));
        b2.makeMove(bot.makeMove(b2));
        
        assertEquals(true, b2.getSquareAt(0, 1).isFlagged());
        assertEquals(true, b2.getSquareAt(1, 0).isFlagged());
        assertEquals(true, b2.getSquareAt(1,1).isFlagged());
    }
    */
    /*
    @Test
    public void testIfBotOpensSurroundingSquaresIfRightNumberOfFlags() {
        Board b2 = new Board(generator,10,10,0);
        b2.firstMove = false;
        
        Square square = new Square(0, 1);
        square.setMine();

        b2.addSquare(square, 0, 1);
        b2.incrementAdjacentSquares(0, 1);
        b2.makeMove(new Move(MoveType.FLAG,0,1));
        b2.makeMove(new Move(MoveType.OPEN,0,0));
        
        b2.makeMove(bot.makeMove(b2));
        
        assertEquals(true, b2.getSquareAt(1, 0).isOpened());
        assertEquals(true, b2.getSquareAt(1,1).isOpened());
    }
    */
    @Test
    public void myBotCanMakeValidMoves() {
        Move move = this.bot.makeMove(this.board);
        assertTrue(move.x >= 0 && move.x < 10);
        assertTrue(move.y >= 0 && move.y < 10);
    }
}
