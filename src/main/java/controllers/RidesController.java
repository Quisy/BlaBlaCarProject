package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import repositories.RidesRepository;

/**
 * Created by Mariusz on 2016-02-07.
 */
public class RidesController {

    private final Gson gson;
    private final RidesRepository _ridesRepository;

    public RidesController(RidesRepository ridesRepository)
    {
        this._ridesRepository = ridesRepository;
        this.gson = new GsonBuilder().create();
    }

    public String getAll(){
        return gson.toJson(_ridesRepository.GetAll());
    }
}
