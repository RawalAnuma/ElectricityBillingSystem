package model;

import java.time.LocalDate;

public class BillRecords {
    private String customerName;
    private int houseNumber;
    private LocalDate billDate;
    private double billAmount;
    private double unitsConsumed;

    public BillRecords(String customerName, int houseNumber, double billAmount, double unitsConsumed, LocalDate billDate) {
        this.customerName = customerName;
        this.houseNumber = houseNumber;
        this.billAmount = billAmount;
        this.unitsConsumed = unitsConsumed;
        this.billDate = billDate;
    }

    public String getCustomerName() {
        return customerName;
    }
    public int getHouseNumber() {
        return houseNumber;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public double getBillAmount() {
        return billAmount;
    }
    public double getUnitsConsumed() {
        return unitsConsumed;
    }
}
