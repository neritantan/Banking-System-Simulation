/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package bankingsystem;
import java.util.Scanner;
/**
 *
 * @author enesi
 */
public class Main {
    public static void main(String[] args){ //WORK IN PROGRESS
            Scanner scanner = new Scanner(System.in);
            String yesno;
            int choice;
            int accountSelection;
        
            System.out.println("Welcome, In order to register please fill out the following boxes.");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("TCID: ");
            String TCID = scanner.nextLine();
            Customer customer = new Customer(firstName,lastName,TCID);
         
         do{
             
            System.out.println("\nWhich type of account you want to create?");
            System.out.println("1- Checking Account");
            System.out.println("2- Overdraft Account");
            System.out.println("3- Savings Account");
            choice = scanner.nextInt();
            scanner.nextLine();
         
         switch (choice){
             case 1:// hehehee~~
                 CheckingAccount account = new CheckingAccount(customer);
                 customer.accounts.add(account);
                 break;
             default:
                 break;
         }
         
            System.out.println("Do you want to create another account? (y/n)");
            yesno = scanner.nextLine();
         }while(!yesno.equals("n"));
         
         do {
            System.out.println("\nPlease select an account to perform actions:");
            for (int i = 0; i < customer.accounts.size(); i++) {
                System.out.println((i + 1) + "- " + customer.accounts.get(i).accountType + " | " + customer.accounts.get(i).getIBAN());
            }
            System.out.print("Your choice: ");
            accountSelection = scanner.nextInt() - 1;
            scanner.nextLine(); 

            if (accountSelection < 0 || accountSelection >= customer.accounts.size()) {
                System.out.println("Invalid account selection, please try again.");
                continue;
            }

            Account selectedAccount = customer.accounts.get(accountSelection);
            System.out.println("Selected Account Info:");
            System.out.println(selectedAccount.displayAccountInfo());

            System.out.println("\nWhat do you want to do?");
            System.out.println("1- Withdraw");
            System.out.println("2- Deposit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Please enter the amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        selectedAccount.withdraw(amount);
                        System.out.println("New balance: " + selectedAccount.getBalance());
                        break;
                    case 2:
                        selectedAccount.deposit(amount);
                        System.out.println("New balance: " + selectedAccount.getBalance());
                        break;
                    default:
                        System.out.println("Invalid option, please select a valid action.");
                        break;
                }
            } catch (InsufficientFundsException | InvalidDepositAmountException e) {
                System.out.println(e.toString());
            }

            System.out.print("Do you want to perform another action? (y/n): ");
            yesno = scanner.nextLine();
        } while (!yesno.equals("n"));

        System.out.println("Goodbye Then!!");
    }    
}
