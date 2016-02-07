package models;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Mariusz on 2016-01-30.
 */

@XmlRootElement(name="Ride")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ride {

    @XmlAttribute
    private final int id;

    @XmlAttribute
    private final String from;

    @XmlAttribute
    private final String to;

    @XmlAttribute
    private final double price;

    @XmlElement
    private final User owner;

    @XmlAttribute
    private final Date date;

    @XmlAttribute
    private final int seats;

    @XmlElement(name="user")
    private List<User> users = null;

//    public static List<User> userss = new LinkedList<>();

    public Ride()
    {
        this.id = 1;
        this.from = "a";
        this.to = "b";
        this.price = 200;
        this.owner = null;
        this.date = new Date();
        this.seats = 3;
        this.users = null;
    }

    public Ride(int id, String from, String to, double price, User owner, Date date, int seats) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.owner = owner;
        this.date = date;
        this.seats = seats;

//        userss = new LinkedList<>();
//
//        userss.add(new User(1,"Mariusz","Lamprecht","ss@ss.pl","12345"));
//        userss.add(new User(1,"Mariusz","Lamprecht","ss@ss.pl","12345"));

        this.users = null;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getPrice() {
        return price;
    }

    public User getOwner() {
        return owner;
    }

    public Date getDate() {
        return date;
    }

    public int getSeats() {
        return seats;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
