package Tools.Search.test;

import java.util.Random;

public class SequentialSearchTest extends SearcherTest{
    @Override
    Integer[] getArray(int size) {

        Integer[] arr = new Integer[size];
        for(int i = 0; i < size; i++){
            arr[i] = i;
        }

        for(int i = 0; i < size; i++){
            // Select random place in array
            int randomIndex = new Random().nextInt(size);

            // Swap two entries
            int value = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = value;
        }

        return arr;
    }
}
