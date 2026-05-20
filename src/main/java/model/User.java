/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author integ
 */
public class User {

    private int user_id;
    private String username;
    private String password;
    private String role;
 
    //constructor
    public User(int id, String username, String password, String role) {
        this.user_id=id;
        this.username = username;
        this.password = password;
        this.role= role;
    }
    
    // getters 
    public int getId() { return user_id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
