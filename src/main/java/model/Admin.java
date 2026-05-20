/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author integ
 */
public class Admin {

    private int adminId;
    private int userId;
    private String name;
    
    //constructor
    public Admin(int adminId, int userId, String name) {
        this.adminId = adminId;
        this.userId = userId;
        this.name = name;
    }
    
    //getters
    public int getAdminId() {
        return adminId;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
    
    // setters
    public void setName(String name) {
        this.name = name;
    }

}
