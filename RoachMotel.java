/* RoachMotel.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Simulates a roach motel where roach colonies can check into the rooms
 * Is a singleton Class, there is only one instance
 */
public class RoachMotel implements Subject  {

    /**The one and only instance of roach motel*/
    private volatile static RoachMotel roachMotel = null;
    /**The name of the motel*/
    private String name;
    /**The capacity: number of rooms*/
    private int capacity;
    /**Determines if there are vacancies*/
    private boolean vacancy;
    /**All of the rooms*/
    Room[] rooms;
    /**The roach colonies on the waiting list*/
    ArrayList<RoachColony> waitList = new ArrayList<>();



    /**
     * Default constructor
     */
    private RoachMotel() {
        this.name = "Roach Motel";
        this.capacity = 5;
        this.vacancy = true;
        roachMotel = this;
        rooms = new Room[5];
        rooms[0] = RoomFactory.getRoom(RoomType.BASIC, null, 1);
        rooms[1] = RoomFactory.getRoom(RoomType.DELUXE, null, 2);
        rooms[2] = RoomFactory.getRoom(RoomType.BASIC, null, 3);
        rooms[3] = RoomFactory.getRoom(RoomType.SUITE, null, 4);
        rooms[4] = RoomFactory.getRoom(RoomType.SUITE, null, 5);
    }//ends constructor

    /**
     * The constructor that takes in arguments
     */
    private RoachMotel(String n, Room[] r)  {
        this.name = n;
        this.capacity = r.length;
        this.vacancy = true;
        rooms = r;
        roachMotel = this;
    }//ends constructor




    /**
     * Gets the only instance of roach motel, and takes in arguments
     * to construct the roach motel if it is hasn't been made yet
     * @return the roach motel
     */
    public static RoachMotel getRoachMotel(String n, Room[] r)
    {
        if (roachMotel == null)
        {
            synchronized (RoachMotel.class)
            {
                if (roachMotel == null)
                {
                    RoachMotel.roachMotel = new RoachMotel(n,r);
                }
            }
        }
        return roachMotel;

    }//ends get roach motel

    /**
     * gets the only instance of roach motel
     * @return the roach motel
     */
    public static RoachMotel getRoachMotel()
    {
        if (roachMotel == null)
        {
            synchronized (RoachMotel.class)
            {
                if (roachMotel == null)
                {
                    RoachMotel.roachMotel = new RoachMotel();
                }
            }
        }
        return roachMotel;

    }//ends get roach motel

    /**
     * Checks the roach colony into the hotel, if they arent checked in, they get added to wait list
     * @param colony
     */
    public void checkIn(RoachColony colony)
    {
        if (vacancy)
        {
            //check in roach colony by adding them to a room
            boolean foundRoom = false;
            for (int i = 0; i < rooms.length;i++)
            {
                if (rooms[i].getCurrentCustomer()==null && !foundRoom)
                {
                    foundRoom = true;
                    rooms[i].addCustomer(colony);
                    rooms[i] = setAmenities(rooms[i],colony.prefersFoodBar, colony.prefersSpa, colony.prefersRefillBar, colony.prefersShower);
                    System.out.println(colony.toString() + " checked into " + this.toString() + " Room Number " + rooms[i].getRoomNumber());

                    if(waitList.contains(colony))   {
                        this.removeObserver(colony);
                    }
                }

            }

            if (!foundRoom)
            {
                vacancy = false;
            }//if there are no rooms we update the vacancy sign at hotel

        }//ends if vacancy
        if (!vacancy)
        {
            if (!waitList.contains(colony)) {
                System.out.println("There is no vacancy we added " + colony + " to the wait list");
                //if we cant check them in, we will add them to wait list
                this.addObserver(colony);
            }
        }




    }

