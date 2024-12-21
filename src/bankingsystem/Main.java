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
        String yesno;
        int choice;
        
        System.out.println("Welcome, In order to register please fill out the following boxes.");
         System.out.print("First Name: ");
         String firstName = scanner.nextLine();
         System.out.print("Last Name: ");
         String lastName = scanner.nextLine();
         System.out.print("TCID: ");
         String TCID = scanner.nextLine();
         Customer customer = new Customer(firstName,lastName,TCID);
         
         do{
             
         System.out.println("\nWhich type of account you want to create?");
         System.out.println("1- Checking Account");
         System.out.println("2- Overdraft Account");
         System.out.println("3- Savings Account");
         choice = scanner.nextInt();
         scanner.nextLine();
         
         switch (choice){
             case 1:// hehehee~~
                 CheckingAccount account = new CheckingAccount(customer);
                 customer.accounts.add(account);
                 break;
             default:
                 break;
         }
         
         System.out.println("Do you want to create another account? (y/n)");
         yesno = scanner.nextLine();
         }while(!yesno.equals("n"));
         
         System.out.println("Ok then, BYEEE!!!!");
         
    }
}
