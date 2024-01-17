import java.time.LocalDate;

public class Rating {
    protected String date;
    protected int stars;
    protected String review;
    protected String id;

    public Rating (){
        LocalDate today = LocalDate.now(); // add test to make sure between 1-5 ?
        this.date = today.toString();
    }
    public Rating(int stars, String review){
        LocalDate today = LocalDate.now(); // add test to make sure between 1-5 ?
        this.date = today.toString();
        this.stars = stars;
        this.review = review;
    }

    public Rating(int stars, String review, String id){
        LocalDate today = LocalDate.now(); // add test to make sure between 1-5 ?
        this.id = id;
        this.date = today.toString();
        this.stars = stars;
        this.review = review;
    }

    public String getDate(){ return this.date; }

    public int getStars(){ return this.stars; }

    public String getReview(){ return this.review; }
    public static void main(String[] args){
        int rating = 5;
        String review = "this food rocks!";
        Rating test = new Rating(rating, review);

        System.out.println("Get Date -- " + test.getDate());
        System.out.println("Get Rating -- " + test.getStars());
        System.out.println("Get review -- " + test.getReview());
    }
}
