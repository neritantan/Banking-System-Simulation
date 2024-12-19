/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author enesi
 */
public class Customer {
   private String firstName;
   private String lastName;
   private String TCID;
   
   public Customer(String firstName, String lastName, String TCID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.TCID = TCID;
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

    public String getTCID() {
        return TCID;
    }
   
    String customerInfo(){
        return "Name: "+firstName+"\nSurname: "+lastName+"\nTCID: "+TCID;
    }
   
}
