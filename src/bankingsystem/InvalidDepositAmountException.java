package bankingsystem;

/**
 *
 * @author enesi
 */
public class InvalidDepositAmountException extends Exception{
    double amount;
    
    InvalidDepositAmountException(double amount){
        this.amount = amount;
    }
    
    @Override
    public String toString(){
        return ("Deposited amount "+amount+" is invalid. Please enter again.");
    }
}
