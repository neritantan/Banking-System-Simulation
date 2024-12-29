/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
