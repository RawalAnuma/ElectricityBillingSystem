package model;

public class Customer {
    private String customerName;
    private int houseNumber;
    private double unitsConsumed;
    private double billAmount;

    public Customer(String customerName, int houseNumber, double unitsConsumed){
        this.customerName = customerName;
        this.houseNumber = houseNumber;
        this.unitsConsumed = unitsConsumed;
        this.billAmount = calculateBill();
    }

    public double calculateBill(){
        double bill = 0;
        double remainingUnits = 0;
        if(this.unitsConsumed <= 10){
            bill = 10 * this.unitsConsumed;
        }else if(this.unitsConsumed <= 30){
            remainingUnits = this.unitsConsumed - 10;
            bill = (remainingUnits * (250.0/20.0)) + 100;
        }else{
            remainingUnits = this.unitsConsumed - 20 - 10;
            bill = (remainingUnits * 2) + 100 + 250;
        }
        return bill;
    }


    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public int getHouseNumber(){
        return houseNumber;
    }
    public void setHouseNumber(int houseNumber){
        this.houseNumber = houseNumber;
    }
    public double getUnitsConsumed(){
        return unitsConsumed;
    }
    public void setUnitsConsumed(double unitsConsumed){
        this.unitsConsumed = unitsConsumed;
    }
    public double getBillAmount() {
        return billAmount;
    }
    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }
}
