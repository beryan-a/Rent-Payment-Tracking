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
    private int tenantId;
    private int userId;
    private String name;
    private String username;
    private int aptId;
    private double rentAmount;
    private int adminId;
    
    
    //constructor
    public Tenant(int tenantId, int userId, String name, int aptId, double rentAmount) {
        this.tenantId = tenantId;
        this.userId = userId;
        this.name = name;
        this.aptId = aptId;
        this.rentAmount = rentAmount;
    }
    
    public Tenant(int tenantId, int userId, String name,
              int aptId, double rentAmount, int adminId){
        this.tenantId = tenantId;
        this.userId = userId;
        this.name = name;
        this.aptId = aptId;
        this.rentAmount = rentAmount;
        this.adminId = adminId;
    }

    public Tenant(String username, String name, int aptId, double rentAmount,int adminId) {
        this.username = username;
        this.name = name;
        this.aptId = aptId;
        this.rentAmount = rentAmount;
        this.adminId=adminId;
    }
    
    //getters
    public int getTenantId() {
        return tenantId;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return username;
    }
    
    public int getAptId() {
        return aptId;
    }

    public double getRentAmount() {
        return rentAmount;
    }
    
    public int getAdminId(){
        return adminId;
    }
    
    
    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAptId(int aptId) {
        this.aptId = aptId;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }
    
}
