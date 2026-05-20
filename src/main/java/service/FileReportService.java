/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DAO.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.*;
/**
 *
 * @author integ
 */
public class FileReportService {
    private TenantDAO tenantDAO = new TenantDAO();
    private PaymentDAO paymentDAO = new PaymentDAO();
    
     public String generateReport(int adminId) {
        StringBuilder sb = new StringBuilder();

        ArrayList<Tenant> tenants = tenantDAO.loadTenants(new DefaultTableModel(), adminId);

        double totalIncome = 0;
        double totalDebt = 0;

        sb.append("RENT PAYMENT TRACKING REPORT\n");
        sb.append("--------------------------------\n");

        for (Tenant t : tenants) {
            double totalPaid = paymentDAO.getTotalPaidByTenant(t.getTenantId());
            double debt = t.getRentAmount() - totalPaid;

            if (debt < 0) {
                debt = 0;
            }

            totalIncome += totalPaid;
            totalDebt += debt;

            sb.append("Tenant: ").append(t.getName()).append("\n");
            sb.append("Apartment ID: ").append(t.getAptId()).append("\n");
            sb.append("Rent Amount: ").append(t.getRentAmount()).append("\n");
            sb.append("Total Paid: ").append(totalPaid).append("\n");
            sb.append("Debt: ").append(debt).append("\n");
            sb.append("--------------------------------\n");
        }

        sb.append("Tenant Count: ").append(tenants.size()).append("\n");
        sb.append("Total Income: ").append(totalIncome).append("\n");
        sb.append("Total Debt: ").append(totalDebt).append("\n");

        return sb.toString();
    }

    public void writeTextReport(String report) {
        try {
            FileWriter fw = new FileWriter("rent_report.txt");
            fw.write(report);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeBinaryReport(String report) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rent_report.dat"));

            oos.writeObject(report);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readBinaryReport() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rent_report.dat"));

            String report = (String) ois.readObject();
            ois.close();

            return report;

        } catch (Exception e) {
            e.printStackTrace();
            return "Binary report could not be read!";
        }
    }
}
