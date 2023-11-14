package Tools.Sort.test;

import Tools.Sort.Sorter;
import org.junit.jupiter.api.Test;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.fail;

public class SorterTest {

    private Integer[] getArray(int size){

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

    private boolean isSorted(Integer[] array){

        for(int i = 1; i < array.length; i++){

            if(array[i-1] > array[i]){
                return false;
            }
        }

        return true;
    }

    public void testSort(int size){

        for(Sorter.SortingAlgorithm s : Sorter.SortingAlgorithm.values()){

            Integer[] array = getArray(size);

            Sorter.sort(array, s);

            if(!isSorted(array)){

                fail(s + "did not produce a sorted result of size:" + size);

            }
        }
    }

    @Test
    public void test1(){
        testSort(1);
    }

    @Test
    public void test10(){
        testSort(10);
    }

    @Test
    public void test100(){
        testSort(100);
    }

    @Test
    public void test1000(){
        testSort(1000);
    }

    @Test
    public void test10000(){
        testSort(10000);
    }

    @Test
    public void test100000(){
        testSort(100000);
    }


}
