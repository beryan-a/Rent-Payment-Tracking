/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author integ
 */
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;


public class UserDAO {
    public User login(String username, String password){//loginde sql kontrolleri ve işlemlerini yapar
        User user = null; //Eğer veritabanında kullanıcı bulunursa bu nesnenin içi doldurulacak.
        
        try{
            Connection con = DBConnection.getConnection();
            String stmt= "SELECT * FROM users WHERE username=? AND password=?";
            //users tablosundaki tüm sütunları getir, ama
            //sadece kullanıcı adı ve şifresi benim vereceğim değerlere eşit olanları getir" der. Burardaki ? işaretleri güvenlik kapısıdır (SQL Injection saldırılarını önler).
            
            PreparedStatement pstmt=con.prepareStatement(stmt);
            
            pstmt.setString(1, username); //ilk ? (soru işaretine username)
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {

                int id = rs.getInt("userid");
                String uname = rs.getString("username");
                String pass = rs.getString("password");
                String role = rs.getString("role");

                user = new User(id, uname, pass, role);
            }

            con.close();
            
        }catch(Exception e){
            e.getMessage();
        }
        return user;
    }
}
