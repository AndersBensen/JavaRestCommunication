/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.ArrayList;

/**
 *
 * @author ander
 */
public class Data {
    private ArrayList<Integer> myList; 
    
    public Data() {
        myList = new ArrayList<>(); 
        for (int i = 0; i < 10; i++) {
            myList.add((int) (100 * Math.random()+ 1)); 
        }
    }
    
    public ArrayList<Integer> getData() {
        return myList; 
    }
    
    public void addToList(Integer x) {
        myList.add(x);
    }
}
