/* RoomFactory.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public class RoomFactory {
    public static AbstractRoom getRoom(RoomType type, RoachColony customer, int roomNum)    {
        switch (type)  {
            case BASIC:
                return new BasicRoom(customer, roomNum);
            case DELUXE:
                return new DeluxeRoom(customer, roomNum);
            case SUITE:
                return new Suite(customer, roomNum);
            default:
                return new BasicRoom(customer, roomNum);
        }
    }
}
