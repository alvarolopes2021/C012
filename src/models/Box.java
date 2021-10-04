/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author alvar
 */
public class Box {
    
    public static int counter = 0;
    private int numBox = 0;
    private String number = "-1";
    
    public Box(){
        counter++;
        this.numBox = counter;
        this.number = String.valueOf(counter);
    }

    public int getNumBox() {
        return numBox;
    }

    public String getNumber() {
        return number;
    }    
    
}
