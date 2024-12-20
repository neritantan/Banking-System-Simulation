/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

import java.util.Random;

/**
 *
 * @author enesi
 */
public abstract class Account {
    private String holder;
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

            String IBAN =("TR"+TWOdigitrand_1+" "+FOURdigitrand_1+" "+FOURdigitrand_2+" "+FOURdigitrand_3+" "+FOURdigitrand_4+" "+TWOdigitrand_2);

        return IBAN;
    }
    }
    Account(){};

    public Account(String holder,String IBAN) {
        this.holder = holder;     
        balance = 0.00;
        this.IBAN = IBAN;
        //successMessage(); // Your Checking Account/Draft Account got created <- ABSTRACT METHOD
     }
    
    public Account(String holder) {// WORK IN PROGRESS
        this.holder = holder;     
        balance = 0.00;
        this.IBAN = IBANGenerator.generate();
    }

    public String getHolder() {
        return holder;
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
    
    public void deposit(double amount){
        balance += amount;
        System.out.println("$"+amount+" has been succesfully deposited to your account.");
    }
    
    public abstract String displayAccountInfo();
}
