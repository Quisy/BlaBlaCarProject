package repositories;

import Utils.DataBase;
import models.Ride;

import java.util.List;

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

}
