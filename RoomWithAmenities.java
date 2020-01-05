/* RoomWithAmenities.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

abstract public class RoomWithAmenities implements Room {
    private Room baseRoom;

    /**
     * Creates a new decorated room where the base room is the previous room to be called on
     * @param prevRoom the room that is being decorated
     */
    RoomWithAmenities(Room prevRoom) {
        baseRoom = prevRoom;
    }

    /**
     * Gets the current roach colony
     * @return The roach colony staying in that room
     */
    @Override
    public RoachColony getCurrentCustomer() {
        return baseRoom.getCurrentCustomer();
    }

    /**
     * Runs the visitor command on the object
     * @param visitor A room visitor
     */
    @Override
    public void clean(RoomVisitor visitor) {
        baseRoom.clean(visitor);
    }

    /**
     * Gets the number of days someone has stayed
     * @return daysStayed
     */
    @Override
    public int getDaysStayed() {
        return baseRoom.getDaysStayed();
    }


    /**
     * Gets the base room of the current object
     * @return the base room
     */
    public Room getBaseRoom()   {
        return baseRoom;
    }
    /**
     * Increments the number of nights stayed
     */
    @Override
    public void incrementDaysStayed()  {
        baseRoom.incrementDaysStayed();
    }

    /**
     * Returns a string version of the object
     * @return the string version of the object
     */
    @Override
    public String toString() {
        return baseRoom.toString();
    }

    /**
     * Removes current guest from the room
     */
    public void removeGuest()
    {
        baseRoom.removeGuest();
    }

    /**
     * Changes the current guest in the room
     */
    public void addCustomer(RoachColony r)
    {
        baseRoom.addCustomer(r);
    }

    /**
     * gets the roomNumber
     * @return roomNumber
     */
    @Override
    public int getRoomNumber() {
        return baseRoom.getRoomNumber();
    }

    /**
     * Checks if room has spray resistant showers
     * @return true if spray resistant showers
     */
    public boolean hasSprayResistance()
    {
        boolean answer = false;
        if (this instanceof SprayResistantShower)
        {
            answer =  true;
        }
        else
        {
            answer =  baseRoom.hasSprayResistance();
        }
        return answer;
    }

    /**
     * gets the status of the do not disturb
     * @return the status of the do not disturb
     */
    @Override
    public boolean getDoNotDisturbStatus() {
        return baseRoom.getDoNotDisturbStatus();
    }

    /**
     * sets the do not disturb status
     * @param newStatus the new status for the room
     */
    @Override
    public void setDoNotDisturbStatus(boolean newStatus)    {
        baseRoom.setDoNotDisturbStatus(newStatus);
    }

    /**
     * Allows us to return just the non-decorated, concrete implementation of a room
     * @return the room without amenities
     */
    @Override
    public Room stripAmenities()   { return baseRoom.stripAmenities();}
}