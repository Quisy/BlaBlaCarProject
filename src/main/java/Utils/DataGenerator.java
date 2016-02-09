package Utils;

import models.Ride;
import models.User;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mariusz on 2016-01-30.
 */
public class DataGenerator {

    public static final List<Ride> rides = new LinkedList<>();
    public static final List<User> users = new LinkedList<>();


    public static void GenerateData() {
        User user = new User(1, "Mariusz", "Lamprecht", "mar@lam.pl", "12345");
        User user2 = new User(2, "Jan", "Kowalski", "jan@jan.pl", "qwerty");


        rides.add(new Ride(1, "Warszawa", "Poznań", 100, user, new Date(), 2));
        rides.add(new Ride(2, "Poznań", "Wrocław", 25, user, new Date(), 3));
        rides.add(new Ride(3, "Wrocław", "Kraków", 40, user, new Date(), 3));
        rides.add(new Ride(4, "Kraków", "Warszawa", 60, user, new Date(), 1));

        rides.add(new Ride(5, "Wrocław", "Kraków", 50, user2, new Date(), 3));
        rides.add(new Ride(6, "Kraków", "Gdańsk", 100, user2, new Date(), 2));
        rides.add(new Ride(7, "Gdańsk", "Płock", 15, user2, new Date(), 4));
        rides.add(new Ride(8, "Płock", "Łódź", 50, user2, new Date(), 2));

        users.add(user);
        users.add(user2);

        new DataBase(users, rides);
    }

}
