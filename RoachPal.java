/* RoachPal.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public class RoachPal implements PaymentMethod {


    /**The email corresponding to roachpal account*/
    private String email;
    /**The name of the roachpal account holder*/
    private String name;

    /**
     * Constructs a new Roach Pal account
     * @param name		The name of the account holder
     * @param email		The email address associated with the account
     */
    public RoachPal(String name, String email)
    {
        this.email = email;
        this.name = name;
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
     * Gets the information from the roach pay account
     * @return the information from the account
     */
    @Override
    public String toString()
    {
        return "RoachPal: Name: " + this.name + " Email :" + this.email;
    }


}//ends roach pal class
