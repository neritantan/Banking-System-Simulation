/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author enesi
 */
public class CheckingAccount extends Account{
    String accountType = "Checking Account";
    public CheckingAccount(String holder, String IBAN) {
        super(holder, IBAN);
    }
    public CheckingAccount(String holder) {
        super(holder);
    }
    
    public String displayAccountInfo(){
        return ("\nHolder: "+super.getHolder()
                + "\nIBAN: "+super.getIBAN()
                + "\nBalance: $"+super.getBalance());
    }
    
}
