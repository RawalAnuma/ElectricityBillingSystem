package view;

import controller.BillRecordsController;
import model.BillRecords;

public class HighestPayingView {
    private BillRecordsController billRecordsController = new BillRecordsController();
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
