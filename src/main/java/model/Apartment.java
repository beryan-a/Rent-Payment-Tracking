/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author integ
 */
public class Apartment {

    private int aptId; //database’deki apartment primary key.
    private int adminId;
    private String address;
    private String status; //occupied or available

    //consturctor
    public Apartment(int aptId, int adminId, String address, String status) {
        this.aptId = aptId;
        this.adminId = adminId;
        this.address = address;
        this.status = status;
    }
    
    //getters

    public int getAptId() {
        return aptId;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }
    
    // setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
