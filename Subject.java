/* Subject.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public interface Subject {

    /**
     * Removes observer from subscribers
     */
    void notifyObservers();

    /**
     * Removes observer from subscribers
     */
    void addObserver(RoachColony colony);

    /**
     * Removes observer from subscribers
     */
    void removeObserver(RoachColony colony);

}
