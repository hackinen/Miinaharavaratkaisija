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
    private int size;       // absolute size of the list: empty cells too
    private int length;     // only cells that have a value
    
    
    public ListOfPairs() {
        this.size = 1;
        this.length = 0;
        this.list = new Pair[size];
    }
    
    
    /**
     * Doubles the size of the list
     */
    public void increaseSizeOfList() {
        Pair[] newList = new Pair[this.size * 2];
        
        for (int i = 0; i < this.length; i++) {
            newList[i] = this.list[i];
        }
        this.list = newList;
        this.size = this.size * 2;
    }
    
    
    /**
     * Checks if the given list is empty or not
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Returns the size of the list (the number of Pairs) NOTE: The name of this
     * method may seem confusing, but I wanted to use the same method name as
     * ArayList has
     * @return size
     */
    public int size() {
        return this.length;
    }
    
    
    /**
     * Adds a new pair to the end of the list
     * @param pair 
     */
    public void add(Pair pair) {
        
        if (this.length == this.size) {
            increaseSizeOfList();
        }
        
        this.list[this.length] = pair;
        this.length++;
    }
    
    
    /**
     * returns and removes the value in list[i]
     * @param i index
     * @return Pair in index i
     */
    public Pair remove(int i) {
        
        if (i >= this.length) {
            return null;
        }
        
        Pair pair = this.list[i];
        this.list[i] = null;
        Pair[] newList = new Pair[this.size];
        int offset = 0;
        
        for (int x = 0; x < this.length; x++) {
            if (x == i) {
                offset++;
                continue;
            }
            
            newList[x-offset] = this.list[x];
        }
        
        this.list = newList;
        this.length--;
        
        return pair;
    }
    
    public ListOfPairs clone() {
        ListOfPairs cloneList = new ListOfPairs();
        
        for (int i = 0; i < this.length; i++) {
            cloneList.add(this.list[i]);
        }
        
        return cloneList;
    }
    
    
    /**
     * returns the value in list[i]
     * @param i index
     * @return Pair in index i
     */
    public Pair get(int i) {
        return this.list[i];
    }
    
    /**
     * Method for checking the absolute size of the list, mainly for testing
     * purposes
     * @return size
     */
    public int absoluteSize() {
        return this.size;
    }
}
