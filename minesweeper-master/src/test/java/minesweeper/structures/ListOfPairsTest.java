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

import minesweeper.model.*;

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
    public void newListIsEmpty() {
        assertTrue(list.isEmpty());
    }
    
    @Test
    public void getReturnsThePairInGivenIndex() {
        Pair pair = new Pair(0, 0);
        list.add(pair);
        assertEquals(pair, list.get(0));
    }
    
    @Test
    public void methodIncreaseSizeOfListDoublesTheAvailableSpotsOnTheList() {
        assertEquals(1, list.absoluteSize());
        this.list.increaseSizeOfList();
        assertEquals(2, list.absoluteSize());
    }
    
    @Test
    public void addingANewPairIncreasesSize() {
        this.list.add(new Pair(0, 0));
        assertEquals(1, list.size());
    }
    
    @Test
    public void addingANewPairOnAnEmptyListMakesListNotEmpty() {
        this.list.add(new Pair(0, 0));
        assertEquals(false, list.isEmpty());
    }
    
    @Test
    public void addingNewPairWhenNoMoreRoomIncreasesTheSizeOfTheList() {
        this.list.add(new Pair(0, 0));
        this.list.add(new Pair(0, 1));
        
        assertEquals(2, list.absoluteSize());
    }
    
    @Test
    public void removeReturnsNullIfNoPairInGivenIndex() {
        assertEquals(null, list.remove(2));
    }
    
    @Test
    public void removeReturnsThePairInGivenIndex() {
        Pair pair = new Pair(0, 0);
        list.add(pair);
        
        assertEquals(pair, list.remove(0));
    }
    
    @Test
    public void removeRemovesThePairInGivenIndex() {
        Pair pair = new Pair(0, 0);
        list.add(pair);
        list.remove(0);
        
        assertEquals(null, list.get(0));
    }
    
    @Test
    public void removeMovesPairsAroundTheRemovedPairNextToEachother() {
        Pair pair1 = new Pair(0, 0);
        list.add(pair1);
        Pair pair2 = new Pair(0, 1);
        list.add(pair2);
        Pair pair3 = new Pair(0, 0);
        list.add(pair3);
        
        list.remove(1);
        
        assertEquals(pair1, list.get(0));
        assertEquals(pair3, list.get(1));
    }
    
    @Test
    public void removeReducesTheSizeOfTheList() {
        Pair pair1 = new Pair(0, 0);
        list.add(pair1);
        Pair pair2 = new Pair(0, 1);
        list.add(pair2);
        Pair pair3 = new Pair(0, 0);
        list.add(pair3);
        
        list.remove(1);
        
        assertEquals(2, list.size());
    }
}
