/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;
import java.io.File;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author enesi
 */
public abstract class Account {
    public Customer holder;
    private double balance;
    private String IBAN;
    private String accountInfoPath;
    // Nested static class
    static class IBANGenerator {
    //String IBAN = "TRXX 0001 ZZZZ ZZZZ ZZZZ ZZZZ ZZ"; ///Example IBAN
    
        static String generate(){
        
            Random rand = new Random();
            int TWOdigitrand_1 = rand.nextInt(100);
            int TWOdigitrand_2 = rand.nextInt(100);
            int FOURdigitrand_1 = rand.nextInt(10000);
            int FOURdigitrand_2 = rand.nextInt(10000);
            int FOURdigitrand_3 = rand.nextInt(10000);
            int FOURdigitrand_4 = rand.nextInt(10000);

            String IBAN = String.format("TR%02d %04d %04d %04d %04d %02d", 
                                    TWOdigitrand_1, FOURdigitrand_1, FOURdigitrand_2, 
                                    FOURdigitrand_3, FOURdigitrand_4, TWOdigitrand_2);

        return IBAN;
    }
    }
    
    private class Transaction{
        private String type;
        private double amount;
        private double newBalance;
        private Date date;
        public String transactionLogsFilePath = ("customers/"+holder.getTCID()+"/"+IBAN+"/transactions.log");
        
        public Transaction(String type, double amount, double newBalance) {
            this.type = type;
            this.amount = amount;
            this.newBalance = newBalance;
            this.date = new Date();
        }
        
       public String getFormattedTransactionRecord() { // --> Converts given transactions to Strings
            String sign = type.equals("Deposit") ? "+" : "-";
            return String.format("%1$td.%1$tm.%1$tY - %1$tT | %2$s$%3$.2f | %4$s | New Balance : $%5$.2f", 
                         date, sign, Math.abs(amount), type, newBalance);
        }


        
        public void saveTransactionToFile(){ // --> Saves transactions to file as Strings
            try{
                File transactionLogFile = new File(transactionLogsFilePath);
                if(!transactionLogFile.exists())
                    transactionLogFile.createNewFile();
                
                FileWriter fileWriter = new FileWriter(transactionLogFile , true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);// --> For faster writing
                
                bufferedWriter.write(this.getFormattedTransactionRecord());// --> Write transaction string to file.
                bufferedWriter.newLine();
                
                bufferedWriter.close();
                fileWriter.close();  
            }
            catch(IOException e){
                e.getMessage();
                System.out.println("Something went wrong while saving Transaction Log.");
            }
        }
        
        //public String getTransactionFromFile();
        
        
        
        
        
        
        
        
    }
    
    
    Account(){};

    public Account(Customer holder) {// WORK IN PROGRESS  //NEED TO CREATE A AccountInfo.txt file 
        this.holder = holder;
        balance = 0.00;
        this.IBAN = IBANGenerator.generate();
        accountInfoPath = ("customers/"+holder.getTCID()+"/"+this.IBAN+"/accountInfo.txt");
    }

    public String getHolderName() {
        return holder.getFullName();
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountInfoPath() {
        return accountInfoPath;
    }

    
    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount > balance)
            throw new InsufficientFundsException(balance,amount);
        else{
            balance -= amount;
            System.out.println("$"+amount+" has been succesfully withdrawed from your account.");
            updateAccountInfo();
            Transaction transaction = new Transaction("Withdraw",amount,this.balance);
            transaction.saveTransactionToFile();
        }
        
    }
    
    public void deposit(double amount) throws InvalidDepositAmountException{
        if(amount <= 0){
        throw new InvalidDepositAmountException(amount);
    }
        else{
            balance += amount;
            System.out.println("$"+amount+" has been succesfully deposited to your account.");
            updateAccountInfo();
            Transaction transaction = new Transaction("Deposit",amount,this.balance);
            transaction.saveTransactionToFile();
        }
        
    }
    
    private void updateAccountInfo() {
    try {
        File accountFile = new File(accountInfoPath);
        List<String> lines = Files.readAllLines(accountFile.toPath());
        lines.set(3, String.valueOf(this.balance)); 
        Files.write(accountFile.toPath(), lines);
    } 
    catch (IOException e) {
        e.getMessage();
    }
}
    
    public abstract String displayAccountInfo();
    public abstract String accountInfo();
}
