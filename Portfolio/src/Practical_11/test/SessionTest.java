package Practical_11.test;

// Class to test

import Practical_11.Session;
import Practical_11.Talk;

import static org.junit.Assert.*;

public class SessionTest {

    public void testScheduleTalk(){

        Session s = new Session(0, "");

        assertNotNull(s);
        assertEquals(0, s.getNumOfTalks());

        Talk sample = new Talk (0, "", "", "0000-00-00T00:00:00");
        int currentNumOfTalks = s.getNumOfTalks();

        s.scheduleTalk(sample);
        assertEquals(currentNumOfTalks + 1, s.getNumOfTalks());

        currentNumOfTalks = s.getNumOfTalks();

        s.cancelTalk(sample);
        assertEquals(currentNumOfTalks - 1, s.getNumOfTalks());
    }

    public void testCancelTalk(){}
    // TODO: test remove when empty
    // TODO: test remove from end
    // TODO: test remove from beginning
}
