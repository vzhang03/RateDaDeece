import java.util.HashMap;
import java.util.ArrayList;

public class Dish {
    String name = "";
    String station = "";

    String id = "";
    RatingMap ratings = new RatingMap();

    public void addRating (Rating r){
        this.ratings.addRating(r);
    }
    public Dish(String name, String station, String id){
        this.id = id;
        this.name = name;
        this.station = station;
    }

    // dish id number
    public void addDishID(String id) { this.id = id; }

    public String summarizeRatings(){
        return this.ratings.summarizeRatings();
    }

}
