package com.example.ratedadeece.model;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

import com.google.gson.*;
import java.util.Set;

public class MenuLoader {
    public String menuJavaScript;
    public String[] splitArray;

    public MenuLoader() {
        this.menuJavaScript = "";
    }

    /**
     * Sends request to Vassar Cafe Bon Appetit
     * loads HTML content as a String into this.menuJavaScript
     */
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


    /**
     * Takes in a URL url, opens connection to url,
     * Sends request for HTML of Vassar Cafe Bon Appetit
     * Returns HTML request as a String
     *
     * @param url
     * @return String
     */
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

    /**
     * Grabs HTML of menu items from Vassar Cafe Bon Appetit
     * Converts Menu items into JSON file
     * Returns JSON file as a JsonObject
     * @return JsonObject
     */
    public JsonObject loadJson() {
        this.loadScript();
        this.splitWord("Bamco.menu_items|Bamco.cor_icons"); // this is able to isolate the menu_items, just need to parse this string
        String s = this.splitArray[1];
        s = s.substring(2);
        s = s.substring(0, (s.length()) - 5); //JSON string of all items

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        JsonElement jsonElement = new JsonParser().parse(s);

        //return Json file as JsonObject
        return jsonElement.getAsJsonObject();
    }


    /**
     * Takes in a Deece d
     * loads the json file using loadJson()
     * makes keySet "keys" of all meals in jsonFile
     * iterates through keyset and uses d.addDish(dish d) for each meal in JSON
     * @param d A Deece object
     */
    public void getMenu(Deece d) {
        JsonObject jsonObject = this.loadJson();
        Set<String> keys = jsonObject.keySet();
        for (String curr : keys) {
            JsonObject menuItem = jsonObject.get(curr).getAsJsonObject();
            String itemId = menuItem.get("id").toString();
            String itemLabel = menuItem.get("label").toString();
            String itemName = itemLabel.substring(1, itemLabel.length() - 1);
            String[] initSplit = menuItem.get("station").toString().split("@");
            String[] secSplit = initSplit[1].split("<");
            String itemStation = secSplit[0];
//            System.out.println("" + itemName + ", " + itemStation + ", " + itemId);
            d.addDish(new Dish(itemName, itemStation, itemId));
        }
    }

}

    /* PARSE ACTUAL MENU -- different meals */
    /* CALL THE DEECE OBJECT -- create different dishes and load them into system so we can rate, etc. */

