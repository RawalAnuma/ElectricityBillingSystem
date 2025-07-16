package controller;

import dao.CustomerDAO;
import model.Customer;

import java.util.List;

public class CustomerController {
    private CustomerDAO customerDAO = new CustomerDAO();

    public void addCustomer(String customerName, int houseNumber, double unitsConsumed){
        Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
        customerDAO.insertCustomer(customer);
    }
    public List<Customer> getAllCustomers(){
        return customerDAO.getAllCustomers();
    }

    public Customer getHighestBillCustomer(List<Customer> customers) {
        Customer highestBillCustomer = null;
        double maxBill = 0;

        for (Customer customer : customers) {
            double bill = customer.calculateBill();
            if (bill > maxBill) {
                maxBill = bill;
                highestBillCustomer = customer;
            }
        }
        return highestBillCustomer;
    }
}
