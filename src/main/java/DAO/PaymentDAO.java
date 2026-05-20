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

public class PaymentDAO {
    //ADD PAYMENT METHOD
    public void addPayment(Payment payment) {
        String query = "INSERT INTO payments(tenantid, amount, paymentdate, paymenttype, latedays) VALUES (?, ?, NOW(), ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, payment.getTenantId());
            pst.setDouble(2, payment.getAmount());
            pst.setString(3, payment.getPaymentType());
            pst.setInt(4, payment.getLateDays());

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //LOAD PAYMENT BY TENANT METHOD
    public ArrayList<Payment> loadPaymentsByTenant(int tenantId, String filter) {
        ArrayList<Payment> list = new ArrayList<>();

        String query = "SELECT * FROM payments WHERE tenantid = ?";

        if (!filter.equals("All")) {
            query += " AND paymenttype = ?";
        }

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, tenantId);

            if (!filter.equals("All")) {
                pst.setString(2, filter);
            }

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Payment p;

                if (rs.getString("paymenttype").equalsIgnoreCase("Late")) {
                    p = new LatePayment(
                            rs.getInt("paymentid"),
                            rs.getInt("tenantid"),
                            rs.getDouble("amount"),
                            rs.getString("paymentdate"),
                            rs.getString("paymenttype"),
                            rs.getInt("latedays")
                    );
                } else {
                    p = new OnTimePayment(
                            rs.getInt("paymentid"),
                            rs.getInt("tenantid"),
                            rs.getDouble("amount"),
                            rs.getString("paymentdate"),
                            rs.getString("paymenttype"),
                            rs.getInt("latedays")
                    );
                }

                list.add(p);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    //GET TOTAL PAID BY TENANT
    public double getTotalPaidByTenant(int tenantId) {
        double total = 0;

        String query = "SELECT * FROM payments WHERE tenantid = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, tenantId);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                double amount = rs.getDouble("amount");
                String type = rs.getString("paymenttype");
                int lateDays = rs.getInt("latedays");

                if (type.equalsIgnoreCase("Late")) {
                    total += amount + (amount * 0.02 * lateDays);
                } else {
                    total += amount;
                }
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }

}
