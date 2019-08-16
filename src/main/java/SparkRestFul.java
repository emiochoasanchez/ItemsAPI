import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Collection;

import static spark.Spark.*;

public class SparkRestFul {

    public static void main(String[] args) {


        final IItemService service = new ItemServiceMapImpl();
        /*
        get("/items", (req, res) -> {
            res.type("application/json");
            Collection<Item> item = service.getItems();
            return new Gson().toJson(new StandardResponse(
                    StatusResponse.SUCCESS,
                    new Gson().toJsonTree(item)
            ));
        });



        get("/item",(req,res) -> {
            res.type("aptplication/json");
            Item item = service.getItemsByUser(req.headers("id"));
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(item)));
        });

    */


        get("/sites",(req,res)-> {
            res.type("application/json");
            Site[] sites= new Gson().fromJson(Connection.get("http://localhost:8083/sites",
                                            req.headers("username"),
                                            req.headers("token")),
                                            Site[].class);
            return new Gson().toJson(new StandardResponse(
                    StatusResponse.SUCCESS,
                    new Gson().toJsonTree(sites)
            ));
        });




        get("/items", (req, res) -> {
            res.type("application/json");
            Collection<Item> item = service.getItems();
            return new Gson().toJson(new StandardResponse(
                    StatusResponse.SUCCESS,
                    new Gson().toJsonTree(item)
            ));
        });


        get("/items/:id", (req, res) -> {
            Collection<Item> item = service.getItemByUser(req.params(":id"));

            return new Gson().toJson(new StandardResponse(
                    StatusResponse.SUCCESS,
                    new Gson().toJsonTree(item)
            ));
        });

        get("/sites/:id/categories",(req,res)-> {
            res.type("application/json");
            String id= req.params(":id");
            Category[] cat= new Gson().fromJson(Connection.get("http://localhost:8083/sites/"+id+"/categories",
                    req.headers("username"),
                    req.headers("token")),
                    Category[].class);
            return new Gson().toJson(new StandardResponse(
                    StatusResponse.SUCCESS,
                    new Gson().toJsonTree(cat)
            ));
        });


        post("/items", (req,res) -> {
            res.type("application/json");
            Item item = new Gson().fromJson(req.body(),Item.class);
            String id = service.addItem(item.getId(),item);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(item)));
        });


    }
}
