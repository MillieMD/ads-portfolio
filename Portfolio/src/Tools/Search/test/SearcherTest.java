package Tools.Search.test;

// Class to test
import Tools.Search.Searcher;
import org.junit.jupiter.api.Test;

// Tools for testing
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public abstract class SearcherTest {

    abstract Integer[] getArray(int size);

    public void testSearch(int size){

        // Generate array and random value to find
        Integer[] array = getArray(size);
        Integer value = array[new Random().nextInt(size)];

        int location = Searcher.search(value, array);

        // Is location in correct range
        assertFalse(location > array.length);
        assertFalse(location < -1);

        // Is location correct
        if(location >= 0){
            assertEquals(array[location], value);
        }

        value = -value; // Minus numbers not in generated array, location MUST be -1
        location = Searcher.search(value, array);

        assertEquals(location, -1);
    }

    @Test
    public void test1(){
        testSearch(1);
    }

    @Test
    public void test10(){
        testSearch(10);
    }

    @Test
    public void test100(){
        testSearch(100);
    }

    @Test
    public void test1000(){
        testSearch(1000);
    }

    @Test
    public void test10000(){
        testSearch(10000);
    }

}
