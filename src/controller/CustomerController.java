package controller;

import dao.CustomerDAO;
import model.Customer;

import java.util.List;

public class CustomerController {
    private CustomerDAO customerDAO = new CustomerDAO();

    public int addCustomer(String customerName, int houseNumber, double unitsConsumed){
        Customer customer = new Customer(0, customerName, houseNumber, unitsConsumed);
        return customerDAO.insertCustomer(customer);
    }
    public List<Customer> getAllCustomers(){
        return customerDAO.getAllCustomers();
    }
}
