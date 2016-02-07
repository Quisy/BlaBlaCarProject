package models;


import javax.xml.bind.annotation.*;
import java.util.List;


/**
 * Created by Mariusz on 2016-01-30.
 */

@XmlRootElement(name="User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlAttribute
    private final int id;

    @XmlAttribute
    private final String firstName;

    @XmlAttribute
    private final String lastName;

    @XmlAttribute
    private final String email;

    @XmlAttribute
    private final String password;

    @XmlElement(name="Ride")
    private List<Ride> rides = null;

    public User() {
        this.id = 1;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.rides = null;
    }

    public User(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rides = null;
    }

    public User(int id, String firstName, String lastName, String email, String password, List<Ride> rides) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rides = rides;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Ride> getRides() {
        return this.rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
