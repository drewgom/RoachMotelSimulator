package RoachMotel;

public class TermProjectRunner {

    public static void main(String[] args) {
        // Creates the motel
        Room[] hotelRooms = {
            RoomFactory.getRoom(RoomType.BASIC, null, 1),
            RoomFactory.getRoom(RoomType.DELUXE, null, 2),
            RoomFactory.getRoom(RoomType.BASIC, null, 3),
            RoomFactory.getRoom(RoomType.SUITE, null, 4),
            RoomFactory.getRoom(RoomType.SUITE, null, 5),
        };

	    RoachMotel motel = RoachMotel.getRoachMotel("New Roach Motel", hotelRooms);


	    // Creates some customers
        RoachColony[] colonies = {
            new RoachColony("ColonyA", 1000, 1.25, new MasterRoach("ColonyA","123 456","12/19","000"),true, true, true, true),
            new RoachColony("ColonyB", 10000, .6, new RoachPal("ColonyB", "colB@gmail.com"), true, false, false, true),
            new RoachColony("ColonyC", 200, .4, new MasterRoach("ColonyC","101 010","01/20","010"), false, false, false, false),
            new RoachColony("ColonyD", 500, .3, new RoachPal("ColonyD", "colD@csulb.edu"), false, false, false, true),
            new RoachColony("ColonyE", 100000, .1, new MasterRoach("ColonyE","444 444","04/24","444"), false, true, false, false),
            new RoachColony("ColonyF", 400, 1.5, new RoachPal("ColonyF", "colF@roach.com"), true, false, true, false),
            new RoachColony("ColonyG", 3000, 1.1, new MasterRoach("ColonyG","111 111","01/21","111"), false, true, false, true),
        };

        // Has some customers try to check in
        for (RoachColony colony : colonies) {
            motel.checkIn(colony);
        }

        motel.endOfDay();



        // Day 1:
        // ColonyA will throw a party
        // ColonyB will throw a party
        // ColonyC will check out
        System.out.println();
        System.out.println();
        System.out.println("DAY 1:");

        colonies[0].throwParty();
        colonies[1].throwParty();
        motel.checkOut(colonies[2]);

        motel.endOfDay();


        // Day 2:
        // ColonyA will throw a party
        // ColonyD will throw a party
        // ColonyB will check out
        // ColonyE will check out
        System.out.println();
        System.out.println();
        System.out.println("DAY 2:");

        colonies[0].throwParty();
        colonies[3].throwParty();
        motel.checkOut(colonies[1]);
        motel.checkOut(colonies[4]);

        motel.endOfDay();

        // Day 3:
        // ColonyA will throw a party
        // ColonyF will throw a party
        // ColonyA will check out
        System.out.println();
        System.out.println();
        System.out.println("DAY 3:");

        colonies[0].throwParty();
        colonies[5].throwParty();
        motel.checkOut(colonies[0]);

        motel.endOfDay();


        // Day 4:
        // Colony D will check out
        // Colony F will check out
        // Colony E will check out
        System.out.println();
        System.out.println();
        System.out.println("DAY 4:");

        motel.checkOut(colonies[3]);
        motel.checkOut(colonies[5]);
        motel.checkOut(colonies[6]);

        motel.endOfDay();



        // Displays the payments that outline the hotels activities
        System.out.println();
        System.out.println();
        System.out.println("TRANSACTION LOG:");

        PaymentLogger logger = PaymentLogger.getPaymentLogger();
        System.out.println(logger);
    }
}
