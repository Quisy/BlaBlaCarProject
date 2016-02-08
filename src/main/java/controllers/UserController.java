package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import repositories.UserRepository;
import spark.Request;
import spark.Response;

/**
 * Created by Mariusz on 2016-01-30.
 */
public class UserController {


    private final Gson gson;
    private final UserRepository _userRepository;

    public UserController(UserRepository userRepository)
    {
        this._userRepository = userRepository;
        this.gson = new GsonBuilder().create();
    }

    public String login(Request request, Response response) {
        String login = request.params(":login");
        String password = request.params(":password");

        return gson.toJson(_userRepository.Login(login,password));

    }
}
