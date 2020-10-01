/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.structures;

import minesweeper.model.*;

/**
 * A datastructure to replace ArrayList
 * @author hiira
 */
public class ListOfPairs {
    private Pair[] list;
    private int size;
    
    public ListOfPairs(int size) {
        this.size = size;
        this.list = new Pair[size];
    }
    
    /**
     * Doubles the size of the list
     */
    public void increaseSizeOfList() {
        
    }
}
