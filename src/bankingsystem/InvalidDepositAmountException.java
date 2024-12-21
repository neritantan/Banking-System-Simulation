/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author enesi
 */
public class InvalidDepositAmountException extends Exception{
    double amount;
    
    InvalidDepositAmountException(double amount){
        this.amount = amount;
    }
    
    @Override
    public String toString(){
        return ("Deposited amount "+amount+" is invalid. Please enter again.");
    }
}
