/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;
import java.util.ArrayList;
/**
 *
 * @author enesi
 */
public class Customer {
   private String firstName;
   private String lastName;
   private String fullName;
   private String TCID;
   public ArrayList<CheckingAccount> accounts;
   
   
   public Customer(String firstName, String lastName, String TCID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.TCID = TCID;
        accounts = new ArrayList<>();
        fullName = (firstName+" "+lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTCID(String TCID) {
        this.TCID = TCID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getFullName(){
        return fullName;
    }
    public String getTCID() {
        return TCID;
    }
   
    public void addAccount(CheckingAccount checkingAccount){
        accounts.add(checkingAccount);
    }
    //Polymorphism
    //public void addAccount(OverdraftAccount overdraftAccount){
    //    accounts.add(overdraftAccount);
    //}
    String customerInfo(){
        return "Name: "+firstName+"\nSurname: "+lastName+"\nTCID: "+TCID;
    }
    
    double checkBalance(int accountOrder) {
    if (accountOrder < 0 || accountOrder >= accounts.size()) {
        throw new IllegalArgumentException("Invalid account order: " + accountOrder);
    }
    return accounts.get(accountOrder).getBalance();
}

    
    
   
}
