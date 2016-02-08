/**
 * Created by Mariusz on 2016-01-30.
 */

import Utils.DataBase;
import Utils.DataManager;
import controllers.RidesController;
import controllers.UserController;
import repositories.RidesRepository;
import repositories.UserRepository;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;


public class Main {




    public static void main(String[] args) {

        //DataGenerator.GenerateData();

        final DataBase dataBase = DataManager.load();

        RidesRepository ridesrepository= new RidesRepository(dataBase);
        UserRepository userrepository = new UserRepository(dataBase);

        UserController userController = new UserController(userrepository);
        RidesController ridesController = new RidesController(ridesrepository);


        staticFileLocation("/public");
        get("/hello", (request, response) -> "Hello World");
        get("/user/login/:login/pw/:password", (request, response) -> userController.login(request, response));
        get("/rides/getAll", (request, response) -> ridesController.getAll());
        get("/rides/getByUser/:login", (request, response) -> ridesController.GetByUser(request, response));
        get("/rides/join/:id/:login", (request, response) -> ridesController.Join(request, response));
        get("/rides/leave/:id/:login", (request, response) -> ridesController.Leave(request, response));
        get("/rides/getOrdered/:login", (request, response) -> ridesController.GetOrdered(request, response));

    }
}
