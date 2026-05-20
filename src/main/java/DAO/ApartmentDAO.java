/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author integ
 */
import database.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.*;

public class ApartmentDAO {
    //APARTMENT EKLER
    public void addApartment(Apartment apartment) {
        String query = "INSERT INTO apartments(adminid, address, status) VALUES (?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, apartment.getAdminId());
            pst.setString(2, apartment.getAddress());
            pst.setString(3, apartment.getStatus());

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //LOAD APARTMENTS
    public ArrayList<Apartment> loadApartments(int adminId) {
        ArrayList<Apartment> list = new ArrayList<>();

        String query = "SELECT * FROM apartments WHERE adminid = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, adminId);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Apartment apartment = new Apartment(
                        rs.getInt("aptid"),
                        rs.getInt("adminid"),
                        rs.getString("address"),
                        rs.getString("status")
                );

                list.add(apartment);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
   
    //UPDATE APARTMENT
    public void updateApartment(Apartment apartment) {
        String query = "UPDATE apartments SET address = ?, status = ? WHERE aptid = ? AND adminid = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, apartment.getAddress());
            pst.setString(2, apartment.getStatus());
            pst.setInt(3, apartment.getAptId());
            pst.setInt(4, apartment.getAdminId());

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //DELETE APARTMENT
    public void deleteApartment(int aptId, int adminId) {
        String query = "DELETE FROM apartments WHERE aptid = ? AND adminid = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, aptId);
            pst.setInt(2, adminId);

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //ADMİN APARTMENT RELATION
    public boolean apartmentBelongsToAdmin(int aptId, int adminId) {
        String query = "SELECT * FROM apartments WHERE aptid = ? AND adminid = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, aptId);
            pst.setInt(2, adminId);

            ResultSet rs = pst.executeQuery();

            boolean exists = rs.next();

            con.close();

            return exists;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     
}
