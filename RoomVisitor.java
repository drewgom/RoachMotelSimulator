/* RoomVisitor.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public interface RoomVisitor {
    /**
     * Visits a basic room
     * @param bRoom the basic room to be visited
     */
    void visit(BasicRoom bRoom);

    /**
     * Visits a deluxe room
     * @param dRoom the deluxe room to be visited
     */
    void visit(DeluxeRoom dRoom);

    /**
     * Visits a suite
     * @param sRoom the room to be visited
     */
    void visit(Suite sRoom);


}
