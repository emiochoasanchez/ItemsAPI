import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Connection {

    public static BufferedReader get(String url1, String username, String token) {

        try {
            URL url = new URL(url1);

            try {
                URLConnection urlConnection = url.openConnection() ;

                urlConnection.setRequestProperty("username",username);
                urlConnection.setRequestProperty("token",token);


                urlConnection.setRequestProperty("Accept", "application/json");
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                if (urlConnection instanceof HttpURLConnection) {

                    HttpURLConnection connection = (HttpURLConnection) urlConnection;
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    Gson gson = new Gson();
                    return in;

                } else {
                    System.out.println("URL invalida");
                    return null;
                }


            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (MalformedURLException exception) {
            //e.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return null;
    }

/*
    public static BufferedReader post(String url2) {

        try {
            URL url = new URL(url2);

            try {
                URLConnection urlConnection = url.openConnection() ;

                    urlConnection.setRequestProperty();

                urlConnection.setRequestProperty("Accept", "application/json");
                urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                if (urlConnection instanceof HttpURLConnection) {

                    HttpURLConnection connection = (HttpURLConnection) urlConnection;
                    connection.setRequestMethod("POST");
                    return  (new BufferedReader(new InputStreamReader(connection.getInputStream())));

                } else {
                    System.out.println("URL invalida");
                    return null;
                }


            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (MalformedURLException exception) {
        ;
            System.out.println(exception.getMessage());
        }
        return null;
    }
*/
}
