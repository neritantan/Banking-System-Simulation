/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author enesi
 */
public abstract class Account {
    private String holder;
    private double balance;
    private String IBAN;
    
    Account(){};

    public Account(String holder,String IBAN) {
        this.holder = holder;     
        balance = 0.00;
        this.IBAN = IBAN;
    }
    
    public Account(String holder) {// WORK IN PROGRESS
        this.holder = holder;     
        balance = 0.00;
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
    }
    
    //public abstract String displayAccountInfo();// Unused
}
