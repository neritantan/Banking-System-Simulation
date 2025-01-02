/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author enesi
 */
public class InvalidTCIDException extends Exception{
    String TCID;
    
    public InvalidTCIDException(String TCID) {
        this.TCID = TCID;
    }
    
    public String toString(){
    return ("Given TCID: "+TCID+" is invalid. Please make sure it's exatly 11 digits");
    }
}
