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

    private int paymentId;
    private int tenantId;
    private double amount;
    private String paymentDate;
    private String paymentType;
    private int lateDays;

    // constructor
    public Payment(int paymentId, int tenantId,
                   double amount, String paymentDate,
                   String paymentType, int lateDays) {

        this.paymentId = paymentId;
        this.tenantId = tenantId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.lateDays = lateDays;
    }

    // getters
    public int getPaymentId() {
        return paymentId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public int getLateDays() {
        return lateDays;
    }

    // setters
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    // polymorphism method
    public double calculateAmount() {
        return getAmount();
    }
}