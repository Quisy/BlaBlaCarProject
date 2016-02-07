/**
 * Created by Mariusz on 2016-01-30.
 */

import Utils.DataBase;
import Utils.DataGenerator;
import Utils.DataManager;
import controllers.RidesController;
import controllers.UserController;
import repositories.RidesRepository;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;


public class Main {




    public static void main(String[] args) {

        DataGenerator.GenerateData();

        final DataBase dataBase = DataManager.load();

        RidesRepository ridesrepository= new RidesRepository(dataBase);

        UserController userController = new UserController();
        RidesController ridesController = new RidesController(ridesrepository);




        staticFileLocation("/public");
        get("/hello", (request, response) -> "Hello World");
        get("/user/login/:login/pw/:password", (request, response) -> userController.login(request, response));
        get("/rides/getAll", (request, response) -> ridesController.getAll());

    }
}
