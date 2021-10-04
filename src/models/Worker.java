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
public class Worker {
    private String name;
    private boolean full;
    private boolean isLoading;
    private boolean isUnloading;
    
    public Worker(String name, boolean full, boolean isLoading, boolean isUnloading){
        this.full = full;
        this.name = name;
        this.isLoading = isLoading;
        this.isUnloading = isUnloading;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    public boolean isIsUnloading() {
        return isUnloading;
    }

    public void setIsUnloading(boolean isUnloading) {
        this.isUnloading = isUnloading;
    }
    
    
    
}
