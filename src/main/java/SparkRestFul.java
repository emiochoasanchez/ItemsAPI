import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Collection;

import static spark.Spark.*;

public class SparkRestFul {
    public static void main(String[] args) {

        final IItemService service = new ItemServiceMapImpl();

        get("/items", (req, res) -> {
            res.type("application/json");
            Collection<Item> item = service.getItems();
            return new Gson().toJson(new StandardResponse(
                    StatusResponse.SUCCESS,
                    new Gson().toJsonTree(item)
            ));
        });

        /*
        get("/items/:id", (req, res) -> {
            Item item = service.getItemsByUser(req.params(":id"));
            return new Gson().toJson(new StandardResponse(
                    StatusResponse.SUCCESS,
                    new Gson().toJsonTree(item)
            ));
        });
    */

        get("/item",(req,res) -> {
            res.type("aptplication/json");
            Item item = service.getItemsByUser(req.headers("id"));
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(item)));
        });

        post("/items", (req, res) -> {
            res.type("application/json");
            Item item = new Gson().fromJson(req.body(), Item.class);
            int id = service.addItem(item);
            return new Gson().toJson(new StandardResponse(
                    StatusResponse.SUCCESS,
                    new Gson().toJsonTree(item)));
        });


        get("/sites",(req,res)-> {
            res.type("application/json");
            Site[] sites= new Gson().fromJson(Connection.get("http://localhost:8083/sites"),Site[].class);
            return new Gson().toJson(new StandardResponse(
                    StatusResponse.SUCCESS,
                    new Gson().toJsonTree(sites)
            ));
        });


        // Solicita un user y un pass. Devuelve un token   ¿?
        post("/users", (req,res) -> {
            res.type("application/json");
            BufferedReader br = Connection.post("http://localhost:8083//users", Arrays.asList(new Header[]{new Header("username",req.headers("username")),new Header("password",req.headers("password"))}
            ));
            return new Gson().toJson(new StandardResponse(
                                                            StatusResponse.SUCCESS,
                                                            new Gson().fromJson(br.readLine(),JsonElement.class)
                                                        ));
            });




    }
}
