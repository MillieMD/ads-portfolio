package Practical_11;

public class Conference {

    public static void main(String[] args) {

        Session oastlerSchedule = new Session(0, "Oastler");
        Session hasslettSchedule = new Session(1, "Hasslett");
        Session bronteSchedule = new Session(2, "Bronte Lecture Theatre");
        Session sparkJonesSchedule = new Session(3, "Spark Jones");

        oastlerSchedule.scheduleTalk(new Talk(0, "a", "Having a Generic Name 101", "2023-11-14T10:30:00"));
        oastlerSchedule.scheduleTalk(new Talk(1, "b", "Having a Generic Name 102", "2023-11-14T11:30:00"));
        oastlerSchedule.scheduleTalk(new Talk(2, "c", "Having a Generic Name 103", "2023-11-14T11:00:00"));
        oastlerSchedule.scheduleTalk(new Talk(3, "d", "Having a Generic Name 104", "2023-11-14T13:30:00"));
        oastlerSchedule.scheduleTalk(new Talk(4, "e", "Having a Generic Name 105", "2023-11-14T09:30:00"));
        oastlerSchedule.scheduleTalk(new Talk(5, "f", "Having a Generic Name 106", "2023-11-15T11:00:00"));
        oastlerSchedule.scheduleTalk(new Talk(6, "g", "Having a Generic Name 107", "2023-11-15T12:00:00"));
        oastlerSchedule.scheduleTalk(new Talk(7, "h", "Having a Generic Name 108", "2023-11-15T10:00:00"));

        System.out.println(oastlerSchedule);

        oastlerSchedule.cancelTalk("Having a Generic Name 107");
        oastlerSchedule.cancelTalk(7);

        System.out.println(oastlerSchedule);

    }
}
