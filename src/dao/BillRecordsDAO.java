package dao;

import model.BillRecords;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BillRecordsDAO {
    private Connection conn;
    public BillRecordsDAO() {
        try {
            conn = DatabaseConnection.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertBillRecord(int customerId, double billAmount) {
        String query ="INSERT INTO billrecords(customerid, billamount) VALUES (?, ?)";
        try{
            if(conn != null){
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, customerId);
                ps.setDouble(2, billAmount);

                ps.executeUpdate();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BillRecords> getAllBillRecords() {
        List<BillRecords> billRecordsList = new ArrayList<>();
        String query = "SELECT customer.customername, customer.housenumber, customer.unitsconsumed, " + "billrecords.billamount, billrecords.billdate " +
                       "FROM customer JOIN billrecords ON customer.customerid = billrecords.customerid";
        try{
            if(conn != null){
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String customerName = rs.getString("customername");
                    int houseNumber = rs.getInt("housenumber");
                    double unitsConsumed = rs.getDouble("unitsconsumed");
                    double billAmount = rs.getDouble("billamount");
                    LocalDate billDate = rs.getDate("billdate").toLocalDate();

                    BillRecords billRecord = new BillRecords(customerName, houseNumber, unitsConsumed, billAmount, billDate);
                    billRecordsList.add(billRecord);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return billRecordsList;

    }

    public BillRecords getHighestPayingCustomer(){
        BillRecords highestPayingCustomer = null;
        String query = "SELECT customer.customername, customer.housenumber, customer.unitsconsumed, billrecords.billamount, billrecords.billdate " +
                "FROM billrecords " +
                "JOIN customer ON billrecords.customerid = customer.customerid " +
                "ORDER BY billrecords.billamount DESC LIMIT 1";
        try {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String customerName = rs.getString("customername");
                    int houseNumber = rs.getInt("housenumber");
                    double unitsConsumed = rs.getDouble("unitsconsumed");
                    double billAmount = rs.getDouble("billamount");
                    LocalDate billDate = rs.getDate("billdate").toLocalDate();

                    highestPayingCustomer = new BillRecords(customerName, houseNumber, unitsConsumed, billAmount, billDate);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return highestPayingCustomer;
    }
}
