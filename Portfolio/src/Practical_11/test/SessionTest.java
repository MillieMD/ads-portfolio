package Practical_11.test;

// Class to test

import Practical_11.Session;
import Practical_11.Talk;

import org.junit.Test;
import static org.junit.Assert.*;

public class SessionTest {

    @Test
    public void testSession(){

        Session s = new Session(0, "");

        assertNotNull(s);
        assertEquals(0, s.getNumOfTalks());

        Talk sample = new Talk (0, "", "", "0001-01-01T00:00:00");
        int currentNumOfTalks = s.getNumOfTalks();

        s.scheduleTalk(sample);
        assertEquals(currentNumOfTalks + 1, s.getNumOfTalks());

        currentNumOfTalks = s.getNumOfTalks();

        s.cancelTalk(sample);
        assertEquals(currentNumOfTalks - 1, s.getNumOfTalks());

        try {
            s.cancelTalk(1); // Remove talk that doesn't exist
        }catch (Exception e){
            fail(); // Shouldn't throw an error at all
        }
    }



}
