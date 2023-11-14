package Practical_12;

public class Review implements Comparable<Review>{

    private int id;
    private String reviewer;
    private int score; // 1 - 10
    private int confidence; // 1- 5
    private String summary;

    public Review(int id, String reviewer, int score, int confidence, String summary) throws IllegalArgumentException {

        this.id = id;
        this.reviewer = reviewer;
        this.summary = summary;

        // Limit score to between 1 and 10
        if(score < 1 || score > 10){
            throw new IllegalArgumentException();
        }

        this.score = score;

        // Limit confidence to between 1 and 5
        if(confidence < 0 || confidence > 5){
            throw new IllegalArgumentException();
        }
        this.confidence = confidence;
    }

    /**
     * Rank reviews based on score,
     * if scores are equal rank on confidence
     *
     * @param r the object to be compared.
     */
    @Override
    public int compareTo(Review r){
        if(score == r.score){
            return confidence - r.confidence;
        }

        return score - r.score;
    }

    // Accessors

    public int getId(){
        return id;
    }

    public String getReviewer(){
        return reviewer;
    }

    public int getScore(){
        return score;
    }

    public int getConfidence(){
        return confidence;
    }

    public String getSummary(){
        return summary;
    }

    @Override
    public String toString(){
        return reviewer + " ("+ id +")\n" +
                "Score: " + score + "/10 Confidence: " + confidence + "/5\n" +
                summary +"\n";
    }
}