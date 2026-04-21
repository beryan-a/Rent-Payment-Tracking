/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author integ
 */
public class Payment {
    protected  int aptNo;
    protected double amount;
    protected int month, year;
    
    //constructor
    public Payment(int aptNo, double amount, int month, int year) {
        this.aptNo = aptNo;
        this.amount = amount;
        this.month=month;
        this.year=year;
    }
    
    //getters
    public int getAptNo() {
        return aptNo;
    }

    public double getAmount() {
        return amount;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    
    public double calculateAmount(){
        return amount;
    }
}
