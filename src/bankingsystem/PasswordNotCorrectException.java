package bankingsystem;

/**
 *
 * @author enesi
 */
public class PasswordNotCorrectException extends Exception{
    @Override
    public String toString(){
        return ("Password is wrong.");
    }
}
