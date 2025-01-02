package bankingsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class SavingsAccount extends CheckingAccount {
    double interestRate = 0.02; 
    double investedAmount = 0;  
    double savingsBalance = 0;  
    LocalDate investmentDate;   
    SavingsAccount(Customer holder) {
        super(holder, "Saving Account");

    }
    
    SavingsAccount(Customer holder, double balance, String IBAN, String accountInfoPath,
                   String accountType, double interestRate, double investedAmount, double savingsBalance,
                   LocalDate investmentDate, LocalDate currentDay ) { // Use this while creating from file
        
        super(holder,balance,IBAN,accountInfoPath,accountType);
        this.accountType = accountType;
        this.interestRate = interestRate;
        this.investedAmount = investedAmount;
        this.savingsBalance = savingsBalance;
        this.investmentDate = investmentDate;
        
        applyInterest(currentDay);
    }

    
    
    
    private void createAccount() { // customers/"+holder.getTCID()+"/"+this.IBAN
        String accountFileName = ("customers/" + super.holder.getTCID() + "/" + super.getIBAN());
        File accountFile = new File(accountFileName);
        accountFile.mkdir();
        File accountInfo = new File(accountFileName + "/accountInfo.txt");
        try {
            accountInfo.createNewFile();
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            FileWriter fileWriter = new FileWriter(accountInfo);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(accountInfo());
            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            e.getMessage();
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
                "\nSavings Balance: $" + savingsBalance + 
                "\nInvestment Date: " + investmentDate);
    }

    public String accountInfo() { // This part will be written into accountInfo.txt// WORK IN PROGRESS
        return (accountType + "\n" +
                super.getHolderName() + "\n" + 
                super.getIBAN() + "\n" + 
                super.getBalance() + "\n" + 
                interestRate   + "\n" +
                investedAmount + "\n" + 
                savingsBalance + "\n" + 
                investmentDate + "\n");
    }

    public void deposit(double amount, LocalDate currentDay) {
        try {
            if (amount <= 0) {
                throw new InvalidDepositAmountException(amount);
            }
            super.deposit(amount);
        } catch (InvalidDepositAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    public void invest(double amount, LocalDate currentDay) {
        try {
            if (amount <= 0) {
                throw new InvalidDepositAmountException(amount);
            }
            if (super.getBalance() >= amount) {
                investedAmount += amount;
                super.withdraw(amount);
                savingsBalance = amount;
                this.investmentDate = currentDay;
            } else {
                throw new InsufficientFundsException(savingsBalance,amount);
            }
        } catch (InvalidDepositAmountException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void applyInterest(LocalDate currentDay) {/// Use this one after creating from file
        long daysIn = java.time.temporal.ChronoUnit.DAYS.between(investmentDate, currentDay);
        double interestAmount = investedAmount * interestRate * daysIn;
        try {
            savingsBalance += interestAmount;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void withdrawInvestment() {
        try{
            super.deposit(investedAmount);
            investedAmount = 0;
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
