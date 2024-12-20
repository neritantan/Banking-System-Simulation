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
public class Main {
    public static void main(String[] args){ //WORK IN PROGRESS
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        String TCID;
        /////////////////////////////////////////////
        //System.out.print("First name: ");
        //firstName = scanner.nextLine();
        //System.out.print("Last name: ");
        //lastName = scanner.nextLine();
        //System.out.print("TCID: ");
        //TCID = scanner.nextLine();
        
        Customer myCustomer = new Customer("Jumbo","Keykavuz","16589118546");
        CheckingAccount newAc = new CheckingAccount(myCustomer.getFullName(),"TR12 3456 7890 1234 5678 9012 34");
        myCustomer.addAccount(newAc);
        System.out.printf("Your balance is $%.2f\n",myCustomer.checkBalance(0));
        myCustomer.accounts.get(0).deposit(500);
        System.out.printf("Your balance is $%.2f\n",myCustomer.checkBalance(0));
        try{
            myCustomer.accounts.get(0).withdraw(125.48);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        System.out.printf("Your balance is $%.2f\n",myCustomer.checkBalance(0));
        ///////////////////////////////////////////////////
        Customer testCustomer = new Customer("Shrimp","Shrimpogullari","58430291746");
        CheckingAccount CA_Shrimp = new CheckingAccount(testCustomer.getFullName());
        testCustomer.addAccount(CA_Shrimp);
        testCustomer.accounts.get(0).deposit(16.08);
        System.out.println(testCustomer.accounts.get(0).displayAccountInfo());
    }
}
