package bankingsystem;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author enesi
 */

public class NewMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        EFT.setupDataBase();

        while (!exitProgram) {
            // Main Menu
            System.out.println("\n=== Banking System ===");
            System.out.println("1- Login");
            System.out.println("2- Register");
            System.out.println("0- Exit");
            System.out.print("Your choice: ");
            
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 0:
                    System.out.println("Thank you for using our banking system. Goodbye!");
                    exitProgram = true;
                    break;
                    
                case 1: // LOGIN
                    handleLogin(scanner);
                    break;
                    
                case 2: // REGISTER
                    handleRegistration(scanner);
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void handleLogin(Scanner scanner) {
        Customer customer = null;
        Login login = null;
        boolean error;

        System.out.println("\n=== Login ===");
        System.out.println("Welcome back! Please fill out your information to log in.");
        System.out.println("(Enter 0 as TCID to go back to main menu)");

        do {
            error = false;
            try {
                System.out.print("TCID: ");
                String TCID = scanner.nextLine();
                
                if (TCID.equals("0")) {
                    return;
                }
                
                System.out.print("Password: ");
                String password = scanner.nextLine();
                login = new Login(TCID, password);
            } catch (CustomerNotFoundException | PasswordNotCorrectException e) {
                System.out.println(e.toString());
                error = true;
            }
        } while (error);

        customer = login.getLoggedCustomer();
        handleAccountMenu(scanner, customer);
    }
    
    private static void handleRegistration(Scanner scanner) { 
        System.out.println("\n=== Registration ==="); 
        System.out.println("Welcome! Please fill out the following information."); 
        System.out.println("(Enter 0 at any time to go back to main menu)"); 
        System.out.print("First Name: "); 
        String firstName = scanner.nextLine(); 
        if (firstName.equals("0")) return; 
        System.out.print("Last Name: "); 
        String lastName = scanner.nextLine(); 
        if (lastName.equals("0")) return; 
        String TCID; 
        while (true) { 
            System.out.print("TCID: "); 
            TCID = scanner.nextLine(); 
            if (TCID.equals("0")) return; 
            try { 
                validateTCID(TCID); 
                break; 
            } catch (InvalidTCIDException e) { 
                System.out.println(e.toString() + " Please try again."); 
            } 
        } 
        System.out.print("Password: "); 
        String password = scanner.nextLine(); 
        if (password.equals("0")) return; 
        Customer customer = new Customer(firstName, lastName, TCID, password); 
        handleAccountCreation(scanner, customer); 
    } 

    private static void validateTCID(String TCID) throws InvalidTCIDException { 
        if (TCID.length() != 11 || !TCID.matches("\\d+")) { 
            throw new InvalidTCIDException(TCID); 
        } 
    }

    private static void handleAccountCreation(Scanner scanner, Customer customer) {
        String yesno ="y";
        do {
            System.out.println("\n=== Create Account ===");
            System.out.println("Which type of account do you want to create?");
            System.out.println("1- Checking Account");
            System.out.println("2- Overdraft Account");
            System.out.println("3- Savings Account");
            System.out.println("0- Back to Account Menu");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    customer.accounts.add(new CheckingAccount(customer));
                    break;
                case 2:
                    customer.accounts.add(new OverdraftAccount(customer));
                    break;
                case 3:
                    customer.accounts.add(new SavingsAccount(customer));
                    break;
                default:
                    System.out.println("Invalid option!");
                    continue;
            }

            System.out.print("Do you want to create another account? (y/n): ");
            yesno = scanner.nextLine();
        } while (yesno.equalsIgnoreCase("y"));

        handleAccountMenu(scanner, customer);
    }

    private static void handleAccountMenu(Scanner scanner, Customer customer) {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            System.out.println("\n=== Account Selection ===");
            for (int i = 0; i < customer.accounts.size(); i++) {
                System.out.println((i + 1) + "- " + customer.accounts.get(i).getaccountType() + 
                                 " | " + customer.accounts.get(i).getIBAN());
            }
            System.out.println("0- Back to Main Menu");
            System.out.print("Select an account: ");
            
            int accountSelection = scanner.nextInt();
            scanner.nextLine();

            if (accountSelection == 0) {
                backToMainMenu = true;
                continue;
            }

            if (accountSelection < 1 || accountSelection > customer.accounts.size()) {
                System.out.println("Invalid account selection!");
                continue;
            }

            Account selectedAccount = customer.accounts.get(accountSelection - 1);
            handleTransactionMenu(scanner, selectedAccount);
        }
        
        customer.createCustomerInfoFile();
    }

   private static void handleTransactionMenu(Scanner scanner, Account selectedAccount) {
    boolean backToAccountSelection = false;

    while (!backToAccountSelection) {
        System.out.println("\n=== Transaction Menu ===");
        System.out.println("Selected Account Info:");
        System.out.println(selectedAccount.displayAccountInfo());
        System.out.println("\nWhat would you like to do?");
        
        // Temel menü öğeleri
        System.out.println("1- Withdraw");
        System.out.println("2- Deposit");
        System.out.println("3- EFT to IBAN");
        System.out.println("4- View Transaction History");
        
        // Eğer hesap bir SavingsAccount ise ek menü öğeleri göster
        if (selectedAccount instanceof SavingsAccount) {
            System.out.println("5- Invest");
            System.out.println("6- Withdraw Investments");
        }
        
        System.out.println("0- Back to Account Selection");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 0) {
            backToAccountSelection = true;
            continue;
        }

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    selectedAccount.withdraw(withdrawAmount);
                    System.out.println("New balance: " + selectedAccount.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    selectedAccount.deposit(depositAmount);
                    System.out.println("New balance: " + selectedAccount.getBalance());
                    break;

                case 3:
                    System.out.print("Enter receiver's IBAN: ");
                    String receiverIBAN = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine();
                    EFT.transfer(selectedAccount.getIBAN(), receiverIBAN, transferAmount);
                    break;

                case 4:
                    selectedAccount.printTransactionLog();
                    break;

                case 5:
                    if (selectedAccount instanceof SavingsAccount) {
                        System.out.print("Enter amount to invest: ");
                        double investAmount = scanner.nextDouble();
                        scanner.nextLine();
                        LocalDate today = LocalDate.now();
                        ((SavingsAccount) selectedAccount).invest(investAmount,today);
                        System.out.println("Investment successful!");
                    } else {
                        System.out.println("Invalid option for this account type!");
                    }
                    break;

                case 6:
                    if (selectedAccount instanceof SavingsAccount) {
                        ((SavingsAccount) selectedAccount).withdrawInvestment();
                        System.out.println("Investment withdrawal successful!");
                    } else {
                        System.out.println("Invalid option for this account type!");
                    }
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } catch (InsufficientFundsException | InvalidDepositAmountException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        if (!backToAccountSelection) {
            System.out.print("\nWould you like to perform another transaction? (y/n): ");
            String continueTransactions = scanner.nextLine();
            if (!continueTransactions.equalsIgnoreCase("y")) {
                backToAccountSelection = true;
            }
        }
    }
}
}