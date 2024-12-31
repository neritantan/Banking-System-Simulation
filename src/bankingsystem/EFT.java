/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

/**
 *
 * @author enesi
 */
public class EFT {
   private static HashMap<String,String> IBANDataBase = new HashMap<>();
   
   public static void addAccount(String IBAN, String accountInfoPath){
       IBANDataBase.put(IBAN, accountInfoPath);
   }
   
   public static void transfer(String senderIBAN,String receiverIBAN,double amount) throws InsufficientFundsException, InvalidDepositAmountException{
       String senderAccountInfoPath = IBANDataBase.get(senderIBAN);
       String receiverAccountInfoPath = IBANDataBase.get(receiverIBAN);
       
       if(senderAccountInfoPath != null && receiverAccountInfoPath != null){
           CheckingAccount senderAccount = loadAccount(senderAccountInfoPath);
           CheckingAccount receiverAccount = loadAccount(receiverAccountInfoPath);
           
           senderAccount.EFTwithdraw(amount, receiverAccount.getHolderName());//WIP// I guess it's done
           receiverAccount.EFTdeposit(amount, senderAccount.getHolderName());//WIP// I guess it's done
           
           System.out.println("$"+amount+" succesfully transferred to "+receiverAccount.getHolderName());
       }
       else {
           System.out.println("IBAN not found. Please check the IBAN and try again.");// Will probably throw an exception IBANNotFoundException
       }
       
   }
   
   public static CheckingAccount loadAccount(String accountInfoPath){
       Customer customer; 
       String fullName;
      try {
        File accountInfoFile = new File(accountInfoPath);
        FileReader fileReader = new FileReader(accountInfoFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String accountType = bufferedReader.readLine();
            switch (accountType) {
            case "Checking Account":
                fullName = bufferedReader.readLine();
                String checkingIBAN = bufferedReader.readLine();
                double checkingBalance = Double.parseDouble(bufferedReader.readLine());
                customer = new Customer(fullName);
                CheckingAccount checkingAccount = new CheckingAccount(customer, checkingBalance, checkingIBAN, accountInfoPath, accountType);
                
                return checkingAccount;
                
            case "Overdraft Account":
                fullName = bufferedReader.readLine();
                String overdraftIBAN = bufferedReader.readLine();
                double overdraftBalance = Double.parseDouble(bufferedReader.readLine());
                double draftLimit = Double.parseDouble(bufferedReader.readLine());
                double draftLeft = Double.parseDouble(bufferedReader.readLine());
                customer = new Customer(fullName);
                OverdraftAccount overdraftAccount = new OverdraftAccount(customer, overdraftBalance, overdraftIBAN, accountInfoPath, accountType);
                overdraftAccount.draftLimit = draftLimit;
                overdraftAccount.draftLeft = draftLeft;
                
                return overdraftAccount;
                
            case "Savings Account":
                // WILL BE FILLED
                break;
            default:
                throw new IllegalArgumentException("Unknown account type: " + accountType);
                }
            } catch (Exception e) {
                e.getMessage();
            }
      return null;      
   }
   
   
   
   
   
   
   
}

