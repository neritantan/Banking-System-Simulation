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
public class CheckingAccount extends Account{
    String accountType;
    
    public CheckingAccount(Customer holder) {
        super(holder);
        accountType = "Checking Account";
        createAccount();
        System.out.println("Account Created Succesfully!!"); // WILL BE A POP-UP WINDOW
    }
    
    public CheckingAccount(Customer holder, String accountType){
        super(holder);
        this.accountType = accountType;
        System.out.println("In the accountType Constructor");
        System.out.println("Account type gathered from child is: "+accountType);
        System.out.println("Current account type is: "+this.accountType);
        createAccount();
        System.out.println("Account Created Succesfully!!");
    }
    
    public CheckingAccount(Customer holder, double balance, String IBAN, String accountInfoPath, String accounType){
        super(holder,balance,IBAN,accountInfoPath);
        this.accountType = accountType;
    }
    
    private void createAccount(){//customers/"+holder.getTCID()+"/"+this.IBAN
        String accountFileName = ("customers/"+super.holder.getTCID()+"/"+super.getIBAN());
        File accountFile = new File(accountFileName);
        if(!accountFile.exists())
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
    
    public String displayAccountInfo(){
        return  ("Account Type: "+accountType
                +"\nHolder: "+super.getHolderName()
                + "\nIBAN: "+super.getIBAN()
                + "\nBalance: $"+super.getBalance());
    }
    
    public String getaccountType(){
        return "Checking Account";
    }
    
    public String accountInfo(){// This part will be written into accountInfo.txt// WORK IN PROGRESS
        
        return (this.accountType+"\n"
                +super.getHolderName()+"\n"
                +super.getIBAN()+"\n"
                +super.getBalance()+"\n");
    }
}
