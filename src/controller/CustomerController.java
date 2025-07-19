package controller;

import dao.CustomerDAO;
import model.Customer;

import java.util.List;

public class CustomerController {
    private CustomerDAO customerDAO = new CustomerDAO();

    public boolean addCustomer(String customerName, int houseNumber, double unitsConsumed){
        Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
        return customerDAO.insertCustomer(customer);
    }
    public List<Customer> getAllCustomers(){
        return customerDAO.getAllCustomers();
    }
    public int getCustomerId(String customerName, int houseNumber, double unitsConsumed) {
        return customerDAO.getCustomerIdByDetails(customerName, houseNumber, unitsConsumed);
    }
}
