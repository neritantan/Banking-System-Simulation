package bankingsystem;

/**
 *
 * @author enesi
 */
public class CustomerNotFoundException extends Exception{
    private String TCID;

    public CustomerNotFoundException(String TCID) {
        this.TCID = TCID;
    }
    
    @Override
    public String toString(){
        return ("Customer with TCID:"+this.TCID+" not found in the database.");
    }
}
