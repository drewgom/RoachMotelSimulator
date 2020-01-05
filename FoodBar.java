/* FoodBar.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public class FoodBar extends RoomWithAmenities {
    /**
     * Creates a new food bar
     * @param roomToBeDecorared the room that is getting decorated
     */
    FoodBar(Room roomToBeDecorared)   {
        super(roomToBeDecorared);
    }

    /**
     * gets the rate of the decorated room
     * @return the rate of the decorated room
     */
    @Override
    public double getRate() {
        return 10 + this.getBaseRoom().getRate();
    }

    /**
     * A string version of the decorated room
     * @return the string version of the decorated room
     */
    @Override
    public String toString() {
        return super.toString() + " WITH FOOD BAR";
    }
}
