/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author enesi
 */
public class CheckingAccount extends Account{
    String accountType = "Checking Account";
    public CheckingAccount(Customer holder) {
        super(holder);
    }

    public String displayAccountInfo(){
        return  ("Account Type: "+accountType
                +"\nHolder: "+super.getHolderName()
                + "\nIBAN: "+super.getIBAN()
                + "\nBalance: $"+super.getBalance());
    }
    
    
    public String accountInfo(){// This part will be written into accountInfo.txt// WORK IN PROGRESS
        
        return (accountType+"\n"
                +super.getHolderName()+"\n"
                +super.getIBAN()+"\n"
                +super.getBalance()+"\n");
    }
}
