import java.util.Scanner;
public class MenuController {

    public Deece deece;
    public User user;

    public MenuController() {
        this.deece = new Deece();
        this.user = new User();
    }

    public void createMockMenu() {
        Dish d1 = new Dish("Eggs", "Home", "23193923");
        Dish d2 = new Dish("Tofu", "Root", "3232399239");
        Dish d3 = new Dish("Burger", "Grill", "2019394");
        this.deece.addDish(d1);
        this.deece.addDish(d2);
        this.deece.addDish(d3);
    }

    public String getMenu(){
        return this.deece.getMenu();
    }

    public void addDeeceRating(int stars, String review){
        Rating r = new Rating(stars, review, this.user.getID());
        this.user.addDeeceRating(r);
        this.deece.addDeeceRating(r);
    }

    public boolean menuContainsDish(String dishName){
        return this.deece.menuContainsDish(dishName.toLowerCase());
    }

    public void addDishRating(String dishName, int stars, String review){
        Rating r = new Rating(stars, review, this.user.getID());
        this.user.addDishRating(r);
        this.deece.addDishRating(dishName, r);
    }



}

