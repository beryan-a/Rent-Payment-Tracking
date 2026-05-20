/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

/**
 *
 * @author integ
 */

import model.Payment;
import model.Tenant;
import java.util.ArrayList;

public class ApartmentManager {
    private ArrayList<Tenant> tenants = new ArrayList<>();
    private ArrayList<Payment> payments = new ArrayList<>();
    
    //adders
    public void addTenant(Tenant t){
        tenants.add(t);
    }
    public void addPayment(Payment p){
        payments.add(p);
    }
    
    //getters 

    public ArrayList<Tenant> getTenants() {
        return tenants;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }
    
    // functions
    /*public double calculateDebt(Tenant t){
        double totalPaid=0;
        
        for(Payment p: payments){
            if(p.getAptNo() == t.getAptNo()){
                totalPaid += p.calculateAmount();
            }
        }
        
        if(t.getRent()-totalPaid<0){// zamlarla beraber bu hesaplamaya göre debt 0 altına inebilir bunu 0a set ettim burada 
            return 0;
        }
        return t.getRent()-totalPaid;
                
    }
    
    public boolean hasPayment(int aptNo, int month, int year){
        for(Payment p : payments){
            if(p.getAptNo() == aptNo && 
                p.getMonth() == month && 
                p.getYear()== year){
                return true;
            }
        }
        return false;
    }
    
    public double getMonthlyPaid(int aptNo, int month, int year){
    double total = 0;

    for(Payment p : payments){
        if(p.getAptNo() == aptNo &&
           p.getMonth() == month &&
           p.getYear() == year){
            total += p.calculateAmount();
        }
    }

    return total;
}*/
}
