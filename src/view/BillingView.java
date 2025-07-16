package view;

import controller.CustomerController;
import model.Customer;

import java.util.List;
import java.util.Scanner;

public class BillingView {
    private CustomerController customerController = new CustomerController();
    public void showBillingView(){
        Scanner scanner = new Scanner (System.in);
        while (true){
            try{
                System.out.println("Enter number of customers (3 to 5): ");
                int numberOfCustomers = Integer.parseInt(scanner.nextLine());

                if (numberOfCustomers < 3 || numberOfCustomers > 5) {
                    System.out.println("Invalid number of customers. Please enter a number between 3 and 5.");
                    continue;
                }
                for (int i = 0; i < numberOfCustomers; i++) {
                    System.out.println("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter house number: ");
                    int houseNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter units consumed: ");
                    double unitsConsumed = Double.parseDouble(scanner.nextLine());

                    customerController.addCustomer(customerName, houseNumber, unitsConsumed);
                }

                List<Customer> allCustomers = customerController.getAllCustomers();
                System.out.println("All customers billing information: ");
                for (Customer customer : allCustomers) {
                    System.out.println("Customer Name: " + customer.getCustomerName());
                    System.out.println("House Number: " + customer.getHouseNumber());
                    System.out.println("Units Consumed: " + customer.getUnitsConsumed());
                    System.out.println("Bill Amount: " + customer.calculateBill());
                    System.out.println("-----------------------------");
                }

                Customer highestBillCustomer = customerController.getHighestBillCustomer(allCustomers);
                if (highestBillCustomer != null) {
                    System.out.println("Highest Paying Customer:");
                    System.out.println("Customer Name: " + highestBillCustomer.getCustomerName());
                    System.out.println("House Number: " + highestBillCustomer.getHouseNumber());
                    System.out.println("Units Consumed: " + highestBillCustomer.getUnitsConsumed());
                    System.out.println("Bill Amount: " + highestBillCustomer.calculateBill());
                } else {
                    System.out.println("No customers found.");
                }

                System.out.println("Do you want to continue? (yes/no)");
                String continueChoice = scanner.nextLine().trim().toLowerCase();
                if (!continueChoice.equals("yes")) {
                    System.out.println("Thank you for using the billing system!");
                    break;
                }

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }

        }

    }
}
