package Tools.Sort;

import java.util.Arrays;

public class Sorter{

    public enum SortingAlgorithm { BubbleSort, SelectionSort, InsertionSort, MergeSort, QuickSort}

    private static <T extends Comparable<? super T>> void swap(T[] array, int from, int to){
        T tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    private static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
        for (int lastUnsorted = array.length - 1;  // the whole list is unsorted
             lastUnsorted > 0; // stop when the whole list is sorted
             lastUnsorted--) { // one new element sorted each time round

            for (int nextToCompare = 0; // start comparing the first two elements
                 nextToCompare < lastUnsorted; // stop at the end of the unsorted portion
                 nextToCompare++) { // move to the next element

                if (array[nextToCompare].compareTo(array[nextToCompare + 1]) > 0) {
                    // the elements are in the wrong order so swap them around
                    swap(array,nextToCompare,nextToCompare+1);
                }
            }
        }
    }

    private static <T extends Comparable<? super T>> void selectionSort(T[] array) {
        for (int lastUnsorted = array.length - 1; // the whole list is unsorted
             lastUnsorted > 0; // stop when the whole list is sorted
             lastUnsorted--) { // one new element sorted each time round

            int index = lastUnsorted; // set last element as largest unsorted element

            for (int nextToCompare = 0; // start comparing the first element
                 nextToCompare < lastUnsorted; // stop at the end of the unsorted portion
                 nextToCompare++) { // move to the next element

                if (array[nextToCompare].compareTo(array[index]) > 0) {
                    // A larger unsorted element was found, update index
                    index = nextToCompare;
                }
            }
            // Swap elements, move largest element to the end of unsorted list
            swap(array, index, lastUnsorted);
        }
    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] array) {
        for (int sorted = 0; // only the first element is sorted
             sorted < array.length - 1; // stop when the whole list is sorted
             sorted++) { // one new element sorted each time round

            T newElement = array[sorted + 1]; // first unsorted element

            int compareTo = sorted; // start by comparing last sorted
            while (compareTo >= 0 && // move until the start of sorted list
                    newElement.compareTo(array[compareTo]) < 0) {

                // move gap to the left
                array[compareTo + 1] = array[compareTo];
                compareTo--;
            }
            // put unsorted element into gap
            array[compareTo + 1] = newElement;
        }
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] array) {
        // Apply merge sort as long as there are at least two
        // elements in the array
        if (array.length < 2) {
            return;
        }

        // Create a copy of lower and upper arrays
        T[] lowerArray = Arrays.copyOfRange(array, 0, array.length / 2);
        T[] upperArray = Arrays.copyOfRange(array, array.length / 2, array.length);

        // Call merge sort recursively on lower array
        mergeSort(lowerArray);
        // Call merge sort recursively on upper array
        mergeSort(upperArray);
        // merge lower and upper arrays into the initial array
        merge(array, lowerArray, upperArray);
    }

    private static <T extends Comparable<? super T>> void merge(T[] array, T[] lowerArray, T[] upperArray) {
        int arrayIndex = 0, lowerIndex = 0, upperIndex = 0;

        // gradually merge lowerArray and upperArray into array
        while (lowerIndex < lowerArray.length && upperIndex < upperArray.length) {
            // lowerArray has the minimum value
            if (lowerArray[lowerIndex].compareTo(upperArray[upperIndex]) < 0) {
                array[arrayIndex] = lowerArray[lowerIndex++];
            } else {
                array[arrayIndex] = upperArray[upperIndex++];
            }
            arrayIndex++;
        }

        // lowerArray has some values left (upperArray is empty)
        while (lowerIndex < lowerArray.length) {
            array[arrayIndex] = lowerArray[lowerIndex];
            lowerIndex++;
            arrayIndex++;
        }

        // upperArray has some values left (lowerArray is empty)
        while (upperIndex < upperArray.length) {
            array[arrayIndex] = upperArray[upperIndex];
            upperIndex++;
            arrayIndex++;
        }
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] array, int low, int high) {
        // Apply quick sort as long as there are at least two elements
        // in the current subset of the array
        if (low < high) {
            // Partition the subset of the array into three parts
            // (small, pivot, large). Pivot element is placed
            // in the correct position
            int pivot_index = partition(array, low, high);

            // Call quick sort recursively on lower part
            quickSort(array, low, pivot_index  - 1);
            // Call quick sort recursively on upper part
            quickSort(array, pivot_index  + 1, high);
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] array, int low, int high) {

        T pivot = array[high]; // choose pivot
        int store = low; // start from low

        for (int i = low; i <= high - 1; i++) {
            // Move elements that are smaller than the pivot to the
            // left of the correct position of the pivot
            if (array[i].compareTo(pivot) < 0) {
                swap(array, store, i); // swap small elements
                store++; // move index to the right
            }
        }

        // Place pivot in correct position
        swap(array, store, high);

        //Tools.Print.array(array, array.length);
        return store;
    }

    public static <T extends Comparable<? super T>> void sort(T[] array, Sorter.SortingAlgorithm sortingAlgorithm) {

        System.out.println("Array before sorting: " + Arrays.toString(array));

        switch (sortingAlgorithm) {
            case BubbleSort -> bubbleSort(array);
            case SelectionSort -> selectionSort(array);
            case InsertionSort -> insertionSort(array);
            case MergeSort -> mergeSort(array);
            case QuickSort -> quickSort(array, 0, array.length - 1);
            default -> System.out.println("Please choose a sorting algorithm");
        }

        System.out.println("Array after sorting:  " + Arrays.toString(array));

    }

}
