A short test report describing how the prototype was tested. For system tests, this should be a textual description of the inputs provided to the system, the outputs received, and whether they match expectations (inclusion of a transcript or screenshots is strongly encouraged). Unit tests will not be required for this iteration. If you want to include them, provide the name of the test class(es), which will then describe the tests using Javadoc (I wrote a JUnit in IntelliJ tutorial, which you may find useful). Create your test report as a file intellij/doc/test-report.md.

****
# Test Report

I tested the functionality of the prototype by primarily focusing on the
rejection of wrong inputs (ratings not between 1-5, strings when asking for numbers, as well as entering commands incorrectly).

When testing incorrect inputs, the prototype was able to handle it as planned and additionally
it was able to execute all of the inputs/desired functionality that I entered into the code. 

****
# Written Transcript

----------------Welcome to RateDaDeece-------------------------

MAIN // Would like to leave a review or view the menu? (reply with "review" for review, "menu" for menu, and "quit" to quit)

asefjlk;sadf

Not a valid input, please try again.

MAIN // Would like to leave a review or view the menu? (reply with "review" for review, "menu" for menu, and "quit" to quit)

139392

Not a valid input, please try again.

MAIN // Would like to leave a review or view the menu? (reply with "review" for review, "menu" for menu, and "quit" to quit)

menu

MENU // OFFERINGS

Eggs: Home - 0 average stars with a total of 0 reviews

Burger: Grill - 0 average stars with a total of 0 reviews

Tofu: Root - 0 average stars with a total of 0 reviews

MAIN // Would like to leave a review or view the menu? (reply with "review" for review, "menu" for menu, and "quit" to quit)

review

DEECE REVIEW // What would you rate the Deece?

dfasa

Invalid input. Please enter a valid integer stars.

DEECE REVIEW // What would you rate the Deece?

01001

Rating must be between 1 and 5.

DEECE REVIEW // What would you rate the Deece?

1

REVIEW OPTIONS // Would you like to review a dish ("review") or exit reviews ("exit")

exit

MAIN // Would like to leave a review or view the menu? (reply with "review" for review, "menu" for menu, and "quit" to quit)

review

DEECE REVIEW // What would you rate the Deece?

3

REVIEW OPTIONS // Would you like to review a dish ("review") or exit reviews ("exit")

review

DISH REVIEW // Which dish would you like to rate

Eggs: Home - 0 average stars with a total of 0 reviews

Burger: Grill - 0 average stars with a total of 0 reviews

Tofu: Root - 0 average stars with a total of 0 reviews

egggggggg

This dish is not on the menu, please try again!

DISH REVIEW // Which dish would you like to rate

Eggs: Home - 0 average stars with a total of 0 reviews

Burger: Grill - 0 average stars with a total of 0 reviews

Tofu: Root - 0 average stars with a total of 0 reviews

eggs

How many stars would you like to give to the eggs?

4

Would like to include a written comment? (enter to skip)

Successfully left review for eggs of 4 stars and with the comment: "".

REVIEW OPTIONS // Would you like to review a dish ("review") or exit reviews ("exit")

exit

MAIN // Would like to leave a review or view the menu? (reply with "review" for review, "menu" for menu, and "quit" to quit)

quit

Have a good day!

Process finished with exit code 0
