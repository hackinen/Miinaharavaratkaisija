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
