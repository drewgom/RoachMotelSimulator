/* RoomCleaningVisitor.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public class RoomCleaningVisitor implements RoomVisitor{

    /**
     * Visits a basic room
     * @param bRoom the basic room to be visited
     */
    @Override
    public void visit(BasicRoom bRoom) {
        System.out.println("The towels on the floor have been replaced");
    }

    /**
     * Visits a deluxe room
     * @param dRoom the deluxe room to be visited
     */
    @Override
    public void visit(DeluxeRoom dRoom) {
        System.out.println("All towels have been replaced");

    }

    /**
     * Visits a suite
     * @param sRoom the room to be visited
     */
    @Override
    public void visit(Suite sRoom) {
        System.out.println("All towels have been replaced");
        System.out.println("A hamburger has been placed on the pillow");
    }
}
