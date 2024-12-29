/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author enesi
 */
public class Customer {
   private String firstName;
   private String lastName;
   private String fullName;
   private String TCID;
   private String password;
   public ArrayList<CheckingAccount> accounts;
   
   
   public Customer(String firstName, String lastName, String TCID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.TCID = TCID;              //WILL going to check if it's 11 characters by TCID.len(); and if not will throw an exception.
        accounts = new ArrayList<>();
        fullName = (firstName+" "+lastName);
        createCustomer();
        System.out.println("Registered Succesfully!!");// WILL BE A POP-UP WINDOW if no exception
    }
   
   public Customer(String firstName, String lastName, String TCID, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.TCID = TCID;              //WILL going to check if it's 11 characters by TCID.len(); and if not will throw an exception.
        this.password = password;
        accounts = new ArrayList<>();
        fullName = (firstName+" "+lastName);
        createCustomer();
        System.out.println("Registered Succesfully!!");// WILL BE A POP-UP WINDOW if no exception
    }
   
   
   
   public void createCustomer(){
       String customerFolderName = ("customers/"+this.TCID);
       File customerFolder = new File(customerFolderName);
       if(!customerFolder.exists())
          customerFolder.mkdir();
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

    public String getPassword() {
        return password;
    }
    
    
   
    public void addAccount(CheckingAccount checkingAccount){
        accounts.add(checkingAccount);
    }
    //Polymorphism
//    public void addAccount(OverdraftAccount overdraftAccount){
//        accounts.add(overdraftAccount);
//    }
//     public void addAccount(SavingsAccount savingsAccount){
//        accounts.add(savingsAccount);
//    }
    
    public void createCustomerInfoFile(){// SHOULD BE CALLED AT THE END OF THE PROGRAM!!!!
        File customerinfoFile = new File("customers/"+getTCID()+"/customerInfo.txt");
        try{
            FileWriter fileWriter = new FileWriter(customerinfoFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(customerDetails());
            bufferedWriter.close();
            fileWriter.close();
            
        }
        catch(IOException e){
            e.getMessage();
            System.out.println("There was an error occured during CustomerInfo saving process.");
        }

        
        
       
    }
    String customerInfo(){
        return "Name: "+firstName+"\nSurname: "+lastName+"\nTCID: "+TCID;
    }
    
    private String customerDetails(){
        String details = (getFirstName()+"\n"+
                          getLastName()+"\n"+
                          getPassword()+"\n");
        for(int i =0 ;i < accounts.size();i++){
          details +=  accounts.get(i).getIBAN()+"\n";
        }
        return details;
    }
    
    double checkBalance(int accountOrder) {
    if (accountOrder < 0 || accountOrder >= accounts.size()) {
        throw new IllegalArgumentException("Invalid account order: " + accountOrder);
    }
    return accounts.get(accountOrder).getBalance();
}

    
    
   
}
