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

    public DataBase()
    {

    }

    public DataBase(List<User> users){
        this.users = users;
        DataManager.save(this);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
