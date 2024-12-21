/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;

/**
 *
 * @author enesi
 */
public class Tester {
     public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
        Customer testCustomer = new Customer("Shrimp","Shrimpogullari","16489517645");
        CheckingAccount CA_Shrimp = new CheckingAccount(testCustomer);
        testCustomer.addAccount(CA_Shrimp);
        
        
        
        String accountFileName = ("customers/"+testCustomer.getTCID()+"/"+testCustomer.accounts.get(0).getIBAN()+"/accountInfo.txt");//Succesful
        File accountFile = new File(accountFileName);
        
        try{
            accountFile.createNewFile();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            FileWriter accountWriter = new FileWriter(accountFileName);
            accountWriter.write(testCustomer.accounts.get(0).displayAccountInfo());
            accountWriter.close();
        }
        catch (IOException e) {
            e.getMessage();
        }
     }
}
