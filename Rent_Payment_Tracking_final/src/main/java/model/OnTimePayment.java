/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author integ
 */
public class OnTimePayment extends Payment{

    public OnTimePayment(int aptNo, double amount, int month, int year) {
        super(aptNo, amount, month, year);
    }
    //constructor
    
    @Override
    public double calculateAmount(){
        return amount;
    }
    
}
