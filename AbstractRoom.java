/* AbstractRoom.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;


abstract public class AbstractRoom implements Room {
    private int roomNumber;
    private int daysStayed;
    private double rate;
    private RoachColony currentCustomer;
    private boolean doNotDisturb;




    /**
     * The abstract constructor for the room
     * @param newCustomer the customer staying in the room
     */

    AbstractRoom(RoachColony newCustomer, int roomNum)  {
        daysStayed = 0;
        rate = 100;
        roomNumber = roomNum;
        currentCustomer = newCustomer;
        doNotDisturb = false;
    }

    /**
     * Gets the rate for staying in that room
     * @return The rate
     */
    @Override
    public double getRate() {
        return rate;
    }


    /**
     * Sets the new rate
     * @param newRate the updated rate for a room
     */
    public void setRate(double newRate) {
        rate = newRate;
    }

    /**
     * Gets the current tenant
     * @return the current tenant
     */
    @Override
    public RoachColony getCurrentCustomer() {
        return currentCustomer;
    }


    /**
     * Increments the number of nights stayed
     */
    public void incrementDaysStayed()   {
        daysStayed += 1;
    }

    /**
     * Gets the number of days someone has stayed
     * @return daysStayed
     */
    public int getDaysStayed()  {
        return daysStayed;
    }

    /**
     * Gets the Room Number
     * @return roomNumber
     */
    @Override
    public int getRoomNumber()  {
        return  roomNumber;
    }

    /**
     * Returns a string version of the object
     * @return the string version of the object
     */
    @Override
    public String toString() {
        return "ROOM #: " + roomNumber + " ROOM TYPE: ";
    }

    /**
     * Removes current guest from the room
     */
    public void removeGuest()
    {
        currentCustomer = null;
    }

    /**
     * Changes the current guest in the room
     */
    public void addCustomer(RoachColony r)
    {
        currentCustomer = r;
    }

    /**
     * Checks if room has spray resistant showers
     * @return true if spray resistant showers
     */
    public boolean hasSprayResistance()
    {
        return false;
    }

    /**
     * gets the status of the do not disturb
     * @return the status of the do not disturb
     */
    @Override
    public boolean getDoNotDisturbStatus() {
        return doNotDisturb;
    }

    /**
     * sets the do not disturb status
     * @param newStatus the new status for the room
     */
    @Override
    public void setDoNotDisturbStatus(boolean newStatus)    {
        doNotDisturb = newStatus;
    }


    /**
     * Allows us to return just the non-decorated, concrete implementation of a room
     * @return the room without amenities
     */
    @Override
    public Room stripAmenities()   { return this;}
}
