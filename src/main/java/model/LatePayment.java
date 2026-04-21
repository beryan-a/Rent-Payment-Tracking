/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author integ
 */
public class LatePayment extends Payment{
    private int delayDayCount;

    public LatePayment(int aptNo, double amount, int month, int year, int delayDayCount) {
        super(aptNo, amount, month, year);
        this.delayDayCount= delayDayCount;
    }
    
    //constructor
    
    @Override
    public double calculateAmount(){
        //gecikme zamı uygulaması
        return amount+(amount*0.02*delayDayCount);
    }
    
}
