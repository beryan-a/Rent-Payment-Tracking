/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author integ
 */
public class Tenant {

   
    private String name;
    private int aptNo;
    private double rent;
    
    
    
    //constructor
    public Tenant(String name, int aptNo, double rent) {
        this.name = name;
        this.aptNo = aptNo;
        this.rent = rent;
    }
    
    //getters 
    public String getName(){
        return name;
    }
    public int getAptNo(){
        return aptNo;
    }
    public double getRent(){
        return rent;
    }
    
    //setters
     public void setName(String name) {
        this.name = name;
    }

    public void setAptNo(int aptNo) {
        this.aptNo = aptNo;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }
    
    
    
    
    
}