    public void checkOut(RoachColony colony)
    {
        Room roachesRoom = null;
        for (Room room : rooms)
        {
            if (room.getCurrentCustomer()==colony)
            {
                roachesRoom = room;
            }
        }


        double chargeAmount = roachesRoom.getRate() * roachesRoom.getDaysStayed();
        System.out.println(colony.toString() + " is checking out - paying with: "  + colony.payment.toString());
        colony.payment.charge(chargeAmount);
        PaymentLogger logger = PaymentLogger.getPaymentLogger();
        logger.writeToLogger(chargeAmount,colony.payment);

        roachesRoom.removeGuest();
        RoomCleaningVisitor maid = new RoomCleaningVisitor();
        roachesRoom.clean(maid);
        vacancy = true;

        // we use the roach colonys payment method to charge them
        //we will need to know how many days they stayed
        //We will clean their room
        //When someone checks out we notify the waitlist of a vacancy
        this.notifyObservers();
    }


    /**
     * Gets the name of the Motel
     * @return  String  the name of Motel
     */
    @Override
    public String toString()
    {
        return name;
    }


    /**
     * Allows the user to set the amenities in a room
     * @param roomToBeCustomized the room that is going to get amenities
     * @param getFoodBar a boolean to represent if the user wants a food bar
     * @param getSpa a boolean to represent if the user wants a spa
     * @param getRefillBar a boolean to represent if the user wants a refill bar
     * @param getShower a boolean to represent if the user wants a spray resistant shower
     */
    private Room setAmenities(Room roomToBeCustomized, boolean getFoodBar, boolean getSpa, boolean getRefillBar, boolean getShower)    {
        if(getFoodBar)  {
            roomToBeCustomized = new FoodBar(roomToBeCustomized);
        }

        if(getSpa)  {
            roomToBeCustomized = new Spa(roomToBeCustomized);
        }

        if(getRefillBar)  {
            roomToBeCustomized = new RefillBar(roomToBeCustomized);
        }

        if(getShower)  {
            roomToBeCustomized = new SprayResistantShower(roomToBeCustomized);
        }
        return roomToBeCustomized;
    }

    /**
     * Notifies those on the wait list of a vacancy
     */
    public void notifyObservers()
    {
        Iterator<RoachColony> iter = waitList.iterator();
        if (waitList.size() == 1) {
                iter.next().update(roachMotel);
        }
        else if (waitList.size() > 1) {
            while(iter.hasNext())   {
                iter.next().update(roachMotel);
            }
        }
    }//ends notify observers


    // The problem is that colony gets modified, thus altering the waitlist, while it is being iterated over
    // Even if it is added, it should wait until the end of the notifications to remove it from the waitlist
    public void endOfDay()
    {
        System.out.println("End of the day");
        for (Room room : rooms)
        {
            room.incrementDaysStayed();
            if (!room.getDoNotDisturbStatus()) {
                room.clean(new RoomCleaningVisitor());
            }
        }
    }

    /**
     * Sprays the room
     * @param colony The colony whose room to spray
     */
    public void sprayRoom(RoachColony colony)
    {

        System.out.println("Spraying the room of " + colony);
        //go through rooms to find colony and spray
        Room roachesRoom = null;
        for (Room room : rooms)
        {
            if (room.getCurrentCustomer()==colony)
            {
                roachesRoom = room;
            }
        }



        if (roachesRoom.hasSprayResistance())
        {
            System.out.println("The room has spray resistant showers");
            colony.decreasePopulation(.25);
        }
        else
        {
            System.out.println("The room does not have spray resistant showers");
            colony.decreasePopulation(.5);
        }
        //need to know if the room has a decorator

    }

    /**
     * Determine if there is a vacancy at the motel
     * @return true if there is availability
     */
    public boolean vacancy()
    {
        return vacancy;
    }

    /**Adds a roach colony to the wait list*/
    @Override
    public void addObserver(RoachColony colony) {
        waitList.add(colony);
    }


    /**Removes a roach colony from wait list*/
    @Override
    public void removeObserver(RoachColony colony) {
        waitList.remove(colony);
    }

}//ends roach motel class