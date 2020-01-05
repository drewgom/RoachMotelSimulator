/* Room.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public interface Room {
    /**
     * Gets the rate for staying in that room
     * @return The rate
     */
    double getRate();

    /**
     * Gets the current roach colony
     * @return The roach colony staying in that room
     */
    RoachColony getCurrentCustomer();

    /**
     * Runs the visitor command on the object
     * @param visitor A room visitor
     */
    void clean(RoomVisitor visitor);

    /**
     * gets the number of days someone has stayed
     * @return the number of days stayed
     */
    int getDaysStayed();

    /**
     * Increments the number of nights stayed
     */
    void incrementDaysStayed();

    /**
     * Removes the guest that is currently in the room
     */
    void removeGuest();

    /**
     * Changes the current guest in the room
     */
    void addCustomer(RoachColony r);

    /**
     * Checks if room has spray resistant showers
     * @return true if spray resistant showers
     */
    boolean hasSprayResistance();

    /**
     * get the room number
     * @return the room number
     */
    int getRoomNumber();

    /**
     * gets the status of the do not disturb
     * @return the status of the do not disturb
     */
    boolean getDoNotDisturbStatus();

    /**
     * sets the do not disturb status
     * @param newStatus the new status for the room
     */
    void setDoNotDisturbStatus(boolean newStatus);

    /**
     * Allows us to return just the non-decorated, conrete implementation of a room
     * @return the room without amenities
     */
    Room stripAmenities();
}
