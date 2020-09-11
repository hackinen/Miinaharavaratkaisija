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
    
    public BotLogicTest() {
        this.board = new Board(generator, 9, 9, 1);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
