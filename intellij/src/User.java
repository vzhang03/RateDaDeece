import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
public class User {

    String id;
    RatingMap dishRatings = new RatingMap();
    RatingMap deeceRatings = new RatingMap();

    public User (){
        int userIdLength = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // You can include more characters if needed
        Random random = new Random();

        StringBuilder userId = new StringBuilder(userIdLength);
        for (int i = 0; i < userIdLength; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            userId.append(randomChar);
        }

        this.id = userId.toString();
    }

    public String getID(){ return this.id; }

    public void addDishRating(Rating r){
        this.dishRatings.addRating(r);
    }

    public void addDeeceRating(Rating r){
        this.deeceRatings.addRating(r);
    }

    public static void main(String[] args){
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();

        System.out.println("User 1: " + u1.getID());
        System.out.println("User 2: " + u2.getID());
        System.out.println("User 3: " + u3.getID());
    }
}
