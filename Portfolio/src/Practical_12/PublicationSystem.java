package Practical_12;

public class PublicationSystem {

    public static void main(String[] args) {

        Review r = new Review(1, "a", 6, 4, "3rd");
        Review r2 = new Review(2, "b", 5, 5, "4th");
        Review r3= new Review(3, "c", 10, 2, "2nd");

        Paper p = new Paper(0, "Paper title", "John", "Gary", "Other name");

        p.addReview(r);
        p.addReview(r2);
        p.addReview(r3);

        System.out.println(p);

        p.updateReviewScore(3, 2);

        System.out.println(p);
    }
}
