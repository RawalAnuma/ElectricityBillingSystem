package calculation;

public class BillCalculation {
    public double calculateBill(double unitsConsumed) {
        double bill = 0;
        double remainingUnits = 0;

        if (unitsConsumed <= 10) {
            bill = 10 * unitsConsumed;
        } else if (unitsConsumed <= 30) {
            remainingUnits = unitsConsumed - 10;
            bill = (remainingUnits * (250.0 / 20.0)) + 100;
        } else {
            remainingUnits = unitsConsumed - 20 - 10;
            bill = (remainingUnits * 2) + 100 + 250;
        }
        return bill;
    }
}
