package Practical_11.test;

// Class to be tested
import Practical_11.Talk;

// Necessary for testing
import org.junit.Test;
import static org.junit.Assert.*;

// Utilities
import java.time.LocalDateTime;
import java.util.Random;

public class TalkTest {

    public void testTalk(int id, String speaker, String title){

        LocalDateTime time = LocalDateTime.now();
        Talk t = new Talk(id, speaker, title, time);

        // T is not null
        assertNotNull(t);

        // Test getters
        assertEquals(speaker, t.getSpeaker());
        assertEquals(title, t.getTitle());
        assertEquals(time, t.getStartTime());

        // Test compareTo
        assertEquals(0, t.compareTo(t));

    }

    @Test
    public void test(){

    }


}
