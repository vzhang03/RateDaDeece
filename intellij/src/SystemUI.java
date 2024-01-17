import java.awt.*;
import java.util.Scanner;

public class SystemUI {

    public enum UserAction {
        INITIAL,
        MENU,
        REVIEW,
        QUIT
    }

    public enum ReviewStatus {
        INITIAL,
        DEECE,
        REVIEW_DISH,
        PROMPT
    }

    public static void main(String[] args) {
        // Controller setup
        MenuController menuController = new MenuController();
        menuController.createMockMenu();
        // System UI setup
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        SystemUI.UserAction userAction = SystemUI.UserAction.INITIAL;
        SystemUI.ReviewStatus reviewStatus = SystemUI.ReviewStatus.INITIAL;

        System.out.println("----------------Welcome to RateDaDeece-------------------------");
        /* Mimicking user behavior, text-based interface */
        while (userAction != SystemUI.UserAction.QUIT){
            System.out.println("MAIN // Would like to leave a review or view the menu? (reply with \"review\" for review, \"menu\" for menu, and \"quit\" to quit)"); // User Prompt
            String userInput = myObj.nextLine();  // Read user input

            switch (userInput.toLowerCase()) {
                case "menu":
                    userAction = SystemUI.UserAction.MENU;
                    break;
                case "review":
                    userAction = SystemUI.UserAction.REVIEW;
                    break;
                case "quit":
                    userAction = SystemUI.UserAction.QUIT;
                    System.out.println("Have a good day!");
                    continue;
                default:
                    System.out.println("Not a valid input, please try again.");
                    continue;
            }

            switch (userAction) {
                case MENU:
                    System.out.println("MENU // OFFERINGS");
                    System.out.println(menuController.getMenu());
                    break;
                case REVIEW:
                    reviewStatus = SystemUI.ReviewStatus.DEECE;

                    while (reviewStatus != SystemUI.ReviewStatus.INITIAL){
                        switch (reviewStatus) {
                            case DEECE:
                                System.out.println("DEECE REVIEW // What would you rate the Deece?");
                                String stringRating = myObj.nextLine();
                                int rating;

                                try {
                                    rating = Integer.parseInt(stringRating);
                                    if (rating < 1 || rating > 5) {
                                        throw new IllegalArgumentException("Rating must be between 1 and 5.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a valid integer stars.");
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                    continue;
                                }

                                menuController.addDeeceRating(rating, "");
                                reviewStatus = SystemUI.ReviewStatus.PROMPT;
                                break;
                            case REVIEW_DISH:
                                System.out.println("DISH REVIEW // Which dish would you like to rate");
                                System.out.println(menuController.getMenu());
                                String dishName = myObj.nextLine();
                                dishName = dishName.toLowerCase();

                                // checks if dish exists
                                if (!menuController.menuContainsDish(dishName)) {
                                    System.out.println("This dish is not on the menu, please try again!");
                                    continue;
                                }

                                // checks if stars is between 1-5
                                int userRatingInt = -1;
                                while (!(userRatingInt <= 5 && userRatingInt >= 1)){
                                    System.out.println("How many stars would you like to give to the " + dishName + "?");
                                    String userRating = myObj.nextLine();
                                    try {
                                        userRatingInt = Integer.parseInt(userRating);
                                        if (userRatingInt < 1 || userRatingInt > 5) {
                                            throw new IllegalArgumentException("Rating must be between 1 and 5.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter a valid integer stars.");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }

                                // Option to leave a written review/comment
                                System.out.println("Would like to include a written comment? (enter to skip)");
                                String comment = myObj.nextLine();

                                menuController.addDishRating(dishName, userRatingInt, comment); // controller
                                System.out.println("Successfully left review for " + dishName + " of " + userRatingInt + " stars and with the comment: \"" + comment + "\".");
                        }

                        System.out.println("REVIEW OPTIONS // Would you like to review a dish (\"review\") or exit reviews (\"exit\")");
                        String reviewInput = myObj.nextLine();

                        reviewStatus = switch (reviewInput.toLowerCase()) {
                            case "review" -> SystemUI.ReviewStatus.REVIEW_DISH;
                            case "exit" -> SystemUI.ReviewStatus.INITIAL;
                            default -> {
                                System.out.println("Invalid input, please try again.");
                                yield reviewStatus; // Use yield to keep the current value
                            }
                        };
                    }
            }
            // reset userAction
            userAction = SystemUI.UserAction.INITIAL;

        }


    }
}
