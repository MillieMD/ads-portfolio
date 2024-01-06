package Practical_12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class Paper implements Comparable<Paper>{

    private int id;
    private String title;
    private String[] authors;
    private LinkedList<Review> reviews;

    public Paper(int id, String title, String... authors){

        this.id = id;
        this.title = title;
        this.authors = authors;

        reviews = new LinkedList<>();
    }

    /**
     * Add a review to the list,
     * does not allow one review to have multiple reviews on the same paper
     *
     * @param r review to add
     */
    public void addReview(Review r){

        for(Review review: reviews){ // If reviewer already has a review do not allow them to add another
                                     // Divert to update?
            if(review.getReviewer() == r.getReviewer()){
                return;
            }
        }

        // Find correct index in reviews
        int i = 0;
        for(i = 0; i < reviews.size(); i++){

            if(r.compareTo(reviews.get(i)) > 0){ // Sort by descending score
                break;
            }
        }

        // Add review at correct index
        reviews.add(i, r);
        System.out.println(this);
    }

    /**
     * Remove a review from the list
     *
     * @param r review to remove
     */
    private void removeReview(Review r){
        reviews.remove(r);

        System.out.println(this);
    }

    /**
     * Retract a review, given its id
     * @param id id to remove
     */
    public void retractReview(int id){
        removeReview(reviews.get(indexOf(id)));
    }

    /**
     * Update the score of a review based on id
     *
     * @param id id of review to change
     * @param newScore updated score
     * @throws IllegalArgumentException if the updated score is not between 1 and 10
     */
    public void updateReviewScore(int id, int newScore) throws IllegalArgumentException {

        Review oldReview = reviews.get(indexOf(id));
        Review r = new Review(oldReview.getId(), oldReview.getReviewer(), newScore, oldReview.getConfidence(), oldReview.getSummary());

        updateReview(oldReview, r);
    }

    /**
     * Update the confidence of a review based on id
     *
     * @param id id of review to change
     * @param newConfidence updated confidence
     * @throws IllegalArgumentException if the updated confidence is not between 1 and 5
     */
    public void updateReviewConfidence(int id, int newConfidence) throws IllegalArgumentException {

        Review oldReview = reviews.get(indexOf(id));
        Review r = new Review(oldReview.getId(), oldReview.getReviewer(), oldReview.getScore(), newConfidence, oldReview.getSummary());

        updateReview(oldReview, r);
    }

    /**
     * Update the summary of a review based on id
     *
     * @param id id of review to change
     * @param newSummary updated summary
     */
    public void updateReviewSummary(int id, String newSummary) {

        Review oldReview = reviews.get(indexOf(id));
        Review r = new Review(oldReview.getId(), oldReview.getReviewer(), oldReview.getScore(), oldReview.getConfidence(), newSummary);

        updateReview(oldReview, r);
    }

    /**
     * Removes the old review and inserts the new updated review in the correct place
     * Automatically keeping the list sorted
     *
     * @param oldReview Review to remove
     * @param updatedReview New review with updated information
     */
    private void updateReview(Review oldReview, Review updatedReview){

        // Old review is removed, new review is inserted in correct place
        // No need to re-sort
        removeReview(oldReview);
        addReview(updatedReview);
    }

    public int indexOf(int id){
        int i = 0;
        for(i = 0; i < reviews.size(); i++){

            if(reviews.get(i).getId() == id){ // Sort by descending score
                return i;
            }
        }

        return -1;
    }

    public int indexOf(String reviewer){
        int i = 0;
        for(i = 0; i < reviews.size(); i++){

            if(Objects.equals(reviews.get(i).getReviewer(), reviewer)){ // Sort by descending score
                return i;
            }
        }

        return -1;
    }


    /**
     * @return average score, weighted with confidence
     */
    public float getAverageScore(){

        float avg = 0.0f;

        for(Review r : reviews){

            avg += r.getScore() * ((float) r.getConfidence())/5;
        }

        return avg/reviews.size();
    }

    /**
     * Papers can be compared based on their average score
     *
     * @param p the object to be compared.
     * @return Positive or negative integer depending on if it is greater or lesser than
     */
    public int compareTo(Paper p) {

        return (int) (getAverageScore() - p.getAverageScore());
    }

    // Accessors

    /**
     * @return formatted as "{Title} Average Score: {average}" then a list of reviews
     */
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();

        s.append(title).append(" Average Score: ").append(getAverageScore()).append("\n");

        for(Review review : reviews) {
            s.append(review);
        }

        return s.toString();
    }
}