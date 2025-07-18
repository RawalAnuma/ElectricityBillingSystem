package handler;

import controller.BillRecordsController;
import controller.CustomerController;
import model.BillRecords;
import model.Customer;

import java.util.Scanner;

public class BillingHandler {
    private CustomerController customerController = new CustomerController();
    private BillRecordsController billRecordsController = new BillRecordsController();
    private Scanner scanner = new Scanner(System.in);

    public void handleCalculateBill(){
        String customerName;
        int houseNumber;
        double unitsConsumed;
        System.out.println("Enter Customer Name: ");
        customerName = scanner.nextLine();

        while (true) {
            try{
                System.out.println("Enter House Number: ");
                houseNumber = Integer.parseInt(scanner.nextLine());
                if(houseNumber <= 0){
                    System.out.println("House number must be a positive integer. Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for house number. Please enter a valid integer.");
            }
        }

        while(true){
            try{
                System.out.println("Enter Units Consumed: ");
                unitsConsumed = Double.parseDouble(scanner.nextLine());
                if(unitsConsumed < 0){
                    System.out.println("Units consumed cannot be negative. Please try again!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for units consumed. Please enter a valid number.");
            }
        }

        try{
            int customerId = customerController.addCustomer(customerName, houseNumber, unitsConsumed);
            double billAmount = billRecordsController.generateBill(customerId, unitsConsumed);
            System.out.println("\n---------Customer Bill Generated---------");
            System.out.println("Bill Date       : " + java.time.LocalDate.now());
            System.out.println("Customer Name   : " + customerName);
            System.out.println("House Number    : " + houseNumber);
            System.out.println("Units Consumed  : " + unitsConsumed);
            System.out.println("Bill Amount     : Rs. " + billAmount);
            System.out.println("-----------------------------------------\n");

        } catch (Exception e) {
            System.out.println("Error generating bill: " + e.getMessage());
        }

    }

    public void handleHighestBill() {
        try{
            BillRecords highestBill = billRecordsController.getHighestPayingCustomer();
            if (highestBill != null) {
                System.out.println("Highest Paying Customer:");
                System.out.println("Customer Name   : " + highestBill.getCustomerName());
                System.out.println("House Number    : " + highestBill.getHouseNumber());
                System.out.println("Bill Amount     : " + highestBill.getBillAmount());
                System.out.println("Units Consumed  : " + highestBill.getUnitsConsumed());
                System.out.println("Bill Date       : " + highestBill.getBillDate());
            } else {
                System.out.println("No bill records found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving highest paying customer: " + e.getMessage());
        }
    }
}
