/* Spa.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public class Spa extends RoomWithAmenities {
    /**
     * Creates a new food bar
     * @param roomToBeDecorared the room that is getting decorated
     */
    Spa(Room roomToBeDecorared)   {
        super(roomToBeDecorared);
    }

    /**
     * gets the rate of the decorated room
     * @return the rate of the decorated room
     */
    @Override
    public double getRate() {
        return 20 + this.getBaseRoom().getRate();
    }

    /**
     * A string version of the decorated room
     * @return the string version of the decorated room
     */
    @Override
    public String toString() {
        return super.toString() + " WITH SPA";
    }
}
