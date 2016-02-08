package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import repositories.RidesRepository;
import spark.Request;
import spark.Response;

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

    public String getAll()
    {
        return gson.toJson(_ridesRepository.GetAll());
    }

    public String GetByUser(Request request, Response response)
    {
        String login = request.params(":login");
        return gson.toJson(_ridesRepository.GetByUser(login));
    }

    public String Join(Request request, Response response)
    {
        long id = Integer.parseInt(request.params(":id"));
        String login = request.params(":login");

        return gson.toJson(_ridesRepository.Join(id,login));

    }

    public String Leave(Request request, Response response)
    {
        long id = Integer.parseInt(request.params(":id"));
        String login = request.params(":login");

        return gson.toJson(_ridesRepository.Leave(id,login));

    }

    public String GetOrdered(Request request, Response response)
    {
        String login = request.params(":login");
        return gson.toJson(_ridesRepository.GetOrderedRides(login));
    }
}
