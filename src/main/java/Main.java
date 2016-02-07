/**
 * Created by Mariusz on 2016-01-30.
 */

import controllers.UserController;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;


public class Main {




    public static void main(String[] args) {

        UserController userController = new UserController();

        DataGenerator.GenerateData();

        staticFileLocation("/public");
        get("/hello", (req, res) -> "Hello World");
        get("/user/login/:login/pw/:password", (request, response) -> userController.login(request, response));
        //get("/user/login/:login/password/:password", (UserController::login));

    }
}
