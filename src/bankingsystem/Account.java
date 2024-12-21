/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;
import java.io.File;
import java.util.Random;

/**
 *
 * @author enesi
 */
public abstract class Account {
    private Customer holder;
    private double balance;
    private String IBAN;
    
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
        createAccount();
        System.out.println("Account Created Succesfully!!"); // WILL BE A POP-UP WINDOW
    }
    
    private void createAccount(){
        String accountFileName = ("customers/"+holder.getTCID()+"/"+this.IBAN);
        File accountFile = new File(accountFileName);
        accountFile.mkdir();
        //displayAccountInfo(); --> Will be written to a text file. I mean it's about to get written but GitHub doesn't recognize some changes :/
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
    
    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount > balance)
            throw new InsufficientFundsException(balance,amount);
        else{
            balance -= amount;
            System.out.println("$"+amount+" has been succesfully withdrawed from your account.");
        }
    }
    
    public void deposit(double amount) throws InvalidDepositAmountException{
        if(amount <= 0){
        throw new InvalidDepositAmountException(amount);
    }
        else{
            balance += amount;
            System.out.println("$"+amount+" has been succesfully deposited to your account.");
        }
        
    }
    
    public abstract String displayAccountInfo();
}
