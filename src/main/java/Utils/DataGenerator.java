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


    public static void GenerateData()
    {
        User user = new User(1,"Mariusz","Lamprecht","ss@ss.pl","12345");
        rides.add(new Ride(1,"a","B",200,1,new Date(),3));
        rides.add(new Ride(2,"c","B",200,1,new Date(),1));
        rides.add(new Ride(3,"c","a",200,1,new Date(),2));


        User user2 = new User(2,"Mariusz","Lamprecht","123@123.pl","12345");
       // User user2 = new User(2,"Mariusz","Lamprecht","ss@ss.pl","12345",rides);

        users.add(user);
        users.add(user2);

        DataBase db = new DataBase(users, rides);
    }

}
