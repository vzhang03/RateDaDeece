import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import com.google.gson.*;
import java.util.Iterator;

import java.util.Iterator;
import java.util.Set;

public class MenuLoader {
    public String menuJavaScript;
    public String[] splitArray;
    public HashMap<JsonElement, JsonObject> menuIndex = new HashMap<JsonElement, JsonObject>();

    public MenuLoader() {
        this.menuJavaScript = "";
    }
    public void loadScript (){
        LocalDate today = LocalDate.now();
        String date = today.toString();
        String address = "https://vassar.cafebonappetit.com/cafe/gordon/" + date;

        try {
            URI myUri = URI.create(address);
            URL myUrl = myUri.toURL();
            this.menuJavaScript = sendRequest(myUrl);
        } catch (MalformedURLException e) {
            System.out.println("Caught exception");
        }
    }
    public String sendRequest (URL url){
        String res = "";
        try {
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Set the request method (GET, POST, etc.)
            connection.setRequestMethod("GET");
            // Optional: Set request headers
            connection.setRequestProperty("Content-Type", "application/json");
            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response
            res = response.toString();
            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

        return res;
    }

    public void splitWord(String s){
        this.splitArray = this.menuJavaScript.split(s);
    }






    public static void main(String[] args) {
        Deece d = new Deece();
        MenuLoader m = new MenuLoader();




        //loadScript()
        m.loadScript();
        m.splitWord("Bamco.menu_items|Bamco.cor_icons"); // this is able to isolate the menu_items, just need to parse this string
        String s = m.splitArray[1];
        s = s.substring(2);

        //length of string changes everyday due to changes in the menu
        s = s.substring(0, (s.length()) - 5); //JSON string of all items

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        JsonElement jsonElement = new JsonParser().parse(s);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        // transforms to set
        Set<String> keys = jsonObject.keySet();







        /*
         * Iterates thru set, grabbing id, name, and station
         * then makes a new dish with those attributes
         * then puts dish into Deece.currentMenu hashmap
         * if not in it already, the dish gets put into Deece.allDishes hashmap
         */
        //getInfo()
        for (String curr : keys) {
            JsonObject menuItem = (jsonObject.get(curr).getAsJsonObject());
            String itemId = menuItem.get("id").toString();
            String itemName = menuItem.get("label").toString();
            //need to clean up station name format
            String itemStation = menuItem.get("station").toString();

            // prints out station, name, and ID
            System.out.println(String.format("%1$s,   %2$s,    %3$s", itemName, itemStation, itemId));
//






//            puts new dish object in d.currentMenu
            if (!d.currentMenu.containsKey(itemId)) {
                //d.addDish(new dish)
                d.currentMenu.put(itemId, new Dish(itemName, itemStation, itemId));
            }
            if(!d.allDishes.containsKey(itemId)) {
                d.allDishes.put(itemId, new Dish(itemName, itemStation, itemId));
            }


            //make getMenu(Deece d) method



            /*
             *so i don't forget at lab:
             *
             * maybe delete menuIndex hashmap? didn't use
             * don't exactly know how to clean up station name string
             *
             */

            /* PARSE ACTUAL MENU -- different meals */
            /* CALL THE DEECE OBJECT -- create different dishes and load them into system so we can rate, etc. */
        }
    }
}