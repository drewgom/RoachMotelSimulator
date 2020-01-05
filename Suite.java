/* Suite.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public class Suite extends AbstractRoom {
    /**
     * Allows us to create a new Suite object
     * @param newCustomer the new customer for the suite
     */
    Suite(RoachColony newCustomer, int roomNum) {
        super(newCustomer, roomNum);
    }

    /**
     * Takes in the room visitor, and passes in the current method
     * @param visitor A room visitor
     */
    @Override
    public void clean(RoomVisitor visitor) {
        System.out.println("Cleaning " + this.toString());
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return super.toString() + "SUITE, CUSTOMER: " + getCurrentCustomer();
    }
}
