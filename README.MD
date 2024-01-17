# Phase 4 Submission

* For this iteration we worked primarily on implmenting a forum, implementing the user logic to limit reviews to one dish, working on local and online persistence, and finally improving the system UI.
* Forum implementation and functionality: was able to create the forum using a nested hashmap containing an arraylist. This was created in order to build upon the deece currentMenu hashmap. Having originally created this map without using a nested hashmap, this made it hard to organize by date as well as station. In order to allow for easier storage and organization for when we wanted to update the display to be seperated by station I used a nested hashmap datastructure. This forum class also contains a post datastructure, which is meant to keep track of all the necessary elements, including title, post, subject, user id and date created. This forum contains an add post method as well as get methods that are supposed to make it easier to get a day's listings. 
* User logic: in order to allow for users to only vote once on the Deece and the dishes we created the user class and included a hasRated map that keeps track of each dish or listing that has been rated. Using this map, by giving it the ability to reset everyday allows for us to be able to be able to easily keep track of what each user has rated by passing this along through each screen. I also updated the user UI in order to skip the "reviewDeeceFragment" if it has already been rated as well as making it impossible to reach the "reviewDishFragment" screen if a dish has been rated insteading rerouting the user back to the currentMenu or printing a snackbar alert informing the user that they are unable to rerate the deece.  
* Local persistence: the app has also implemented local persistence by saving user elements to the local device. By saving the local user, it keeps track of the users reviews of the day and has the capability to keep track of forum posts as well. While this feature has not completely been utilized outside of keeping track of of what has been reviewed for the day, by designing the user and local persistence in this way it gives the app the ability to implement additional functionaity such as deleting reviews.
* Improvements to view menu UI: for this phase, I focused on improving the menu UI in addition to the already mentioned changes by changing the visual aspect of the UI. In order to make elements clearer and more defined, I removed the buttons and transitioned these into the text itself. While doing so, I improved the formatting of the text in order to allow for the text to display more clearly and structured. I also used colors in order to highlight the different elements making it easier to read the elements. The last thing I did but arguably the most important was to scrap the old menu in order to use a recycler view. This increased the performance dramatically and allowed the menu to be displayed immediately when clicked, making it so that there was no waittime that was present in previous iterations.
* Improvements to user workflow: in order to improve user workflow, I changed aspects of the review system to redirect to the menu when completing the reviews. This made the app a lot less dizzy and made the workflow clearer to use. 


# Limitations
Right now there is a lack of interaction with the forum and users and given more time, this would be the first two things I would handle. 

* Forum limitations: inability to interact with forum posts outside of adding a forum post. I would improve this by creating a page that when clicked would lead to a screen where one could leave another comment or interact with certain comments or the post itself with upvotes or something similar to a reddit style forum. In addition to this, I would make it possible to delete posts or to increase navigation allowing users to go through the posts based on date, subject or even a search system. Not sure how to do this, improved functionality would definitely make it easier to use. 
* User limitations: inability to interact with own reviews or posts. Would want to implement a fuller user system that would allow people to sign in and sign up and create anonymous usernames or profiles in order to display what they are interested in. After this, would want to be able to delete own posts as well as manage different things and possibly use achievements to incentivize app usage. Could also use it to keep track of what eaten and what reviewed by showing a "your meal screen".
* Menu limitations: would want to implement a nested hashmap to make it clearer which dishes are offered at which station and use headers to improve visuals as well as find a way to increase navigation by allowing ways to quickly look between stations. 
* UI limitations: there were a lot of screens that weren't as clear as I thought they could be. The different dish info screens could incorporate recycler views or different types of views that make it easier to display more information in a more structured and formatted way. I also would want to include a dropdown menu using a spinner and would want to unclutter the UI while increasing navigation while also allowing for titles making each different screen more clear. 
* Analytics page/graphs: a big part of what springboarded this idea, I was unable to include graphs in order to graph the overall reviews or the reviews over time. Part of the reason that I wanted to make an app for the "fun aspect" this would also be one of the things that would be fun. 


# Phase 3 Submission

# Functionality implemented 
* For this iteration we worked primarily on the review dish logic and the view menu. We implemented logic to be able to see each dishes reviews as well as being able to leave reviews and comments. After doing so, this updates immediately and you can also see your comments being dispalyed along with the user review.
* We began an analytics screen to display information related to what people are reviewing the Deece
* We were able to work in the menu functionally to be able to load the actual menu and display dishes currently being served. 
* We were able to work in the Deece logic to allow you to review the Deece itself
* We successfully implemented the MVC architecture in order to use fragments to switch screens and included the ability to dynamically generate information on each screen due to the information contained within the system

# Limitations 
* Currently there are a lot limitations in regards to the user logic. One thing we want to incoporate in the future is the ability have user profiles as well as allowing each user to only review each dish once. To do this, we will probably use a similar format to the current dish profile and give users the ability to change their usernames as well as profiles and than displaying their reviews. By doing this, we also create the ability to delete and edit reviews in case they want to increasing the level of acessbility and interactibility. Without this logic it limits what people can do in terms of functionality and hinders our ability to control people reviewing multiple dishes. 
* Currently our analytics page is not done, and when completed we envision it being a space to be able to display the Deece ratings as well as Deece comments, this limits our review system to only include and display dish information which is something we want to create in the next iteration
* Another thing is the formatting and the way that our information loads and is shown. Currently the view menu screen is missing a scrollView because it was breaking my logic, and for the next iteration I want to work on making the buttons a consistent size, and for the dishNames to not include quotes. 
* Another limitation is the persistence, having to constantly load the menu as well as not being able to use local storage limits what we can in terms of storing total reviews and user information and we want to work on this in the next iteration.
* Our test logic in regards to the AddItemsScreen was limited because we were unable to figure out how to access different elements

