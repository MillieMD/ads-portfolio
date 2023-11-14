package Tools.Search.test;

public class BinarySearcherTest extends SearcherTest {
    @Override
    Integer[] getArray(int size) { // Sorted Array for binary search

        Integer[] arr = new Integer[size];
        for(int i = 0; i < size; i++){
            arr[i] = i;
        }

        return arr;
    }

}
