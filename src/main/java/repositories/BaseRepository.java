package repositories;

import Utils.DataBase;

/**
 * Created by Mariusz on 2016-02-07.
 */
public abstract class BaseRepository {

    private DataBase _dataBase;

    public BaseRepository(DataBase dataBase) {
        this._dataBase = dataBase;
    }

    public DataBase getDataBase()
    {
        return this._dataBase;
    }
}
