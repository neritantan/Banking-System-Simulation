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
        System.out.print("First name: ");
        firstName = scanner.nextLine();
        System.out.print("\nLast name: ");
        lastName = scanner.nextLine();
        System.out.println("\n TCID: ");
        TCID = scanner.nextLine();
        
        Customer myCustomer = new Customer(firstName,lastName,TCID);
        
    }
}
