/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author enesi
 */
public class OverdraftAccount extends CheckingAccount{
    //String accountType = "Overdraft Account";
    double draftLimit = 5000;
    double draftLeft;
    
    public OverdraftAccount(Customer holder) {
        super(holder,"Overdraft Account");
        draftLeft = draftLimit;
    }
    
    public OverdraftAccount(Customer holder,double draftLimit){// Polymorphism
        super(holder,"Overdraft Account");
        this.draftLimit = draftLimit;
        draftLeft = draftLimit;
    }
    
    public OverdraftAccount(Customer holder, double balance, String IBAN, String accountInfoPath, String accounType, double draftLimit, double draftLeft){
        super(holder,balance,IBAN,accountInfoPath,accounType);
        this.accountType = accountType;
        this.draftLimit = draftLimit;
        this.draftLeft = draftLeft;
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
    
    public String displayAccountInfo(){
        return  ("Account Type: "+getaccountType()
                +"\nHolder: "+super.getHolderName()
                + "\nIBAN: "+super.getIBAN()
                + "\nBalance: $"+super.getBalance()
                +"\nDraft Limit: "+draftLimit
                +"\nDraft Left: "+draftLeft);
    }
    
    @Override
    public void withdraw(double amount){
        Scanner scanner = new Scanner(System.in);
        try{
            super.withdraw(amount);
        }
        catch(InsufficientFundsException e){
            if(super.getBalance() + draftLeft < amount){
                e.toString();
            }
            else{
                String yesNo;
                System.out.println("You don't have enough balance to withdraw $"+amount+". Would you like to use cash advance to continue transaction? (y/n)");
                System.out.println("(Remaining $"+(amount-super.getBalance())+" will be used from your cash advance.)");
                yesNo = scanner.nextLine();
                if(yesNo.equals("y")){
                    try{
                        super.withdraw(super.getBalance());
                    }
                    catch(Exception e2){
                        e2.toString();   
                    }
                    draftLeft -= amount-super.getBalance();
                    System.out.println("$"+amount+" succesfully withdrawed from your account using cash advance.");
                    System.out.println("Cash Advance Left: "+draftLeft);
                }
                else{
                    
                }
            }
        }
    }
    
    @Override
     public String getaccountType(){
        return "Overdraft Account";
    }
    
    public String accountInfo(){// This part will be written into accountInfo.txt
        
        return (accountType+"\n"
                +super.getHolderName()+"\n"
                +super.getIBAN()+"\n"
                +super.getBalance()+"\n"
                +draftLimit+"\n"
                +draftLeft);
    }
}
