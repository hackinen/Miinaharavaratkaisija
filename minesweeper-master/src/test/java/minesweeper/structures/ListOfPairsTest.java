/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.structures;

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
public class ListOfPairsTest {
    private ListOfPairs list;
    
    public ListOfPairsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.list = new ListOfPairs();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void newListSizeIsZero() {
        assertEquals(0, this.list.size());
    }
    
    @Test
    public void methodIncreaseSizeOfListDoublesTheAvailableSpotsOnTheList() {
        assertEquals(1, list.absoluteSize());
        this.list.increaseSizeOfList();
        assertEquals(2, list.absoluteSize());
    }
    
    
}
