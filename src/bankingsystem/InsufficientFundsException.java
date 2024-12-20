/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author enesi
 */
public class InsufficientFundsException extends Exception{
    double balance;
    double amount;

    public InsufficientFundsException(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }
    
    @Override
    public String toString(){
        return ("Insufficient Funds!!");
    }
}
