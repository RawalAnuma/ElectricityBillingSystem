package model;

public class Customer {
    private String name;
    private String houseNumber;
    private double unitsConsumed;

    public Customer(String name, String houseNumber, double unitsConsumed){
        this.name = name;
        this.houseNumber = houseNumber;
        this.unitsConsumed = unitsConsumed;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getHouseNumber(){
        return houseNumber;
    }
    public void setHouseNumber(String houseNumber){
        this.houseNumber = houseNumber;
    }
    public double getUnitsConsumed(){
        return unitsConsumed;
    }
    public void setUnitsConsumed(double unitsConsumed){
        this.unitsConsumed = unitsConsumed;
    }
}
