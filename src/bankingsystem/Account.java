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
    
    
    Account(){};

    public Account(Customer holder) {// WORK IN PROGRESS  //NEED TO CREATE A AccountInfo.txt file 
        this.holder = holder;
        balance = 0.00;
        this.IBAN = IBANGenerator.generate();
        accountInfoPath = ("customers/"+holder.getTCID()+"/"+this.IBAN+"/accountInfo.txt");
    }
    
//    private void createAccount(){
//        String accountFileName = ("customers/"+holder.getTCID()+"/"+this.IBAN);
//        File accountFile = new File(accountFileName);
//        accountFile.mkdir();
//        //accountInfo(); --> Will be written to a text file.
//        File accountInfo = new File(accountFileName+"/accountInfo.txt");
//        try{
//             accountInfo.createNewFile();
//        }
//        catch(Exception e){
//            e.getMessage();
//       }
//       /// -> after file creation
//       try {
//        FileWriter fileWriter = new FileWriter(accountInfo); 
//        BufferedWriter writer = new BufferedWriter(fileWriter);
//
//
//        writer.write(accountInfo());
//
//        writer.close();
//        fileWriter.close();
//            
//    }
//       catch (IOException e) {
//        e.getMessage();
//    }  
//    }

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
