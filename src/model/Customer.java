package model;

public class Customer {
    private int customerId;
    private String customerName;
    private int houseNumber;
    private double unitsConsumed;

    public Customer(int customerId, String customerName, int houseNumber, double unitsConsumed){
        this.customerId = customerId;
        this.customerName = customerName;
        this.houseNumber = houseNumber;
        this.unitsConsumed = unitsConsumed;
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

}
