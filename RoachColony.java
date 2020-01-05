/* RoachColony.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

public class RoachColony implements Observer    {


    /**The name of the colony*/
    private String name;
    /**The population in the colony*/
    private int population;
    /**The growth rate of the colony*/
    private double growthRate;
    /**Payment method of the roach colony*/
    PaymentMethod payment;

    /** The preferences of the colony*/
    boolean prefersFoodBar;
    boolean prefersSpa;
    boolean prefersRefillBar;
    boolean prefersShower;


    //??? Should the roach colony have a payment method or should the
    //roach motel store a payment method when they check out
    //staring to think the roach colony should


    /**
     * Constructs a new Roach Colony
     * @param name			The name of the colony
     * @param population	The current population of the colony
     * @param growthRate	The growth rate  of the colony
     * @param payment		The payment method the colony uses
     */
    public RoachColony(String name, int population, double growthRate, PaymentMethod payment, boolean wantsFoodBar, boolean wantsSpa, boolean wantsRefillBar, boolean wantsShower)
    {
        this.name = name;
        this.population = population;
        this.growthRate = growthRate;
        this.payment = payment;
        this.prefersFoodBar = wantsFoodBar;
        this.prefersSpa = wantsSpa;
        this.prefersRefillBar = wantsRefillBar;
        this.prefersShower = wantsShower;
    }

    @Override
    public void update(RoachMotel r) {
        System.out.println("The colony "+ this.name + " was notified of a vacancy at " + r);


        r.checkIn(this);
    }

    /**
     * Population increases by the growth rate when we throw a party but also
     * the motel is notified to spray the room
     */
    public void throwParty()
    {
        System.out.println("The colony " + this + " is partying...");
        population = (int) (population + (population*growthRate));
        System.out.println("Their Population is increasing!! to " + this.population);
        RoachMotel motel = RoachMotel.getRoachMotel();
        motel.sprayRoom(this);

    }

    /**
     * Gets the information for the colony
     * @return the name and population of the colony
     */
    public String toString()
    {
        return "Roach Colony " + name + " Population: " + this.population;
    }


    public void decreasePopulation(double rate)
    {
        this.population = (int) (population - (population * rate));
        System.out.println("The Population of " + this + " was decreased by " + rate + " The new population is "+ population);
    }

}//ends roach colony
