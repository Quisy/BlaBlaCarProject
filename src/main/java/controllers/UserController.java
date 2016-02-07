package controllers;

import spark.Request;
import spark.Response;

/**
 * Created by Mariusz on 2016-01-30.
 */
public class UserController {

    public String login(Request request, Response response) {
        String login = request.params(":login").toString();
        String password = request.params(":password").toString();

        return "OK";

    }
}
