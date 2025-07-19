package model;

import java.time.LocalDate;

public class BillRecords {
    private int billId;
    private int customerId;
    private String customerName;
    private int houseNumber;
    private double unitsConsumed;
    private LocalDate billDate;
    private double billAmount;

    public BillRecords(int billId, int customerId, String customerName, int houseNumber, double unitsConsumed, double billAmount, LocalDate billDate) {
        this.billId = billId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.houseNumber = houseNumber;
        this.unitsConsumed = unitsConsumed;
        this.billAmount = billAmount;
        this.billDate = billDate;
    }
    public int getBillId() {
        return billId;
    }
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public double getUnitsConsumed() {
        return unitsConsumed;
    }

    public LocalDate getBillDate() {
        return billDate;
    }
    public double getBillAmount() {
        return billAmount;
    }


}
