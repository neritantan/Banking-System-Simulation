/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;
import java.util.Scanner;
/**
 *
 * @author enesi
 */
public class OverdraftAccount extends Account{
    String accountType = "Overdraft Account";
    double draftLimit = 5000;
    double draftLeft;
    
    public OverdraftAccount(Customer holder) {
        super(holder);
        draftLeft = draftLimit;
    }
    
    public OverdraftAccount(Customer holder,double draftLimit){// Polymorphism
        super(holder);
        this.draftLimit = draftLimit;
        draftLeft = draftLimit;
    }
    
    public String displayAccountInfo(){
        return  ("Account Type: "+accountType
                +"\nHolder: "+super.getHolderName()
                + "\nIBAN: "+super.getIBAN()
                + "\nBalance: $"+super.getBalance()
                +"/n Draft Limit: ");
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
                System.out.println("You don't have enough balance to withdraw $"+amount+". Would you like to use cash advance to continue transaction?");
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
    
    public String accountInfo(){// This part will be written into accountInfo.txt
        
        return (accountType+"\n"
                +super.getHolderName()+"\n"
                +super.getIBAN()+"\n"
                +super.getBalance()+"\n"
                +draftLimit+"\n"
                +draftLeft);
    }
}
