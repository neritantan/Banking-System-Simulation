/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author enesi
 */
public class SavingsAccount extends CheckingAccount{
    //String accountType = "Savings Account";
    double interestRate;
    double days = 0;
    
    SavingsAccount(Customer holder){
        super(holder,"Saving Account");
    }
    
    private void createAccount(){//customers/"+holder.getTCID()+"/"+this.IBAN
        String accountFileName = ("customers/"+super.holder.getTCID()+"/"+super.getIBAN());
        File accountFile = new File(accountFileName);
        accountFile.mkdir();
        //accountInfo(); --> Will be written to a text file.
        File accountInfo = new File(accountFileName+"/accountInfo.txt");
        try{
             accountInfo.createNewFile();
        }
        catch(Exception e){
            e.getMessage();
       }
       /// -> after file creation
       try {
        FileWriter fileWriter = new FileWriter(accountInfo); 
        BufferedWriter writer = new BufferedWriter(fileWriter);


        writer.write(accountInfo());

        writer.close();
        fileWriter.close();
            
    }
       catch (IOException e) {
        e.getMessage();
    }  
    }
    
    @Override
    public String getaccountType(){
        return "Savings Account";
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
