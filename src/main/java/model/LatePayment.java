/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author integ
 */
public class LatePayment extends Payment {

    public LatePayment(int paymentId, int tenantId,double amount, String paymentDate,String paymentType, int lateDays) {
        super(paymentId, tenantId, amount, paymentDate, paymentType, lateDays);
    }

    @Override
    public double calculateAmount() {
        return getAmount() +
               (getAmount() * 0.02 * getLateDays());
    }
}
