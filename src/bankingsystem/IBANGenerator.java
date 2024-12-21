/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;
import java.util.Random;
/**
 *
 * @author enesi
 */
public class IBANGenerator {
    String IBAN = "TRXX 0001 ZZZZ ZZZZ ZZZZ ZZZZ ZZ"; ///Example IBAN
    
    String generate(){
        
    Random rand = new Random();
    int TWOdigitrand_1 = rand.nextInt(100);
    int TWOdigitrand_2 = rand.nextInt(100);
    int FOURdigitrand_1 = rand.nextInt(10000);
    int FOURdigitrand_2 = rand.nextInt(10000);
    int FOURdigitrand_3 = rand.nextInt(10000);
    int FOURdigitrand_4 = rand.nextInt(10000);
    
    IBAN =("TR"+TWOdigitrand_1+" "+FOURdigitrand_1+" "+FOURdigitrand_2+" "+FOURdigitrand_3+" "+FOURdigitrand_4+" "+TWOdigitrand_2);
    
    return IBAN;
}
}