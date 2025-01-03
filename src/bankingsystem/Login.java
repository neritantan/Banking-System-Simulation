/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;

/**
 *
 * @author enesi
 */
public class Login {
    private String firstName;
    private String lastName;
    private String TCID;
    private String Password;
    private String realPassword;
    private Customer loggedCustomer;
    private String IBANs[]; 
    
    public Login(String TCID, String Password) throws CustomerNotFoundException, PasswordNotCorrectException{
        this.TCID = TCID;
        this.Password = Password;
        try {
             AccountLogin();
        }
       catch(Exception e){
           //System.out.println(e.toString());
           throw e;
       }
    }
    
    private void AccountLogin() throws CustomerNotFoundException, PasswordNotCorrectException{
        if(isCustomerExist()){
            if(isPasswordCorrect()){
                System.out.println("Login Succesful.");
                loggedCustomer = createCustomerFromFile();
                
            }
            else{
                throw new PasswordNotCorrectException();
            }
        }
        else{
            throw new CustomerNotFoundException(TCID);
        }
    }
    
    private boolean isCustomerExist() throws CustomerNotFoundException{
        File file = new File("customers/"+TCID);
        if(file.exists())
            return true;
        else
            return false;
    }
    
    private boolean isPasswordCorrect() throws PasswordNotCorrectException{
        File file = new File("customers/"+TCID+"/customerInfo.txt");
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            for (int i = 0; i < 2; i++) {
                bufferedReader.readLine();
            }
            realPassword = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
           
                    
        }
        catch(Exception e){
            e.getMessage();
        }
        if(Password.equals(realPassword))
                return true;
            else
                return false;
        
    }
    
    private Customer createCustomerFromFile(){
        File customerInfoFile = new File("customers/"+TCID+"/customerInfo.txt");
        int NumberOfAccounts =0;
        
        try{
            FileReader fileReader = new FileReader(customerInfoFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
        
        firstName = bufferedReader.readLine();
        lastName = bufferedReader.readLine();
        realPassword = bufferedReader.readLine();
        
        Customer customer = new Customer(firstName, lastName, TCID, realPassword);//Customer got created
        loggedCustomer = customer;
        
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            NumberOfAccounts++;
        }
        bufferedReader.close();
        }
        catch(Exception e){
            e.getMessage();
        }
        
        IBANs = new String[NumberOfAccounts]; // We've learned how many accounts this customer has.
        
        try{
            
            FileReader fileReader = new FileReader(customerInfoFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
        for (int i = 0; i < 3+NumberOfAccounts; i++) {
                if(i<3){
                    bufferedReader.readLine();
                }
                else{
                    IBANs[i-3]= bufferedReader.readLine();
                }
            }
            
        
        bufferedReader.close();
        }
        catch(Exception e){
            e.getMessage();
        }
        String accountInfoPath;
        for (int i = 0; i < NumberOfAccounts; i++) {
            accountInfoPath = ("customers/"+TCID+"/"+IBANs[i]+"/accountInfo.txt");
            try{
                File accountInfoFile = new File(accountInfoPath);
                FileReader fileReader = new FileReader(accountInfoFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                
                String accountType = bufferedReader.readLine();
                
                if(accountType.equals("Checking Account")){
                    bufferedReader.readLine();
                    String IBAN = bufferedReader.readLine();
                    double balance = Double.parseDouble(bufferedReader.readLine());
                    
                    CheckingAccount checkingAccount = new CheckingAccount(loggedCustomer, balance, IBAN, accountInfoPath, accountType);
                    loggedCustomer.accounts.add(checkingAccount);
                }
                else if(accountType.equals("Overdraft Account")){
                    bufferedReader.readLine();
                    String IBAN = bufferedReader.readLine();
                    double balance = Double.parseDouble(bufferedReader.readLine());
                    double draftLimit = Double.parseDouble(bufferedReader.readLine());
                    double draftLeft = Double.parseDouble(bufferedReader.readLine());
                    OverdraftAccount overdraftAccount = new OverdraftAccount(loggedCustomer, balance, IBAN, accountInfoPath, accountType ,draftLimit, draftLeft);
                    overdraftAccount.draftLimit = draftLimit;//Probably Unused
                    overdraftAccount.draftLeft = draftLeft;//Probably Unused
                    loggedCustomer.accounts.add(overdraftAccount);
                }
                else if (accountType.equals("Savings Account")) {
                try {
                    bufferedReader.readLine(); // Skip one line
                    String savingsIBAN = bufferedReader.readLine();
                    double savingsBalance = Double.parseDouble(bufferedReader.readLine());
                    double interestRate = Double.parseDouble(bufferedReader.readLine());
                    double investedAmount = Double.parseDouble(bufferedReader.readLine());
                    double savingsSavingsBalance = Double.parseDouble(bufferedReader.readLine());

                   
                    String dateStr = bufferedReader.readLine();
                    LocalDate investmentDate = null;
                    if (dateStr != null && !dateStr.equals("null") && !dateStr.trim().isEmpty()) {//
                        investmentDate = LocalDate.parse(dateStr);                                // NULL CHECK
                    }                                                                             //  
                    LocalDate currentDay = LocalDate.now();

                    System.out.println("Creating Savings Account with IBAN: " + savingsIBAN); 

                    SavingsAccount savingsAccount = new SavingsAccount(loggedCustomer, 
                                                                     savingsBalance, 
                                                                     savingsIBAN,
                                                                     accountInfoPath, 
                                                                     accountType, 
                                                                     interestRate,
                                                                     investedAmount, 
                                                                     savingsSavingsBalance, 
                                                                     investmentDate,  
                                                                     currentDay);
                    loggedCustomer.accounts.add(savingsAccount);
                    System.out.println("Savings Account added successfully"); 
                } catch (Exception e) {
                    System.out.println("Error creating Savings Account: " + e.getMessage());
                    e.printStackTrace();
                }
            }
                
            }catch(Exception e){
                e.getMessage();
            }
            
        }
        
        return loggedCustomer;
        // Double for loop first one for creating accounts second for adding or just one
        // for içinde ibanla dosyaya gir oku ve ekle direkt
        
        
        
       
        
    }

    public Customer getLoggedCustomer() {
        return loggedCustomer;
    }
    
    
}
