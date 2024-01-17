package com.example.ratedadeece.view;

public interface IReviewDish {

    /**
     * Interface that classes who need to be notified in case of events happening to the view
     * should implement in order to then be called.
     */
    interface Listener {

        /**
         * Called when review for a specific dish is to be added
         *
         * @param stars stars given to a specific dish
         * @param comment written comment associated to specific dish
         */
        void onReviewDish(String dishName, float stars, String comment);
    }

    /**
     * Returns the screens top level view
     * @return The screen's top level view
     */
//    public View getRootView();

    /**
     * Update display to reflect contents of the sale passed as an argument.
     * @param sale the sale to be displayed
     */
//    void updateSaleDisplay(Sale sale); display dish and fill in with infornation correspondig to dish

}
