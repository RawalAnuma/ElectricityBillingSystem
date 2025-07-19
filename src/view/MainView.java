package view;

import java.util.Scanner;

public class MainView {
    private static BillingView billingView = new BillingView();
    private static HighestPayingView highestPayingView = new HighestPayingView();
    private static AllCustomersBillView allCustomersBillView = new AllCustomersBillView();
    public static void showBillingView(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter 1: Calculate Bill");
            System.out.println("Enter 2: Show highest bill");
            System.out.println("Enter 3: Show all customers bill");
            System.out.println("Enter 4: Exit");
            try{
                int option = Integer.parseInt(scanner.nextLine());


                if(option == 1){
                    billingView.handleCalculateBill();

                }else if(option == 2){
                    highestPayingView.handleHighestBill();

                }else if(option ==3){
                    allCustomersBillView.showAllBills();
                }else if(option == 4){
                    System.out.println("Thank you for using the billing system!");
                    break;
                }else{
                    System.out.println("Invalid option, please enter 1/2/3");
                }

            } catch (RuntimeException e) {
                System.out.println("Please enter a valid choice only");
            }

        }
    }
}
