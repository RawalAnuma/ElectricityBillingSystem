package dao;

import model.BillRecords;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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

    public boolean insertBillRecord(int customerId, double billAmount) {
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
        return true;
    }

    public List<BillRecords> getAllBillRecords() {
        List<BillRecords> billRecordsList = new ArrayList<>();
        String query = "SELECT billrecords.billid, billrecords.customerid, customer.customername, customer.housenumber, customer.unitsconsumed, billrecords.billamount, billrecords.billdate " + "FROM billrecords JOIN customer ON billrecords.customerid = customer.customerid " + "ORDER BY billrecords.billamount DESC";
        try{
            if(conn != null){
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int billId = rs.getInt("billid");
                    int customerId = rs.getInt("customerid");
                    String customerName = rs.getString("customername");
                    int houseNumber = rs.getInt("housenumber");
                    double unitsConsumed = rs.getDouble("unitsconsumed");
                    double billAmount = rs.getDouble("billamount");
                    LocalDate billDate = rs.getDate("billdate").toLocalDate();

                    BillRecords billRecord = new BillRecords(billId, customerId, customerName, houseNumber, unitsConsumed, billAmount, billDate);
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
        String query = "SELECT billrecords.billid, billrecords.customerid, customer.customername, customer.housenumber, customer.unitsconsumed, billrecords.billamount, billrecords.billdate " +
                "FROM billrecords JOIN customer ON billrecords.customerid = customer.customerid " +
                "ORDER BY billrecords.billamount DESC ";
        try {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int billId = rs.getInt("billid");
                    int customerId = rs.getInt("customerid");
                    String customerName = rs.getString("customername");
                    int houseNumber = rs.getInt("housenumber");
                    double unitsConsumed = rs.getDouble("unitsconsumed");
                    double billAmount = rs.getDouble("billamount");
                    LocalDate billDate = rs.getDate("billdate").toLocalDate();

                    highestPayingCustomer = new BillRecords(billId, customerId, customerName, houseNumber, unitsConsumed, billAmount, billDate);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return highestPayingCustomer;
    }
}
