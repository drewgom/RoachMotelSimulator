/* MasterRoach.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public class MasterRoach implements PaymentMethod{

    /**The name of the master roach account holder*/
    private String name;
    /** The card number*/
    private String cardNumber;
    /**The experation date of master roach card*/
    private String expirationDate;
    /**The security code of master roach*/
    private String securityCode;


    /**
     * Constructs a new Roach Pal account
     * @param name				The name of the account holder
     * @param cardNumber 		The number on the account
     * @param expirationDate 	The date the card expires
     * @param securityCode		The security code on the account
     */
    public MasterRoach(String name, String cardNumber,String expirationDate,String securityCode)
    {
        this.name = name;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    /**
     * Charges the account
     * @param amount	The amount to charge
     */
    @Override
    public void charge(double amount) {
        System.out.println(" charged $" + amount);
    }

    /**
     * Returns a string representation of using the master roach
     */
    @Override
    public String toString()
    {
        return "MasterRoach: Name: " + this.name + " Card Number: " + this.cardNumber + " Expiration Date: " + this.expirationDate + " Security Code: "+ this.securityCode;
    }

}