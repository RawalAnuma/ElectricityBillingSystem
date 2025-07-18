package view;


import handler.BillingHandler;

import java.util.Scanner;

public class BillingView{
    private BillingHandler billingHandler = new BillingHandler();
    public void showBillingView(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter 1: Calculate Bill");
            System.out.println("Enter 2: Show highest bill");
            System.out.println("Enter 3: Exit");
            int option = Integer.parseInt(scanner.nextLine());

            if(option < 1 || option > 3){
                System.out.println("Invalid option, please enter 1/2/3");
            } else if(option == 1){
                billingHandler.handleCalculateBill();

            }else if(option == 2){
                billingHandler.handleHighestBill();

            }else if(option == 3){
                System.out.println("Thank you for using the billing system!");
                break;
            }else{
                System.out.println("Invalid option, please enter 1/2/3");
            }
        }
    }
}