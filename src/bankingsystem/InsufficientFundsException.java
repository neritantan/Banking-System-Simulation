package bankingsystem;

/**
 *
 * @author enesi
 */
public class InsufficientFundsException extends Exception{
    double balance;
    double amount;

    public InsufficientFundsException(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }
    
    @Override
    public String toString(){
        return ("Insufficient Funds!! You are trying to Withdraw $"+amount+" yet you have $"+balance+" in your account.");
    }
}
