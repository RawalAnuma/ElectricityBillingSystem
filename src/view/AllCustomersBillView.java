package view;

import controller.BillRecordsController;
import dao.BillRecordsDAO;
import model.BillRecords;

import java.util.List;

public class AllCustomersBillView {
    private BillRecordsController billRecordsController = new BillRecordsController();
    public void showAllBills(){
        try{
            List<BillRecords> billRecordsList = billRecordsController.getAllBillRecords();
            if (billRecordsList.isEmpty()) {
                System.out.println("No bill records found.");
            } else {
                System.out.println("All Customers Bill Records:");
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.println("Bill ID    | Customer Name   | House Number  | Units Consumed  | Bill Amount    | Bill Date");
                System.out.println("-------------------------------------------------------------------------------------------------");
                for (BillRecords bill : billRecordsList) {
                    System.out.printf("%-10d | %-15s | %-13d | %-15.2f | %-14.2f | %s%n",
                            bill.getBillId(),
                            bill.getCustomerName(),
                            bill.getHouseNumber(),
                            bill.getUnitsConsumed(),
                            bill.getBillAmount(),
                            bill.getBillDate());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
