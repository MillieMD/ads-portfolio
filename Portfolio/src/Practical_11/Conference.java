package Practical_11;

public class Conference {

    public static void main(String[] args) {

        // Four sessions
        Session oastlerSchedule = new Session(0, "Oastler");
        Session hasslettSchedule = new Session(1, "Hasslett");
        Session bronteSchedule = new Session(2, "Bronte Lecture Theatre");
        Session sparkJonesSchedule = new Session(3, "Spark Jones");

        oastlerSchedule.scheduleTalk(new Talk(0, "Albert Gorithm", "Stacks & Queues", "2023-11-14T10:30:00"));
        oastlerSchedule.scheduleTalk(new Talk(1, "Sue D. Code", "Java Wrapper Classes", "2023-11-14T11:30:00"));
        oastlerSchedule.scheduleTalk(new Talk(2, "$name", "$title", "2023-11-14T11:00:00"));

        hasslettSchedule.scheduleTalk(new Talk(4, "00100000", "01101110 01101100 01101100", "2023-11-14T10:00:00"));
        hasslettSchedule.scheduleTalk(new Talk(5, "Harry Theodore Mark Lawson", "Poll: Is HTML a programming language?", "2023-11-14T11:00:00"));
        hasslettSchedule.scheduleTalk(new Talk(7, "Stu. K", "How to exit VIM", "2023-11-14T11:30:00"));

        bronteSchedule.scheduleTalk(new Talk(8, "John Smith", "Running Out of Puns 101", "2023-11-13T13:00:00"));
        Talk t = new Talk(9, "SELECT name WHERE id = 2;", "51 First Databases", "2023-11-13T10:00:00");
        bronteSchedule.scheduleTalk(t);

        sparkJonesSchedule.scheduleTalk(new Talk(10, "U2259541", "New Talk", "2023-11-13T10:00:00"));
        sparkJonesSchedule.scheduleTalk(new Talk(11, "U2259541", "New Talk(1)", "2023-11-13T10:10:00"));
        sparkJonesSchedule.scheduleTalk(new Talk(12, "U2259541", "New Talk(1) Copy", "2023-11-13T10:11:00"));
        sparkJonesSchedule.scheduleTalk(new Talk(13, "U2259541", "New Talk(1) Copy (1)", "2023-11-13T10:23:00"));
        sparkJonesSchedule.scheduleTalk(new Talk(14, "U2259541", "New Talk(1) Copy (1) final", "2023-11-13T11:30:00"));
        sparkJonesSchedule.scheduleTalk(new Talk(15, "U2259541", "New Talk(1) Copy (1) final FINAL", "2023-11-13T11:36:00"));

        System.out.println(oastlerSchedule);
        System.out.println(hasslettSchedule);
        System.out.println(bronteSchedule);
        System.out.println(sparkJonesSchedule);

        System.out.println("Schedule updated pending....");

        hasslettSchedule.cancelTalk(5); // Talks can be cancelled using talk ID
        // Hasslett final count: 2 talks

        bronteSchedule.cancelTalk(t); // Talks can be cancelled using object
        // Bronte final count: 1 talks

        sparkJonesSchedule.cancelTalk("New Talk");
        sparkJonesSchedule.cancelTalk("New Talk(1)"); // Talks can be cancelled using title
        // Spark Jones final count: 4

        System.out.println("Schedule updated successfully!");

        System.out.println(oastlerSchedule);
        System.out.println(hasslettSchedule);
        System.out.println(bronteSchedule);
        System.out.println(sparkJonesSchedule);





    }
}
