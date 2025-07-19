package view;


import controller.BillRecordsController;
import controller.CustomerController;

import java.util.Scanner;

public class BillingView{
    private static CustomerController customerController = new CustomerController();
    private static BillRecordsController billRecordsController =  new BillRecordsController();
    public static void handleCalculateBill(){
        Scanner scanner = new Scanner(System.in);
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
            int customerId = customerController.getCustomerId(customerName, houseNumber, unitsConsumed);
            if(customerId == -1) {
                boolean isAdded = customerController.addCustomer(customerName, houseNumber, unitsConsumed);
                if (!isAdded) {
                    System.out.println("Error adding customer. Please try again.");
                    return;
                }
                customerId = customerController.getCustomerId(customerName, houseNumber, unitsConsumed);
            }
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
}