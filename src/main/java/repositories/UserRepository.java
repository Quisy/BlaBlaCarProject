package repositories;

import Utils.DataBase;
import models.User;

/**
 * Created by Mariusz on 2016-02-08.
 */
public class UserRepository extends BaseRepository {

    public UserRepository(DataBase dataBase){
        super(dataBase);
    }

    public boolean Login(String login, String password)
    {
        User result = getDataBase().getUsers().stream().filter(u->u.getEmail().equals(login) && u.getPassword().equals(password)).findAny().get();

        return (result!=null);
    }
}
