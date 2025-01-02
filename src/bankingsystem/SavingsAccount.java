package bankingsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class SavingsAccount extends CheckingAccount {
    double interestRate = 0.02; 
    double investedAmount = 0;  
    double savingsBalance = 0;  
    LocalDate investmentDate;   
    
    SavingsAccount(Customer holder) {
        super(holder, "Savings Account");
    }
    
    public SavingsAccount(Customer customer, double balance, String IBAN, String accountInfoPath, 
                         String accountType, double interestRate, double investedAmount, 
                         double savingsBalance, LocalDate investmentDate, LocalDate currentDay) {
        super(customer, balance, IBAN, accountInfoPath, accountType);
        this.accountType = accountType;
        this.interestRate = interestRate;
        this.investedAmount = investedAmount;
        this.savingsBalance = savingsBalance;
        this.investmentDate = investmentDate;

        if (this.investmentDate != null) {
            applyInterest(currentDay);
        }
    }

    private void createAccount() {
        String accountFileName = ("customers/" + super.holder.getTCID() + "/" + super.getIBAN());
        File accountFile = new File(accountFileName);
        accountFile.mkdir();
        File accountInfo = new File(accountFileName + "/accountInfo.txt");
        try {
            accountInfo.createNewFile();
            FileWriter fileWriter = new FileWriter(accountInfo);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(accountInfo());
            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error creating account file: " + e.getMessage());
        }
    }

    @Override
    public String getaccountType() {
        return "Savings Account";
    }

    public String displayAccountInfo() {
        return ("Account Type: " + accountType +
                "\nHolder: " + super.getHolderName() +
                "\nIBAN: " + super.getIBAN() +
                "\nBalance: $" + super.getBalance() +
                "\nInvested Amount: $" + investedAmount +
                "\nSavings Balance: $" + String.format(Locale.US, "%.2f", savingsBalance) +
                "\nInvestment Date: " + (investmentDate != null ? investmentDate : "(Not invested yet.)"));
    }

    public String accountInfo() {
        return (accountType + "\n" +
                super.getHolderName() + "\n" + 
                super.getIBAN() + "\n" + 
                super.getBalance() + "\n" + 
                String.format(Locale.US, "%.2f", interestRate) + "\n" +
                investedAmount + "\n" + 
                String.format(Locale.US, "%.2f", savingsBalance) + "\n"+
                investmentDate + "\n");
    }
    
    @Override
    public void updateAccountInfo() {
    try {
        FileWriter fileWriter = new FileWriter(getAccountInfoPath());
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(accountInfo());
        writer.close();
        fileWriter.close();
    } catch (IOException e) {
        System.out.println("Error updating account info: " + e.getMessage());
    }
}


    public void invest(double amount, LocalDate currentDay) throws InvalidDepositAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidDepositAmountException(amount);
        }
        if (super.getBalance() < amount) {
            throw new InsufficientFundsException(super.getBalance(), amount);
        }
        
        investedAmount += amount;
        super.withdraw(amount);
        savingsBalance = amount;
        this.investmentDate = currentDay;
        updateAccountInfo();
    }

    private void applyInterest(LocalDate currentDay) {
        if (investmentDate == null || currentDay == null) {
            return;
        }
        
        try {
            long daysBetween = ChronoUnit.DAYS.between(investmentDate, currentDay);
            if (daysBetween > 0 && investedAmount > 0) {
                double interestEarned = (investedAmount * (interestRate/100) * daysBetween);
                savingsBalance += interestEarned;
            }
        } catch (Exception e) {
            System.out.println("Error calculating interest: " + e.getMessage());
        }
        updateAccountInfo();
    }

    public void withdrawInvestment() throws InsufficientFundsException {
        if (investedAmount <= 0) {
            throw new InsufficientFundsException(investedAmount, 0);
        }
        try {
            super.deposit(investedAmount);
            investedAmount = 0;
            savingsBalance = 0;
            investmentDate = null;
        } catch (Exception e) {
            System.out.println("Error withdrawing investment: " + e.getMessage());
            //throw e;
        }
        updateAccountInfo();
    }
}