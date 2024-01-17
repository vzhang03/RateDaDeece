import java.util.Set;
import java.util.HashMap;
public class Deece {
    protected HashMap<String, Dish> currentMenu = new HashMap<String, Dish>();

    protected HashMap<String, Dish> allDishes = new HashMap<String, Dish>(); // cloud database vs user id (local)

    protected RatingMap ratings = new RatingMap();

    public Deece (){ }

    public void resetMenu () { this.currentMenu = new HashMap<String, Dish>(); }

    public String getMenu (){ // think about organizing by stations
        StringBuilder res = new StringBuilder();

        for (String key : currentMenu.keySet()) {
            Dish currentDish = currentMenu.get(key);
            res.append(currentDish.name).append(": ").append(currentDish.station).append(" - ").append(currentDish.summarizeRatings()).append("\n");
        }

        return res.toString();
    }
    public void addDish (Dish d){
        // need to rework this to specify whether adding it to the currentMenu or all dishes menu
        // workflow will probably be to reset the dishes in the currentMenu, first look to see if a dish is in the all dishes menu
        // if not in all dishes menu will need to make a new one
        // otherwise will need to access it and add it to the list
        String nameLower = d.name.toLowerCase();
        this.currentMenu.put(nameLower, d);
        this.allDishes.put(nameLower, d);
    }
    /* NEED TO WORK ON THIS AND HOW TO INTEGRATE SAMS PART WITH MY PART */

    public void addDeeceRating (Rating r) {
        this.ratings.addRating(r);
    }

    public void addDishRating (String dishName, Rating r){
        Dish dish = this.currentMenu.get(dishName);
        dish.addRating(r);
    }

    public boolean menuContainsDish(String s){
        String lower = s.toLowerCase();
        return this.currentMenu.containsKey(lower);
    }

    public static void main(String[] args) {
        Deece deece = new Deece ();
        Dish d1 = new Dish("Eggs", "Home", "329392932932");
        Dish d2 = new Dish("Tofu", "Root", "239293923");
        Dish d3 = new Dish("Burger", "Grill", "19392932932");
        deece.addDish(d1);
        deece.addDish(d2);
        deece.addDish(d3);

        System.out.println(deece.getMenu());
    }

}
