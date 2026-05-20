/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Tenant;

/**
 *
 * @author integ
 */

/*
Admin → owns → Apartments
Apartment → has → Tenant
*/
public class TenantDAO {
    //TENANT EKLEME METHODU //add tenant
    public void addTenant(Tenant tenant){
        
        try{
            Connection con = DBConnection.getConnection();
            
            
            // APARTMENT KONTROLÜ
            String checkQuery ="SELECT * FROM apartments WHERE aptid = ? AND adminid = ?";

            PreparedStatement checkPst = con.prepareStatement(checkQuery);

            checkPst.setInt(1, tenant.getAptId());
            checkPst.setInt(2, tenant.getAdminId());

            ResultSet checkRs = checkPst.executeQuery();

            // apartment bu admine ait değilse
            if(!checkRs.next()){
                throw new Exception(
                    "This apartment does not belong to this admin!"
                );
            }
            

            //admin tenant ekleyince otomatik şifre oluşturulur sonra tenant ilk girişinde değiştirir
            String password = tenant.getUsername()+ "_123";
            
            //USERS TABLOSUNA EKLEME 
            String userQuery = "INSERT INTO users(username, password, role) VALUES (?, ?, ?)";
             PreparedStatement userPst =
                con.prepareStatement(userQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);
             
            userPst.setString(1, tenant.getUsername());
            userPst.setString(2, password);
            userPst.setString(3, "tenant");
            
            userPst.executeUpdate();
            
             // oluşan useridyi al
            ResultSet generatedKeys = userPst.getGeneratedKeys();

            int userId = 0;

            if(generatedKeys.next()){
                userId = generatedKeys.getInt(1);
            }
            
            
            //TENANTS TABLOSUNA EKLEME 
            String query = "INSERT INTO tenants(userid, name, aptid, rentamount, adminid) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setInt(1, userId);
            pst.setString(2,tenant.getName());
            pst.setInt(3, tenant.getAptId());
            pst.setDouble(4, tenant.getRentAmount());
            pst.setInt(5, tenant.getAdminId());
            
            pst.executeUpdate();

            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //TENANT SİLME METHODU //delete tenant
    public void deleteTenant(int tenantid , int adminId){
        String query = "DELETE FROM tenants WHERE tenantid = ? AND adminid = ?";
        
        try{
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, tenantid);
            pst.setInt(2, adminId);
            
            pst.executeUpdate();

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //TENANT GÜNCELLEME //update tenant
    public void updateTenant(Tenant t){
        String query = "UPDATE tenants SET name=?, aptid=?, rentamount=? WHERE tenantid=? AND adminid=?";
        
        try{
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, t.getName());
            pst.setInt(2, t.getAptId());
            pst.setDouble(3, t.getRentAmount());
            pst.setInt(4, t.getTenantId());
            pst.setInt(5, t.getAdminId());

            pst.executeUpdate();

            con.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    // TÜM TENANTLARI GETİRME
    public ArrayList<Tenant> loadTenants(DefaultTableModel dtm, int adminId) {
        ArrayList<Tenant> tenantList = new ArrayList<>();
        
        //sadece belirlenen adminin tenantları gelecek
        String query = "SELECT * FROM tenants WHERE adminid = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            // ? yerine adminId koyulur
            pst.setInt(1, adminId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Tenant tenant = new Tenant(
                        rs.getInt("tenantid"),
                        rs.getInt("userid"),
                        rs.getString("name"),
                        rs.getInt("aptid"),
                        rs.getDouble("rentamount"),
                        rs.getInt("adminid")
                );
                tenantList.add(tenant);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        // tabloyu temizle
        dtm.setRowCount(0);
        
        // tabloya ekle
        for(Tenant tenant : tenantList){
            dtm.addRow(new Object[]{
                tenant.getTenantId(),
                tenant.getUserId(),
                tenant.getName(),
                tenant.getAptId(),
                tenant.getRentAmount()
                });
        }
        
        return tenantList;
    }
    
    
    
}
