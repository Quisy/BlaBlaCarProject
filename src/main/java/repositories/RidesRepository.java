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

    public synchronized List<Ride> Join(long id, String login)
    {
        getDataBase().getRides().stream().filter(r->r.getId()==id).findAny().get().getUsers().add(login);
        DataManager.save(getDataBase());
        return GetOrderedRides(login);
    }

    public synchronized List<Ride> Leave(long id, String login)
    {
        getDataBase().getRides().stream().filter(r->r.getId()==id).findAny().get().getUsers().remove(login);
        DataManager.save(getDataBase());
        return GetOrderedRides(login);
    }

    public List<Ride> GetOrderedRides(String login)
    {
        return getDataBase().getRides().stream().filter(r->r.getUsers().contains(login)).collect(Collectors.toList());
    }

    public synchronized void Add(Ride ride, String login)
    {
        long maxId = getDataBase().getRides().get(getDataBase().getRides().size() - 1).getId();
        User user = getDataBase().getUsers().stream().filter(u->u.getEmail().equals(login)).findAny().get();
        Ride newRide = new Ride(maxId+1,ride.getFrom(),ride.getTo(),ride.getPrice(), user, ride.getDate(), ride.getSeats());
        getDataBase().getRides().add(newRide);
        DataManager.save(getDataBase());
    }

    public synchronized void Delete(long id)
    {
        Ride ride = getDataBase().getRides().stream().filter(r->r.getId()==id).findAny().get();
        getDataBase().getRides().remove(ride);
        DataManager.save(getDataBase());
    }


}
