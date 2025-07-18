package controller;

import calculation.BillCalculation;
import dao.BillRecordsDAO;
import model.BillRecords;
import model.Customer;

import java.util.List;

public class BillRecordsController {
    private BillRecordsDAO billRecordsDAO = new BillRecordsDAO();
    private BillCalculation billCalculation = new BillCalculation();

    public double generateBill(int customerId, double unitsConsumed) {
        double bill = billCalculation.calculateBill(unitsConsumed);
        billRecordsDAO.insertBillRecord(customerId, bill);
        return bill;
    }

    public List<BillRecords> getAllBillRecords() {
        return billRecordsDAO.getAllBillRecords();
    }

    public BillRecords getHighestPayingCustomer(){
        return billRecordsDAO.getHighestPayingCustomer();
    }
}