****
# Functionality Implemented 

This prototype implements the main features of the app being the ability to rate
the Deece and different dishes and also allows for viewing the menu. This prototype 
does it in a scalable way by using a RatingMap data type which allows for different
classes including: Deece, Dish and User to all use the same datatype to store 
ratings organizing it by date to make look-up easier.

A summary of each of the different classes:
* Dish.java: this keeps track of a specific dish info including: name, dishID (created by Cafe Bonappetit),
station and ratings. These ratings are stored in an arrayList and include other
dates in which the dish appeared allowing us to easily present historical data and reviews
later down the line.
* Rating.java: this keeps track of individual ratings including: date created, stars, review,
and ID of the user who created the rating.  
* RatingMap.java: allows for adding reviews, viewing a specific days reviews, viewing 
today's reviews, and a summary function allowing to go through each item to 
present an average rating for a specific day. This RatingMap is organized with a 
String representation of the date as a key and ArrayList of Ratings
as the value. 
* Deece.java: this contains the currentMenu and allDishes and these are mapped by dishName as the key
to a Dish object. This also contains a RatingsMap to store Deece ratings over different days. The 
main functionality of this class is to store those data and allow different functions to edit or change these values.
* User.java: this object is supposed to store an unique userID and two RatingsMaps including
the users Deece ratings and Dish ratings.
* SystemUI: this implements the user-side of the text-based prototype controlling user-flow and 
the various inputs.
* MenuController: this class contains the function for the prototype implementing the desired logic 
and controlling what happens after each input. 
* MenuLoader: this class implements the loading of the Cafe BonAppetit menu. 

****
# Limitations/Simplifying Assumptions

A summary of each of the different classes assumptions/limitations:
* Dish.java: organizing by station is very difficult because station is currently
a nested attribute and when iterating through the currentMenu there is no easy to organize
the dishes by type. This makes printing hard and disorganized and need to figure out a way
to sort dishes by station. 
* UserID class and function: currently this app does not do a good job of implementing the ID function.
Primarily a way to scale up, allowing us to attribute specific reviews to different users
which we can later use to edit and delete, this also allows us to 
easily scale into a forum function which allows us to keep track of posts and ensuring
specific users are not able to send multiple reviews within a defined timespan. This feature
of ensuring users can only send one review can be implmented using boolean attributes. 
* UserID, allDishes and databases/write-files: while allDishes within the Deece class is meant to store 
the data of all dishes it doesn't retain it's data between each run of the prototype.
The same goes for the UserID, it is unable to actually instantiate the classes of UserID 
to ensure that UserIDs are kept between runs. The same goes for if a UserIDDatabase were to be created, 
it is missing a way to store the data between runs using a write-file.
* Connecting the MenuLoader and creating a menu using cafe bonappetit data: currently
while we can instantiate dishes and Deece objects, we are unable to finish parsing the data correctly
in order to load the data and the logic loading the Dish objects into different data structures is not complete.
* Limitations of text-based interface: there are a few limitations associated with using a 
text-based interface, mainly the input of data and easy navigation. One primary function of our app
was to be clean and fun and this unable without the graphical interface because it makes 
specifying inputs and navigation much more cumbersome forcing us to make uncomfortable design decisions. 

****
# Running the Prototype 

You must run the prototype inside the SystemUI.java class. The SystemUI
class contains the main method specifying the text-based prototype when run it 
welcomes you and gives you three options: looking at the menu, review the Deece and dishes, or quit. Representing the
core features of rating the Deece and viewing the menu including the average ratings
after running these three options can be accessed using the commands: "menu", "review", and "quit".

If you enter "menu", what then happens is that the menu is printed with each
dish being printed alongside station and average stars and total number of reviews. 
After this, it leads back to the original prompt with the three options of: menu, review, quit.

If you enter "review", this first leads to a prompt to review the Deece overall.
This question is required and asks for a star rating from 1-5 and rejects any output that 
isn't a number or is not between 1-5. This then leads you to another prompt,
this prompts asks whether you want to review individual dishes or quit the review which you can
then select using the two commands: "review" and "leave". If you choose to
"leave", this returns you to the original screen with the: menu, review, quit screen.
If you choose review the dishes using "review" again, this prints out the menu with ratings
and asks which dish you would like to "review". To review a dish, you have to 
type in the dish name case-insensitive. After you have typed in a dish name, it asks 
for a dish star rating between 1-5. After the star rating, it asks for a optional written review
which can be skipped by not entering any characters. One important thing about the review dishes step
is that requires all of the steps of the review to be entered in the right format, if dishes are spelled wrong
or the rating isn't between 1-5 or a number it rejects the input. You are also unable to quit the 
review during any of the three steps mentioned above.

If you enter "quit", this closes the text-based prototype. 

****
