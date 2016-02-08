package repositories;

import Utils.DataBase;
import Utils.DataManager;
import models.Ride;
import models.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mariusz on 2016-02-07.
 */
public class RidesRepository extends BaseRepository {

    public RidesRepository(DataBase dataBase)
    {
        super(dataBase);
    }


    public List<Ride> GetAll()
    {
        return getDataBase().getRides();
    }

    public List<Ride> GetByUser(String login)
    {
        return getDataBase().getRides().stream().filter(r->r.getOwner().getEmail().equals(login)).collect(Collectors.toList());
    }

    public List<Ride> Join(long id, String login)
    {
        User user = getDataBase().getUsers().stream().filter(u->u.getEmail().equals(login)).findAny().get();
        getDataBase().getRides().stream().filter(r->r.getId()==id).findAny().get().getUsers().add(login);
        DataManager.save(getDataBase());
        return GetOrderedRides(login);
    }

    public List<Ride> Leave(long id, String login)
    {
        User user = getDataBase().getUsers().stream().filter(u->u.getEmail().equals(login)).findAny().get();
        getDataBase().getRides().stream().filter(r->r.getId()==id).findAny().get().getUsers().remove(login);
        DataManager.save(getDataBase());
        return GetOrderedRides(login);
    }

    public List<Ride> GetOrderedRides(String login)
    {
        User user = getDataBase().getUsers().stream().filter(u->u.getEmail().equals(login)).findAny().get();
        List<Ride> rides = getDataBase().getRides().stream().filter(r->r.getUsers().contains(login)).collect(Collectors.toList());
        return rides;
    }


}
