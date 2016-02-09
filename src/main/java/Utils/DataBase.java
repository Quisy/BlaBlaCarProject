package Utils;

import models.Ride;
import models.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Mariusz on 2016-01-30.
 */

@XmlRootElement(name = "DataBase")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataBase {

    @XmlElement(name = "User")
    private List<User> users;
    @XmlElement(name = "Ride")
    private List<Ride> rides;

    public DataBase()
    {

    }

    public DataBase(List<User> users, List<Ride> rides){
        this.users = users;
        this.rides = rides;
        DataManager.save(this);
    }



    public List<User> getUsers()
    {
        return users;
    }

    public List<Ride> getRides()
    {
        return this.rides;
    }

}
