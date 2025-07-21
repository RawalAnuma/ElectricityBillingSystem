package dao;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private Connection conn;

    public CustomerDAO() {
        try {
            conn = DatabaseConnection.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertCustomer(Customer customer){
        String query = "INSERT INTO customer(customername, housenumber, unitsconsumed) VALUES (?, ?, ?)";
        try {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, customer.getCustomerName());
                ps.setInt(2, customer.getHouseNumber());
                ps.setDouble(3, customer.getUnitsConsumed());
                ps.executeUpdate();
                return true;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public int getCustomerIdByDetails(String customerName, int houseNumber, double unitsConsumed) {
        String query = "SELECT customerid FROM customer WHERE customername = ? AND housenumber = ? AND unitsconsumed = ?";
        try {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, customerName);
                ps.setInt(2, houseNumber);
                ps.setDouble(3, unitsConsumed);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("customerid");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1; // Return -1 if no customer found
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customerList = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int customerId = rs.getInt("customerid");
                    String customerName = rs.getString("customername");
                    int houseNumber = rs.getInt("housenumber");
                    double unitsConsumed = rs.getDouble("unitsconsumed");
                    Customer customer = new Customer(customerId, customerName, houseNumber, unitsConsumed);
                    customerList.add(customer);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }
}