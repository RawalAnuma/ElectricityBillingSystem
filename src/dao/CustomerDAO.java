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

    public int insertCustomer(Customer customer){
        String query = "INSERT INTO customer(customername, housenumber, unitsconsumed) VALUES (?, ?, ?)";
        int generatedId = -1; // Default value if insertion fails
        try {
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, customer.getCustomerName());
                ps.setInt(2, customer.getHouseNumber());
                ps.setDouble(3, customer.getUnitsConsumed());
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1); // Get the generated key
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return generatedId;
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