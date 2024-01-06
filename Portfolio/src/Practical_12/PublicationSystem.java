package Practical_12;

public class PublicationSystem {

    public static void main(String[] args) {

        Paper p1 = new Paper(1, "Paper 1", "John A.", "John B.");
        Paper p2 = new Paper(2, "Paper 2", "Alex", "Benjamin", "Charles", "David");
        Paper p3 = new Paper(3, "Paper 3", "Zander", "Yara", "Wesley");

        p1.addReview(new Review(1, "Alex", 6, 3, "Needs more work"));
        p1.addReview(new Review(2, "Yara", 8, 4, "Very cool!"));

        p1.updateReviewScore(2, 6);
        p1.updateReviewSummary(2, "Reread it, changed my mind");

        p2.addReview(new Review(1, "Wesley", 1, 1, "Dreadful"));
        p2.addReview(new Review(2, "John A.", 5, 3, "Mid."));
        p2.addReview(new Review(3, "John B.", 3, 2, "Honestly, just start again"));

        p2.retractReview(1);

        p3.addReview(new Review(1, "John B.", 7, 4, "Getting there"));
        p3.addReview(new Review(2, "Benjamin", 9, 5, "Points retracted for spelling mistake on page 43"));
        p3.addReview(new Review(3, "Zander", 10, 5, "Superb"));
        p3.addReview(new Review(4, "Charles", 8, 3, "Great work"));

        p3.retractReview(2);
        p3.updateReviewConfidence(4, 4);

        System.out.println("The award for best paper goes to....");

        Paper[] papers = {p1, p2, p3};
        Paper bestPaper = papers[0];
        for (Paper p: papers) {

            if(p.compareTo(bestPaper) > 0){
                bestPaper = p;
            }

        }

        System.out.println(bestPaper);

    }
}
