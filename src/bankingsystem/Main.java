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
    public static void main(String[] args){ //WORK IN PROGRESS //next thing to add is filling accountInfo.txt in constructor of Acconut
            Scanner scanner = new Scanner(System.in);
            String yesno ="n";
            int choice;
            int accountSelection;

            EFT.setupDataBase();

            System.out.println("Welcome please select:");
            System.out.println("1- Login");
            System.out.println("2- Register");
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice==1) { // LOGIN
                Customer customer = null;
                Login login = null;
                boolean error;
                System.out.println("Welcome back! Please fill out your information to log in.");

                do {
                    error = false;
                    try {
                        System.out.print("TCID: ");
                        String TCID = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();
                        login = new Login(TCID, password);
                    } catch (CustomerNotFoundException e) {
                        System.out.println(e.toString());
                        error = true;
                    } catch (PasswordNotCorrectException e) {
                        System.out.println(e.toString());
                        error = true;
                    }
                } while (error);

                customer = login.getLoggedCustomer();

                boolean backToAccountSelection;

                do {
                    backToAccountSelection = false;
                    do{
                    
                    System.out.println("\nPlease select an account to perform actions:");
                    for (int i = 0; i < customer.accounts.size(); i++) {
                        System.out.println((i + 1) + "- " + customer.accounts.get(i).getaccountType() + " | " + customer.accounts.get(i).getIBAN());
                    }
                    System.out.print("Your choice: ");
                    accountSelection = scanner.nextInt() - 1;
                    scanner.nextLine();
                    error = false;
                    if (accountSelection < 0 || accountSelection >= customer.accounts.size()) {
                        System.out.println("Invalid account selection, please try again.");
                        error = true;
                    }
                    }while(error);
                    

                    Account selectedAccount = customer.accounts.get(accountSelection);
                    System.out.println("\nSelected Account Info:");
                    System.out.println(selectedAccount.displayAccountInfo());

                    do {
                        System.out.println("\nWhat do you want to do?");
                        System.out.println("1- Withdraw");
                        System.out.println("2- Deposit");
                        System.out.println("3- View Transaction History");
                        System.out.println("4- Back");
                        System.out.print("Your choice: ");
                        choice = scanner.nextInt();
                        scanner.nextLine();

                        if (choice == 4) {
                            backToAccountSelection = true;
                            break;
                        }

                        double amount;
                        try {
                            switch (choice) {
                                case 1:
                                    System.out.print("Please enter the amount: ");
                                    amount = scanner.nextDouble();
                                    scanner.nextLine();
                                    selectedAccount.withdraw(amount);
                                    System.out.println("New balance: " + selectedAccount.getBalance());
                                    break;
                                case 2:
                                    System.out.print("Please enter the amount: ");
                                    amount = scanner.nextDouble();
                                    scanner.nextLine();
                                    selectedAccount.deposit(amount);
                                    System.out.println("New balance: " + selectedAccount.getBalance());
                                    break;
                                case 3:
                                    selectedAccount.printTransactionLog();
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
                    } while (!yesno.equals("n") && !backToAccountSelection);

                } while (backToAccountSelection);

                customer.createCustomerInfoFile();
                System.out.println("Goodbye Then!!");
            }

            else{   //REGISTRATION
            System.out.println("Welcome, In order to register please fill out the following boxes.");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("TCID: ");
            String TCID = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            Customer customer = new Customer(firstName,lastName,TCID,password);// Customer Creation
         
         do{
             
            System.out.println("\nWhich type of account you want to create?");
            System.out.println("1- Checking Account");
            System.out.println("2- Overdraft Account");
            System.out.println("3- Savings Account");
            choice = scanner.nextInt();
            scanner.nextLine();
         
         switch (choice){
             case 1:// hehehee~~
                 CheckingAccount checkingAccount = new CheckingAccount(customer);
                 customer.accounts.add(checkingAccount);
                 break;
             case 2:
                 OverdraftAccount overdraftAccount = new OverdraftAccount(customer);
                 customer.accounts.add(overdraftAccount);
                 break;
             case 3:
                 SavingsAccount savingsAccount =new SavingsAccount(customer);
                 customer.accounts.add(savingsAccount);
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
         customer.createCustomerInfoFile();
        System.out.println("Goodbye Then!!");
    } 
    }
}
