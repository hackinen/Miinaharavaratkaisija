/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.bot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

import minesweeper.bot.*;
import minesweeper.generator.MinefieldGenerator;
import minesweeper.model.*;
import org.junit.Assert;
/**
 * This test class is completely written by me
 * @author hiira
 */
public class BotLogicTest {
    private Board board;
    private MinefieldGenerator generator;
    private BotLogic bl;
    
    
    @Before
    public void setUp() {
        this.board = new Board(generator, 9, 9, 1);
        this.bl = new BotLogic(this.board);
    }
    public BotLogicTest() {
        
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
    public void getCopyOfBoardAddsFlagsAndNumbersCorrectly() {
        this.board = new Board(generator, 2, 2, 0);
        this.board.firstMove = false;
        
        Square square = new Square(0, 0);
        square.setMine();

        board.addSquare(square, 0, 0);
        board.incrementAdjacentSquares(0, 0);
        board.makeMove(new Move(MoveType.FLAG,0,0));
        board.makeMove(new Move(MoveType.OPEN,0,1));
        int[][] grid = {{9,1},{10,10}};
        
        Assert.assertArrayEquals(grid,bl.getCopyOfBoard(this.board));
    }
    
    
    @Test
    public void getCopyOfBoardAddsZerosCorreclty() {
        this.board = new Board(generator, 3, 3, 0);
        this.board.firstMove = false;
        
        Square square = new Square(0, 0);
        square.setMine();

        board.addSquare(square, 0, 0);
        board.incrementAdjacentSquares(0, 0);
        board.makeMove(new Move(MoveType.OPEN,2,2));
        int[][] grid = {{10,1,0},{1,1,0},{0,0,0}};
        
        Assert.assertArrayEquals(grid,bl.getCopyOfBoard(this.board));
    }
    
    @Test
    public void getSurroundingCellsWorks() {
        this.board = new Board(generator, 3, 3, 0);
        this.board.firstMove = false;
        
        Square square = new Square(0, 2);
        square.setMine();
        board.addSquare(square, 0, 2);
        board.incrementAdjacentSquares(0, 2);
        board.makeMove(new Move(MoveType.OPEN,0,1));
        
        int[][] bigGrid = bl.getCopyOfBoard(board);
        int[][] grid = {{-1,-1,-1},{-1,10,1},{-1,10,10}};
        
        Assert.assertArrayEquals(grid, bl.getSurroundingCells(bigGrid, 0, 0));
    }

//    @Test
//    public void getSurroundingSquaresMethodReturnsTheRightSquares() {
//        Square[][] originalSquares = new Square[3][3];
//      
//        //add top left corner squares
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                originalSquares[i][j] = board.getSquareAt(i, j);
//            }
//        }
//        
//        Square[][] methodSquares = bl.getSurroundingSquares(1, 1);
//        
//        AssertEquals(methodSquares,originalSquares);
//    }
}
